package com.mobilization.yamblz_timeline.domain;

/**
 * Created by Алексей on 08.07.2017.
 */

class Teacher {

    private String name;
    private String photoPath;
    private School school;
    private String telegram;


    public Teacher(String name, String photoPath, School school, String telegram) {
        this.name = name;
        this.photoPath = photoPath;
        this.school = school;
        this.telegram = telegram;
    }

    public String getName() {
        return name;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public School getSchool() {
        return school;
    }

    public String getTelegram() {
        return telegram;
    }
}
