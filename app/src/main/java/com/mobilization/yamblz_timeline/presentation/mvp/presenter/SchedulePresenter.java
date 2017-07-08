package com.mobilization.yamblz_timeline.presentation.mvp.presenter;

import com.mobilization.yamblz_timeline.presentation.mvp.common.BasePresenter;
import com.mobilization.yamblz_timeline.presentation.mvp.view.ScheduleView;

public interface SchedulePresenter extends BasePresenter<ScheduleView> {

    void getSchedule();

}
