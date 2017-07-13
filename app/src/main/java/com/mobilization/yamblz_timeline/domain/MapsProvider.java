package com.mobilization.yamblz_timeline.domain;

import io.reactivex.Observable;

/**
 * Created by Mishkun on 08.07.2017.
 */

public interface MapsProvider {
    Observable<LocationLink> getMapLink(String location);
}
