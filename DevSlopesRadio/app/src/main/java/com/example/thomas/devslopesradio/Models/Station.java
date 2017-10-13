package com.example.thomas.devslopesradio.Models;

/**
 * Created by Thomas on 2/20/2017.
 */

public class Station {
    final String DRAWABLE = "drawable/";
    private String stationTitle;
    private String imageUri;

    public Station(String stationTitle, String imageUri) {
        this.stationTitle = stationTitle;
        this.imageUri = imageUri;
    }

    public String getImageUri() {
        return DRAWABLE + imageUri;
    }

    public String getStationTitle() {
        return stationTitle;
    }

}
