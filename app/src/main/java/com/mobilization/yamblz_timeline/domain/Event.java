package com.mobilization.yamblz_timeline.domain;

import java.util.List;

/**
 * Created by Алексей on 08.07.2017.
 */

public class Event {


    private String location;
    private LocationLink locationLink;
    private String title;
    private long timestamp;
    private List<School> schools;
    private List<Teacher> teachers;

    public Event(String location, LocationLink locationLink, String title, long timestamp, List<School> schools, List<Teacher> teachers) {
        this.location = location;
        this.locationLink = locationLink;
        this.title = title;
        this.timestamp = timestamp;
        this.schools = schools;
        this.teachers = teachers;
    }

    public String getLocation() {
        return location;
    }

    public String getTitle() {
        return title;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public List<School> getSchools() {
        return schools;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public LocationLink getLocationLink() {
        return locationLink;
    }
}
