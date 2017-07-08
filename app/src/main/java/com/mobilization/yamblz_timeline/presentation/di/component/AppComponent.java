package com.mobilization.yamblz_timeline.presentation.di.component;

import com.mobilization.yamblz_timeline.presentation.di.modules.AppModule;
import com.mobilization.yamblz_timeline.presentation.di.modules.EventModule;
import com.mobilization.yamblz_timeline.presentation.di.modules.UtilsModule;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;
import io.reactivex.Scheduler;

import static com.mobilization.yamblz_timeline.presentation.di.modules.UtilsModule.JOB;
import static com.mobilization.yamblz_timeline.presentation.di.modules.UtilsModule.UI;

@Singleton
@Component(modules = {AppModule.class, UtilsModule.class})
public interface AppComponent {
    @Named(JOB)
    Scheduler provideJobScheduler();

    @Named(UI)
    Scheduler provideUiScheduler();

    EventComponent plus(EventModule eventModule);
}
