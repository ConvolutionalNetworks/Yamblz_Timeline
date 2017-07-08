package com.mobilization.yamblz_timeline.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Алексей on 08.07.2017.
 */

class PlaceObject {

    @SerializedName("description")
    private String description;
    @SerializedName("lat")
    private double lat;
    @SerializedName("lon")
    private double lon;
    @SerializedName("name")
    private String name;

    public String getDescription() {
        return description;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public String getName() {
        return name;
    }
}
