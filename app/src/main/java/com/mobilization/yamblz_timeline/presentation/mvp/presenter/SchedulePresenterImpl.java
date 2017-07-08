package com.mobilization.yamblz_timeline.presentation.mvp.presenter;

import com.mobilization.yamblz_timeline.domain.Event;
import com.mobilization.yamblz_timeline.domain.ScheduleProvider;
import com.mobilization.yamblz_timeline.domain.School;
import com.mobilization.yamblz_timeline.presentation.di.App;
import com.mobilization.yamblz_timeline.presentation.di.modules.EventModule;
import com.mobilization.yamblz_timeline.presentation.di.modules.ScreenModule;
import com.mobilization.yamblz_timeline.presentation.mvp.presenter.SchedulePresenter;
import com.mobilization.yamblz_timeline.presentation.mvp.view.ScheduleView;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by Kim Michael on 08.07.17
 */
public class SchedulePresenterImpl implements SchedulePresenter {

    ScheduleView mScheduleView;

    @Inject
    public SchedulePresenterImpl() {
        App.getInstance().getAppComponent().plus(new EventModule()).plus(new ScreenModule()).inject(this);
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
    public void setModel() {

    }

    @Override
    public void bindView(ScheduleView scheduleView) {

    }
}
