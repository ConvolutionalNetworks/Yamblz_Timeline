package com.mobilization.yamblz_timeline.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Алексей on 08.07.2017.
 */

public class DataJson {

    /*
    "people":[  ],
   "places":[  ],
   "schedule":[  ]
     */

    @SerializedName("people")
    private List<People> peoples;
    @SerializedName("places")
    private List<Place> places;
    @SerializedName("schedule")
    private List<Schedule> schedules;

    public List<People> getPeoples() {
        return peoples;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }
}
