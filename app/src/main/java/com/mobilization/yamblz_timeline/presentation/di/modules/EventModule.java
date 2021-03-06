package com.mobilization.yamblz_timeline.presentation.di.modules;

import android.content.Context;

import com.mobilization.yamblz_timeline.data.CurrentEventProviderImpl;
import com.mobilization.yamblz_timeline.data.MapsFromYandexStaticApi;
import com.mobilization.yamblz_timeline.data.ScheduleFromJson;
import com.mobilization.yamblz_timeline.data.SchoolProviderImp;
import com.mobilization.yamblz_timeline.domain.CurrentEventProvider;
import com.mobilization.yamblz_timeline.domain.MapsProvider;
import com.mobilization.yamblz_timeline.domain.ScheduleProvider;
import com.mobilization.yamblz_timeline.domain.SchoolProvider;
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

    @Provides
    @EventScope
    public MapsProvider provideMapsProvider() {
        return new MapsFromYandexStaticApi();
    }

    @Provides
    @EventScope
    public SchoolProvider provideSchoolProvider() {
        return new SchoolProviderImp();
    }

}
