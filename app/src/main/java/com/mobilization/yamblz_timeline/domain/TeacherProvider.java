package com.mobilization.yamblz_timeline.domain;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Mishkun on 08.07.2017.
 */

public interface TeacherProvider {
    Observable<List<Teacher>> getTeachers(List<String> names);
}
