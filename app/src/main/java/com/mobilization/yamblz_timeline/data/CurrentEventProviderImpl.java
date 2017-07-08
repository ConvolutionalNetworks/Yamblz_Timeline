package com.mobilization.yamblz_timeline.data;

import com.mobilization.yamblz_timeline.domain.CurrentEventProvider;
import com.mobilization.yamblz_timeline.domain.Event;


public class CurrentEventProviderImpl implements CurrentEventProvider{

    private Event event;

    @Override
    public void saveEvent(Event event) {
        this.event = event;
    }

    @Override
    public Event loadEvent() {
        return event;
    }
}
