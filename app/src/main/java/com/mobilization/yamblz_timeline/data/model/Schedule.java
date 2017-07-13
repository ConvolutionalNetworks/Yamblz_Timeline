package com.mobilization.yamblz_timeline.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Алексей on 08.07.2017.
 */

public class Schedule {

    @SerializedName("duration")
    private float duration;
    @SerializedName("location")
    private String location;
    @SerializedName("schools")
    private List<String> schools;
    @SerializedName("teacher")
    private List<String> teachers;
    @SerializedName("time")
    private String time;
    @SerializedName("title")
    private String title;


    public float getDuration() {
        return duration;
    }

    public String getLocation() {
        return location;
    }

    public List<String> getSchools() {
        return schools;
    }

    public List<String> getTeachers() {
        return teachers;
    }

    public String getTime() {
        return time;
    }

    public String getTitle() {
        return title;
    }
}
