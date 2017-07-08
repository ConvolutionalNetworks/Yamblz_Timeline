package com.mobilization.yamblz_timeline.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Алексей on 08.07.2017.
 */

class People {

    @SerializedName("birthday")
    private String birthday;
    @SerializedName("name")
    private String name;
    @SerializedName("roles")
    private List<String> roles;
    @SerializedName("schools")
    private List<String> schools;
    @SerializedName("telegram")
    private String telegram;

    public String getBirthday() {
        return birthday;
    }

    public String getName() {
        return name;
    }

    public List<String> getSchools() {
        return schools;
    }

    public String getTelegram() {
        return telegram;
    }

    public List<String> getRoles() {
        return roles;
    }
}
