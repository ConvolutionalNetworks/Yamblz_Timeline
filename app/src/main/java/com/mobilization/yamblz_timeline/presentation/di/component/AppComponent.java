package com.mobilization.yamblz_timeline.presentation.di.component;

import com.mobilization.yamblz_timeline.presentation.activity.MainActivity;
import com.mobilization.yamblz_timeline.presentation.di.modules.AppModule;
import com.mobilization.yamblz_timeline.presentation.di.modules.EventModule;
import com.mobilization.yamblz_timeline.presentation.di.modules.UtilsModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, UtilsModule.class})
public interface AppComponent {

    EventComponent plus(EventModule eventModule);
}
