package com.example.thomas.bootcamplocator.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thomas.bootcamplocator.Adaptors.LoactionsAdaptor;
import com.example.thomas.bootcamplocator.R;
import com.example.thomas.bootcamplocator.Services.DataService;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LocationsListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LocationsListFragment extends Fragment {



    public LocationsListFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static LocationsListFragment newInstance() {
        LocationsListFragment fragment = new LocationsListFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =   inflater.inflate(R.layout.fragment_locations_list, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_locations);
        recyclerView.setHasFixedSize(true);

        LoactionsAdaptor loactionsAdaptor = new LoactionsAdaptor(DataService.getInstance().getBootcampLocationsWithin10MilesOfZip(15944));
        recyclerView.setAdapter(loactionsAdaptor);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);

        return view;
    }

}
