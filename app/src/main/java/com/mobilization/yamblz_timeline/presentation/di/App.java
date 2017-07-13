package com.mobilization.yamblz_timeline.presentation.di;

import android.app.Application;

import com.mobilization.yamblz_timeline.presentation.di.component.AppComponent;
import com.mobilization.yamblz_timeline.presentation.di.component.DaggerAppComponent;
import com.mobilization.yamblz_timeline.presentation.di.modules.AppModule;

public class App extends Application {

    private static App instance;
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        setInstance(this);
        this.appComponent =
                DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    private static void setInstance(App instance) {
        App.instance = instance;
    }

    public static App getInstance() {
        return instance;
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
