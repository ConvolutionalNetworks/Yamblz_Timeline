package com.mobilization.yamblz_timeline.presentation.mvp.view;

import com.mobilization.yamblz_timeline.domain.Event;

import java.util.List;

/**
 * Created by Kim Michael on 08.07.17
 */
public interface ScheduleView {

    void showSchedule(List<Event> events);
    void showCurrentDay(int currentDay);
}
