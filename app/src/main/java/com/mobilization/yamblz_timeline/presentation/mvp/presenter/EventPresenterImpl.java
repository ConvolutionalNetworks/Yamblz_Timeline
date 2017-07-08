package com.mobilization.yamblz_timeline.presentation.mvp.presenter;

import com.mobilization.yamblz_timeline.domain.CurrentEventProvider;
import com.mobilization.yamblz_timeline.domain.Event;
import com.mobilization.yamblz_timeline.presentation.di.App;
import com.mobilization.yamblz_timeline.presentation.di.modules.EventModule;
import com.mobilization.yamblz_timeline.presentation.di.modules.ScreenModule;
import com.mobilization.yamblz_timeline.presentation.mvp.view.EventView;

import javax.inject.Inject;

public class EventPresenterImpl implements EventPresenter {

    private EventView view;

    CurrentEventProvider currentEventProvider;

    private Event event;

    public EventPresenterImpl(CurrentEventProvider currentEventProvider) {
        App.getInstance().getAppComponent().plus(new EventModule()).plus(new ScreenModule()).inject(this);
        this.currentEventProvider = currentEventProvider;
    }

    @Override
    public void setModel() {
        this.event = currentEventProvider.loadEvent();
    }

    @Override
    public void bindView(EventView eventView) {
        this.view = eventView;
    }

    @Override
    public Event getEvent() {
        return event;
    }
}
