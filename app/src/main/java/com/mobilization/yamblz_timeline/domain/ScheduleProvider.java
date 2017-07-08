package com.mobilization.yamblz_timeline.domain;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by Алексей on 08.07.2017.
 */

public interface ScheduleProvider {

    Flowable<List<Event>> getEvents();
    int getCurrentDay();
    long getHomeworkTimestamp(School school);
}
