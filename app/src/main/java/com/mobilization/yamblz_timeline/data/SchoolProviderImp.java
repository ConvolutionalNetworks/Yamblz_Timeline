package com.mobilization.yamblz_timeline.data;

import com.mobilization.yamblz_timeline.domain.ScheduleProvider;
import com.mobilization.yamblz_timeline.domain.School;
import com.mobilization.yamblz_timeline.domain.SchoolProvider;

import io.reactivex.Observable;

/**
 * Created by Алексей on 08.07.2017.
 */

public class SchoolProviderImp implements SchoolProvider {
    @Override
    public Observable<School> getSchool() {
        return Observable.just(School.MOBILE);
    }
}
