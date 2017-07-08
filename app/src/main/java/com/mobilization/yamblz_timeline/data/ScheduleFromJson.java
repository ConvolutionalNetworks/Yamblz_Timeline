package com.mobilization.yamblz_timeline.data;

import android.content.Context;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.mobilization.yamblz_timeline.data.model.DataJson;
import com.mobilization.yamblz_timeline.data.model.People;
import com.mobilization.yamblz_timeline.data.model.Schedule;
import com.mobilization.yamblz_timeline.domain.Event;
import com.mobilization.yamblz_timeline.domain.ScheduleProvider;
import com.mobilization.yamblz_timeline.domain.School;
import com.mobilization.yamblz_timeline.domain.Teacher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import io.reactivex.Flowable;
import io.reactivex.Observable;

/**
 * Created by Алексей on 08.07.2017.
 */

public class ScheduleFromJson implements ScheduleProvider {

    private Context context;

    public ScheduleFromJson(Context context) {
        this.context = context;
    }

    @Override
    public Observable<List<Event>> getEvents() {
        StringBuilder buf=new StringBuilder();
        InputStream json= null;

        try {

            json = context.getAssets().open("bot-data.json");

            BufferedReader in =
                    new BufferedReader(new InputStreamReader(json, "UTF-8"));
            String str;

            while ((str = in.readLine()) != null) {
                buf.append(str);
            }

            in.close();
        } catch (IOException ioexception) {
            ioexception.printStackTrace();
        }
        Gson gson = new Gson();
        DataJson dataJson = gson.fromJson(buf.toString(), DataJson.class);

        List<Schedule> schedules = dataJson.getSchedules();



        List<Event> events = new ArrayList<>();

        List<People> peoples = dataJson.getPeoples();

        for (int i =0; i < schedules.size(); i++) {
            Schedule schedule = schedules.get(i);
            //2017-07-03 10:00:00+0300
           SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZZ", Locale.ENGLISH);

            long timestamp = 0;

            try {
                timestamp = sdf.parse(schedule.getTime()).getTime();
            } catch (ParseException e) {
                e.printStackTrace();
            }

            List<School> schools = new ArrayList<>();

            for (String s : schedule.getSchools()) {
                schools.add(getSchoolFromString(s));

            }

            List<Teacher> teachers = new ArrayList<>();

            for (String teacherName : schedule.getTeachers()) {
                People people = findPeopleByName(peoples, teacherName);
                if (people != null) {
                    String photoPath = "";

                    if (!TextUtils.isEmpty(people.getTelegram())) {
                        photoPath = people.getTelegram() + ".jpg";
                    } else {
                        photoPath = people.getName().replace(" ", "_") + ".jpg";
                    }


                    List<School> teacherSchool = new ArrayList<>();

                    for (String s : people.getSchools()) {
                        teacherSchool.add(getSchoolFromString(s));
                    }

                    Teacher teacher = new Teacher(people.getName(), photoPath, teacherSchool, people.getTelegram());
                    teachers.add(teacher);
                }
            }


            Event event = new Event(schedule.getLocation(), null,  schedule.getTitle(), timestamp, schools, teachers);
            events.add(event);
        }

        return Observable.just(events);
    }

    @Override
    public int getCurrentDay() {
        long currentTime = System.currentTimeMillis();
        String startDate = "03.07.2017";
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
        long startTime = 0;
        try {
            startTime = sdf.parse(startDate).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long diff = currentTime - startTime;

        long day = diff / (1000 * 60 * 60 * 24);

        return (int) day;
    }

    private People findPeopleByName(List<People> peoples, String name) {
        for (People people : peoples) {
            if (people.getName().equals(name)) {
                return people;
            }
        }
        return null;
    }

    private School getSchoolFromString(String s) {
        switch (s) {
            case "shri":
                return School.FRONTEND;

            case "shm":
                return School.MANAGEMENT;

            case "shmd":
                return School.DESIGN;

            case "shnr":
                return School.MOBILE;
                
            default:
                return School.MOBILE;
        }
    }


}
