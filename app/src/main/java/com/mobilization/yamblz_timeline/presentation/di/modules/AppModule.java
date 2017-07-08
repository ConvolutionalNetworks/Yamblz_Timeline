package com.mobilization.yamblz_timeline.presentation.di.modules;

import android.content.Context;
import android.support.annotation.NonNull;

import com.mobilization.yamblz_timeline.data.CurrentEventProviderImpl;
import com.mobilization.yamblz_timeline.domain.CurrentEventProvider;
import com.mobilization.yamblz_timeline.presentation.di.scopes.EventScope;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private Context context;

    public AppModule(@NonNull Context appContext) {
        this.context = appContext;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public CurrentEventProvider provideCurrentEventProvider() {
        return new CurrentEventProviderImpl();
    }
}
