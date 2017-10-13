package com.example.thomas.bootcamplocator.Services;

import com.example.thomas.bootcamplocator.Model.DevSlopes;

import java.util.ArrayList;

/**
 * Created by Thomas on 4/1/2017.
 */
public class DataService {
    private static DataService instance = new DataService();

    public static DataService getInstance() {
        return instance;
    }

    private DataService() {

    }

    public ArrayList<DevSlopes> getBootcampLocationsWithin10MilesOfZip(int zipcode){
        //pretend we are downloading data from a server

        ArrayList<DevSlopes> list = new ArrayList<>();
        list.add(new DevSlopes(40.572934f, -80.012966f, "UPMC Passavant Cardiovascular Center", "9100 Babcock Blvd, Pittsburgh, PA 15237", "slo" ));
        list.add(new DevSlopes(40.583216f, -79.996893f, "Presidential Arms Apartments", "9815 Presidential Dr, Allison Park, PA 15101", "slo" ));
        list.add(new DevSlopes(40.567326f, -80.018054f, "Club at North Hills", "700 Duncan Ave, Pittsburgh, PA 15237", "slo" ));
        list.add(new DevSlopes(40.428946f, -79.981647f, "Jimmy D's", "1707 E Carson St, Pittsburgh, PA 15203", "slo" ));

        return list;

    }
}
