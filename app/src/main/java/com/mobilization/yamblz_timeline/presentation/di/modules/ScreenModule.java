package com.mobilization.yamblz_timeline.presentation.di.modules;

import com.mobilization.yamblz_timeline.presentation.di.scopes.EventScreenScope;
import com.mobilization.yamblz_timeline.presentation.mvp.presenter.SchedulePresenter;
import com.mobilization.yamblz_timeline.presentation.mvp.presenter.SchedulePresenterImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class ScreenModule {

    @Provides
    @EventScreenScope
    SchedulePresenter provideSchedulePresenter() {
        return new SchedulePresenterImpl();
    }
}
