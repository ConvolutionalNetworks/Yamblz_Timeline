package com.mobilization.yamblz_timeline.presentation.di.modules;

import com.mobilization.yamblz_timeline.domain.EventsInteractor;
import com.mobilization.yamblz_timeline.presentation.di.scopes.EventScreenScope;
import com.mobilization.yamblz_timeline.presentation.mvp.presenter.EventPresenter;
import com.mobilization.yamblz_timeline.presentation.mvp.presenter.EventPresenterImpl;
import com.mobilization.yamblz_timeline.presentation.mvp.presenter.SchedulePresenter;
import com.mobilization.yamblz_timeline.presentation.mvp.presenter.SchedulePresenterImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class ScreenModule {

    @Provides
    @EventScreenScope
    SchedulePresenter provideSchedulePresenter(EventsInteractor eventsInteractor) {
        return new SchedulePresenterImpl(eventsInteractor);
    }

    @Provides
    @EventScreenScope
    EventPresenter provideEventPresenter(){
        return new EventPresenterImpl();
    }
}
