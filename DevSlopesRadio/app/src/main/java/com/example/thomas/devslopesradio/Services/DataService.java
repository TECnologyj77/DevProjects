package com.example.thomas.devslopesradio.Services;

import com.example.thomas.devslopesradio.Models.Station;

import java.util.ArrayList;

/**
 * Created by Thomas on 2/20/2017.
 */
public class DataService {
    private static DataService ourInstance = new DataService();

    public static DataService getInstance() {
        return ourInstance;
    }

    private DataService() {
    }

    public ArrayList<Station> getFeaturedStations(){
        //Pretend we are downloading featured stations from the internet

        ArrayList<Station> list = new ArrayList<>();
        list.add(new Station("Flight Plan: Tunes for Travel","flightplanmusic"));
        list.add(new Station("Two-Wheelin': Biking Playlist", "bicyclemusic"));
        list.add(new Station("Kids James: Music for Children", "kidsmusic"));

        return list;
    }

    public ArrayList<Station> getRecentStations() {

        ArrayList<Station> list = new ArrayList<>();
        return list;
    }

    public ArrayList<Station> getPartyStations(){
        ArrayList<Station> list = new ArrayList<>();
        return list;
    }
}
