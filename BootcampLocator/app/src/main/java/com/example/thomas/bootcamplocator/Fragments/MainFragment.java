package com.example.thomas.bootcamplocator.Fragments;


import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.example.thomas.bootcamplocator.Model.DevSlopes;
import com.example.thomas.bootcamplocator.R;
import com.example.thomas.bootcamplocator.Services.DataService;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment  implements OnMapReadyCallback {

    private GoogleMap mMap;
    private MarkerOptions userMarker;
    private LocationsListFragment listFragment;


    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_main, container, false);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager() //gets manager of the fragment (here) and this is what you want to attach your maps to, not the MainActivity's SupportManager
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        listFragment = (LocationsListFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.container_location_list);
        if(listFragment == null){
            listFragment = LocationsListFragment.newInstance();
            getActivity()
                    .getSupportFragmentManager()
                    .beginTransaction().add(R.id
                    .container_location_list, listFragment)
                    .commit();
        }

        final EditText zipText = (EditText) view.findViewById(R.id.zipText);

        zipText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if((event.getAction() == KeyEvent.ACTION_DOWN)&& keyCode == KeyEvent.KEYCODE_ENTER){
                    //You should make sure this is a valid zipcode -- check total character amount
                    String text = zipText.getText().toString();
                    int zip = Integer.parseInt(text);

                    InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE); //quick way to dismiss keyboard
                    inputMethodManager.hideSoftInputFromWindow(zipText.getWindowToken(), 0); //hiding soft keyboard

                    showList();
                    updateMapForZip(zip);

                    return  true;
                }

                return false;
            }
        });
           hideList();
        return view;
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
    }

    public void setUserMarker(LatLng latLng){

        if(userMarker == null){
            userMarker = new MarkerOptions().position(latLng).title("Current Location");
            mMap.addMarker(userMarker);
            Log.v("PINAPPLE", "Current Location" + latLng.latitude + " " + latLng.longitude);
        }

        try {
            Geocoder geocoder = new Geocoder(getContext(), Locale.getDefault());
            List<Address> addressList = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1);
            int zip = Integer.parseInt(addressList.get(0).getPostalCode());
            updateMapForZip(zip);
        }catch (IOException e){

        }


           updateMapForZip(15237);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));

    }


    private void updateMapForZip(int zipcode){
        ArrayList<DevSlopes> locations = DataService.getInstance().getBootcampLocationsWithin10MilesOfZip(zipcode);

        for(int x = 0 ; x < locations.size(); x++){
            DevSlopes loc = locations.get(x);
            MarkerOptions marker = new MarkerOptions().position(new LatLng(loc.getLatitude(), loc.getLongitdue()));
            marker.title(loc.getLocationTitle());
            marker.snippet(loc.getLocationAddress());
            marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.map_pin));
            mMap.addMarker(marker);
        }
    }

    private void hideList(){
        getActivity().getSupportFragmentManager().beginTransaction().hide(listFragment).commit();
    }

    private void showList(){
        getActivity().getSupportFragmentManager().beginTransaction().show(listFragment).commit();
    }


}
