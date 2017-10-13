package com.example.thomas.bootcamplocator.Model;

/**
 * Created by Thomas on 4/1/2017.
 */

public class DevSlopes {

    private float longitdue;
    private float latitude;
    private String locationTitle;
    private String locationAddress;
    private String locationImUrl;

    final String DRAWABLE = "drawable/";

    public String getImgURL(){
        return DRAWABLE + locationImUrl;
    }


    public DevSlopes(float latitude, float longitdue,String locationTitle, String locationAddress, String locationImUrl ) {
        this.longitdue = longitdue;
        this.locationImUrl = locationImUrl;
        this.locationAddress = locationAddress;
        this.locationTitle = locationTitle;
        this.latitude = latitude;
    }

    public float getLongitdue() {
        return longitdue;
    }

    public float getLatitude() {
        return latitude;
    }

    public String getLocationTitle() {
        return locationTitle;
    }

    public String getLocationAddress() {
        return locationAddress;
    }

    public String getLocationImUrl() {
        return locationImUrl;
    }
}
