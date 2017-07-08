package com.mobilization.yamblz_timeline.presentation.mvp.presenter;

import com.mobilization.yamblz_timeline.domain.Event;
import com.mobilization.yamblz_timeline.domain.EventsInteractor;
import com.mobilization.yamblz_timeline.presentation.di.App;
import com.mobilization.yamblz_timeline.presentation.di.modules.EventModule;
import com.mobilization.yamblz_timeline.presentation.di.modules.ScreenModule;
import com.mobilization.yamblz_timeline.presentation.mvp.view.ScheduleView;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by Kim Michael on 08.07.17
 */
public class SchedulePresenterImpl implements SchedulePresenter {

    ScheduleView mScheduleView;

    @Inject
    EventsInteractor interactor;

    @Inject
    public SchedulePresenterImpl() {
        App.getInstance().getAppComponent().plus(new EventModule()).plus(new ScreenModule()).inject(this);
    }

    @Override
    public void getSchedule() {
        interactor.execute(new DisposableObserver<List<Event>>() {
            @Override
            public void onNext(List<Event> events) {

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }
        }, null);
    }

    @Override
    public void setModel() {

    }

    @Override
    public void bindView(ScheduleView scheduleView) {

    }

    static class ScheduleObserver implements Consumer<List<Event>> {



        @Override
        public void accept(List<Event> events) throws Exception {

        }
    }
}
