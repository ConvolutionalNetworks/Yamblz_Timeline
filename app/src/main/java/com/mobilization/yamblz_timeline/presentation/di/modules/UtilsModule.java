package com.mobilization.yamblz_timeline.presentation.di.modules;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@Module
public class UtilsModule {
        public static final String JOB = "JOB";
        public static final String UI = "UI";

        @Provides
        @Singleton
        @Named(JOB)
        public Scheduler provideJobScheduler() {
            return Schedulers.computation();
        }

        @Provides
        @Singleton
        @Named(UI)
        public Scheduler provideUIScheduler() {
            return AndroidSchedulers.mainThread();
        }

}
