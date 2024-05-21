package com.example.itour_release;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;

public class LocationItem implements Serializable {
    private LatLng position;
    private String title;
    private int iconResourceId;

    public LocationItem(LatLng position, String title, int iconResourceId) {
        this.position = position;
        this.title = title;
        this.iconResourceId = iconResourceId;
    }

    public LatLng getPosition() {
        return position;
    }

    public String getTitle() {
        return title;
    }

    public int getIconResourceId() {
        return iconResourceId;
    }
}