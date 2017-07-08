package com.mobilization.yamblz_timeline.domain;

import java.util.List;

/**
 * Created by Алексей on 08.07.2017.
 */

public interface ScheduleProvider {

    List<Event> getEvents(School school);
    int getCurrentDay();
    long getHomeworkTimestamp(School school);
}
