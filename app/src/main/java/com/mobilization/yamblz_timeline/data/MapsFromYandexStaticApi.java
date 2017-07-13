package com.mobilization.yamblz_timeline.data;

import com.mobilization.yamblz_timeline.domain.LocationLink;
import com.mobilization.yamblz_timeline.domain.MapsProvider;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;

/**
 * Created by Mishkun on 08.07.2017.
 */

public class MapsFromYandexStaticApi implements MapsProvider {
    private Map<String, String> locationsDict;

    public MapsFromYandexStaticApi() {
        this.locationsDict = new HashMap<>();
        locationsDict.put("Гарвард",
                          "https://static-maps.yandex.ru/1.x/?ll=37.5897744,55.733636&spn=0.001,0.001&l=map&pl=c:8822DDC0,w:8,37.589758,55.733164,37.589257,55.733435,37.589490,55.733544,37.590000,55.733327,37.589758,55.733164&pt=37.589378,55.733380,pm2rdm");
        locationsDict.put("Мулен руж",
                          "https://static-maps.yandex.ru/1.x/?ll=37.587514,55.734153&spn=0.001,0.001&l=map&pt=37.587186,55.734074,pm2rdm");
        locationsDict.put("Синий кит",
                          "https://static-maps.yandex.ru/1.x/?ll=37.587514,55.734153&spn=0.001,0.001&l=map&pt=37.587320,55.734331,pm2rdm");
        locationsDict.put("Принстон",
                          "https://static-maps.yandex.ru/1.x/?ll=37.5897744,55.733636&spn=0.001,0.001&l=map&pl=c:8822DDC0,w:8,37.589758,55.733164,37.589257,55.733435,37.589490,55.733544,37.590000,55.733327,37.589758,55.733164&pt=37.589603,55.733426,pm2rdm");
        locationsDict.put("Кембридж",
                          "https://static-maps.yandex.ru/1.x/?ll=37.5897744,55.733636&spn=0.001,0.001&l=map&pl=c:8822DDC0,w:8,37.589758,55.733164,37.589257,55.733435,37.589490,55.733544,37.590000,55.733327,37.589758,55.733164&pt=37.589705,55.733196,pm2rdm");
    }

    @Override
    public Observable<LocationLink> getMapLink(String location) {
        return Observable.just(new LocationLink(locationsDict.get(location))).onErrorReturnItem(
                new LocationLink("https://static-maps.yandex.ru/1.x/?ll=37.588596,55.733816&spn=0.0015,0.0015&l=map&pt=37.588596,55.733816,pm2rdm"));
    }
}
