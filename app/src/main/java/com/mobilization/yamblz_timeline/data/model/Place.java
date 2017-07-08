package com.mobilization.yamblz_timeline.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Алексей on 08.07.2017.
 */

class Place {

    @SerializedName("name")
    private String name;
    @SerializedName("objects")
    private List<PlaceObject> placeObjects;

    public String getName() {
        return name;
    }

    public List<PlaceObject> getPlaceObjects() {
        return placeObjects;
    }
}
