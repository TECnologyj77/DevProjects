package com.example.thomas.bootcamplocator.Activities;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.example.thomas.bootcamplocator.Fragments.MainFragment;
import com.example.thomas.bootcamplocator.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.model.LatLng;

public class MapsActivity extends FragmentActivity implements GoogleApiClient.OnConnectionFailedListener, GoogleApiClient.ConnectionCallbacks, LocationListener {

    final int PERMISION_LOCATION = 111;
    private GoogleApiClient googleApiClient;
    private MainFragment mainFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        googleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addConnectionCallbacks(this)
                .addApi(LocationServices.API)
                .build();

      mainFragment = (MainFragment)getSupportFragmentManager().findFragmentById(R.id.container_main);

        if(mainFragment== null) {
            mainFragment = MainFragment.newInstance();

            getSupportFragmentManager().beginTransaction().add(R.id.container_main, mainFragment).commit();
        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISION_LOCATION );
            Log.v("DONKEY", "Requesting Permissions");
        }
        else{
            Log.v("PINE", "Starting Location Services from onConnected");
            startLocationServices();
        }

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onLocationChanged(Location location) {

        Log.v("PINE", "Latitude: " + location.getLatitude() + " Longitude: " + location.getLongitude());
        mainFragment.setUserMarker(new LatLng(location.getLatitude(),location.getLongitude()));
    }

    @Override
    protected void onStart() {
        googleApiClient.connect();
        super.onStart();
    }

    @Override
    protected void onStop() {
        googleApiClient.disconnect();
        super.onStop();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode){
            case PERMISION_LOCATION:{
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Log.v("PINE", "Permission granted, starting Services");
                    startLocationServices();
                } else{
                    //show a dialog saying something like, "I can't run your location dummy, you denied permission!"
                    Log.v("PINE", "Permission not granted");
                }
            }
        }
    }


    public void startLocationServices(){
        Log.v("PINE", "Starting Location Services Called");

        try{
            LocationRequest req = LocationRequest.create().setPriority(LocationRequest.PRIORITY_LOW_POWER);
            LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, req, this);
            Log.v("PINE", "Requesting location updates");
        }catch (SecurityException excecption){
            //Show dialogue to user saying we can't get location ulness they give app permission
            Log.v("PINE", excecption.toString());
        }

    }

}
