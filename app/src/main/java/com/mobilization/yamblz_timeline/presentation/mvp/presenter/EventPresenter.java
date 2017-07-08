package com.mobilization.yamblz_timeline.presentation.mvp.presenter;

import com.mobilization.yamblz_timeline.domain.Event;
import com.mobilization.yamblz_timeline.presentation.mvp.common.BasePresenter;
import com.mobilization.yamblz_timeline.presentation.mvp.view.EventView;

public interface EventPresenter extends BasePresenter<EventView> {

    Event getEvent();

}
