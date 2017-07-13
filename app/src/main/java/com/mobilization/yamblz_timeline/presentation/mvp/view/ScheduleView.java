package com.mobilization.yamblz_timeline.presentation.mvp.view;

import com.mobilization.yamblz_timeline.domain.Event;

import java.util.List;

public interface ScheduleView {

    void showSchedule(List<Event> events);

    void openFragment();
}
