package com.mobilization.yamblz_timeline.presentation.di.component;

import com.mobilization.yamblz_timeline.presentation.activity.MainActivity;
import com.mobilization.yamblz_timeline.presentation.di.modules.EventModule;
import com.mobilization.yamblz_timeline.presentation.di.modules.ScreenModule;
import com.mobilization.yamblz_timeline.presentation.di.scopes.EventScope;

import dagger.Subcomponent;

@EventScope
@Subcomponent(modules = EventModule.class)
public interface EventComponent {

    EventScreenComponent plus(ScreenModule screenModule);
}
