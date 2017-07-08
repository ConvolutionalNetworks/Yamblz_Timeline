package com.mobilization.yamblz_timeline.presentation.di.modules;

import android.content.Context;

import com.mobilization.yamblz_timeline.data.ScheduleFromJson;
import com.mobilization.yamblz_timeline.domain.ScheduleProvider;
import com.mobilization.yamblz_timeline.presentation.di.scopes.EventScope;

import dagger.Module;
import dagger.Provides;

@Module
public class EventModule {

    @Provides
    @EventScope
    public ScheduleProvider provideScheduleProvider(Context context) {
        return new ScheduleFromJson(context);
    }
}
