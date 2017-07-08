package com.mobilization.yamblz_timeline.domain;

public interface CurrentEventProvider {

    void saveEvent(Event event);

    Event loadEvent();
}
