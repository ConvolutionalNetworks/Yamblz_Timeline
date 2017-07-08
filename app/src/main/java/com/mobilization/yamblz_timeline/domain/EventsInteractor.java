package com.mobilization.yamblz_timeline.domain;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

public class EventsInteractor extends Interactor<List<Event>, School> {

    private final ScheduleProvider scheduleProvider;
    private final MapsProvider mapsProvider;

    @Inject
    EventsInteractor(Scheduler threadExecutor, Scheduler postExecutionThread, ScheduleProvider scheduleProvider, MapsProvider mapsProvider) {
        super(threadExecutor, postExecutionThread);
        this.scheduleProvider = scheduleProvider;
        this.mapsProvider = mapsProvider;
    }

    @Override
    Observable<List<Event>> buildUseCaseObservable(final School params) {
        return scheduleProvider.getEvents()
                               .map(new Function<List<Event>, List<Event>>() {
                                   @Override
                                   public List<Event> apply(@NonNull List<Event> events) throws Exception {
                                       List<Event> filteredEvents = new ArrayList<Event>(events.size());
                                       for (Event event : events)
                                           if (event.getSchools().contains(params))
                                               filteredEvents.add(event);
                                       return filteredEvents;
                                   }
                               }).flatMap(new Function<List<Event>, ObservableSource<List<Event>>>() {
                    @Override
                    public ObservableSource<List<Event>> apply(@NonNull List<Event> events) throws Exception {
                        return Observable.<Event>fromIterable(events).flatMap(new Function<Event, ObservableSource<Event>>() {
                            @Override
                            public ObservableSource<Event> apply(@NonNull final Event event) throws Exception {
                                return mapsProvider.getMapLink(event.getLocation()).map(new Function<LocationLink, Event>() {
                                    @Override
                                    public Event apply(@NonNull LocationLink locationLink) throws Exception {
                                        return appendLocationLinkToEvent(locationLink, event);
                                    }
                                });
                            }
                        }).toList().toObservable();
                    }
                });
    }

    @NonNull
    private Event appendLocationLinkToEvent(@NonNull LocationLink locationLink, @NonNull Event event) {
        return new Event(event.getLocation(), locationLink, event.getTitle(), event.getTimestamp(), event.getSchools(), event.getTeachers());
    }
}
