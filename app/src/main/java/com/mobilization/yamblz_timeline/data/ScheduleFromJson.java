package com.mobilization.yamblz_timeline.data;

import android.content.Context;

import com.mobilization.yamblz_timeline.domain.Event;
import com.mobilization.yamblz_timeline.domain.ScheduleProvider;
import com.mobilization.yamblz_timeline.domain.School;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by Алексей on 08.07.2017.
 */

public class ScheduleFromJson implements ScheduleProvider {

    private Context context;

    public ScheduleFromJson(Context context) {
        this.context = context;
    }

    @Override
    public Flowable<List<Event>> getEvents() {
        return null;
    }

    @Override
    public int getCurrentDay() {
        return 0;
    }

    @Override
    public long getHomeworkTimestamp(School school) {
        return 0;
    }
}
