package com.mobilization.yamblz_timeline.presentation.mvp;

import com.mobilization.yamblz_timeline.domain.Event;
import com.mobilization.yamblz_timeline.domain.School;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by Kim Michael on 08.07.17
 */
public interface SchedulePresenter {

    void setSchool(School school);
    void getSchedule();

}
