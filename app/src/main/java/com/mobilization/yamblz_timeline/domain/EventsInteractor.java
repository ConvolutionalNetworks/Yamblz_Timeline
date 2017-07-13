package com.mobilization.yamblz_timeline.domain;

import com.mobilization.yamblz_timeline.presentation.di.App;
import com.mobilization.yamblz_timeline.presentation.di.modules.EventModule;
import com.mobilization.yamblz_timeline.presentation.di.scopes.EventScope;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

import static com.mobilization.yamblz_timeline.presentation.di.modules.UtilsModule.JOB;
import static com.mobilization.yamblz_timeline.presentation.di.modules.UtilsModule.UI;

@EventScope
public class EventsInteractor extends Interactor<List<Event>, Void> {

    private final ScheduleProvider scheduleProvider;
    private final MapsProvider mapsProvider;
    private final SchoolProvider schoolProvider;

    @Inject
    EventsInteractor(@Named(JOB) Scheduler threadExecutor, @Named(UI) Scheduler postExecutionThread, ScheduleProvider scheduleProvider, MapsProvider mapsProvider,
                     SchoolProvider schoolProvider) {
        super(threadExecutor, postExecutionThread);
        this.scheduleProvider = scheduleProvider;
        this.mapsProvider = mapsProvider;
        this.schoolProvider = schoolProvider;
        App.getInstance().getAppComponent().plus(new EventModule()).inject(this);
    }

    @Override
    Observable<List<Event>> buildUseCaseObservable(final Void params) {
        return scheduleProvider.getEvents()
                               .flatMap(new Function<List<Event>, ObservableSource<List<Event>>>() {
                                   @Override
                                   public ObservableSource<List<Event>> apply(@NonNull final List<Event> events) throws Exception {
                                       return schoolProvider.getSchool().map(new Function<School, List<Event>>() {
                                           @Override
                                           public List<Event> apply(@NonNull School school) throws Exception {
                                               List<Event> filteredEvents = new ArrayList<Event>(events.size());
                                               for (Event event : events)
                                                   if (event.getSchools().contains(school))
                                                       filteredEvents.add(event);
                                               return filteredEvents;
                                           }
                                       });
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
