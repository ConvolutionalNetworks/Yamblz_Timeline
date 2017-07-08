package com.mobilization.yamblz_timeline.domain;

import java.util.List;

/**
 * Created by Алексей on 08.07.2017.
 */

public class Teacher {

    private String name;
    private String photoPath;
    private List<School> schools;
    private String telegram;


    public Teacher(String name, String photoPath, List<School> schools, String telegram) {
        this.name = name;
        this.photoPath = photoPath;
        this.schools = schools;
        this.telegram = telegram;
    }

    public String getName() {
        return name;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public List<School> getSchool() {
        return schools;
    }

    public String getTelegram() {
        return telegram;
    }
}
