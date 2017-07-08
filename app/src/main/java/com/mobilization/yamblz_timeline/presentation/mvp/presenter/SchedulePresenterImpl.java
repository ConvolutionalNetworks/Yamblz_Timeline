package com.mobilization.yamblz_timeline.presentation.mvp;

import com.mobilization.yamblz_timeline.domain.Event;
import com.mobilization.yamblz_timeline.domain.ScheduleProvider;
import com.mobilization.yamblz_timeline.domain.School;
import com.mobilization.yamblz_timeline.presentation.mvp.view.ScheduleView;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by Kim Michael on 08.07.17
 */
public class SchedulePresenterImpl implements com.mobilization.yamblz_timeline.presentation.mvp.SchedulePresenter {

    School mSchool;
    @Inject
    ScheduleProvider mScheduleProvider;
    @Inject
    ScheduleView mScheduleView;

    @Override
    public void setSchool(School school) {
        mSchool = school;
    }

    @Override
    public void getSchedule() {
        mScheduleProvider.getEvents().subscribe(new Consumer<List<Event>>() {
            @Override
            public void accept(@NonNull List<Event> events) throws Exception {
                mScheduleView.showSchedule(events);
            }
        });
    }

    @Override
    public void getCurrentDay() {
        mScheduleView.showCurrentDay(mScheduleProvider.getCurrentDay());
    }

    @Override
    public void getTimeToHomework() {

    }
}
