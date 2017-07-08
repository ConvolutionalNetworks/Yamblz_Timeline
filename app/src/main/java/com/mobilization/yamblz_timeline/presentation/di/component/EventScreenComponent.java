package com.mobilization.yamblz_timeline.presentation.di.component;


import com.mobilization.yamblz_timeline.presentation.activity.MainActivity;
import com.mobilization.yamblz_timeline.presentation.di.modules.ScreenModule;
import com.mobilization.yamblz_timeline.presentation.di.scopes.EventScreenScope;
import com.mobilization.yamblz_timeline.presentation.fragment.EventFragment;

import dagger.Subcomponent;

@EventScreenScope
@Subcomponent(modules = ScreenModule.class)
public interface EventScreenComponent {

    void inject(EventFragment eventFragment);
    void inject(MainActivity mainActivity);
}
