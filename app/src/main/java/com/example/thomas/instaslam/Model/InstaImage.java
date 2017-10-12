package com.example.thomas.instaslam.Model;

import android.net.Uri;

import java.net.URI;

/**
 * Created by Thomas on 3/16/2017.
 */

public class InstaImage {

    private Uri imgResourceUrl;

    public InstaImage(Uri imgResourceUrl) {
        this.imgResourceUrl = imgResourceUrl;
    }

    public Uri getImgResourceUrl() {
        return imgResourceUrl;
    }
}
