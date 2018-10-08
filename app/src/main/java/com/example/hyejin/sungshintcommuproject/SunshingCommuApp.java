package com.example.hyejin.sungshintcommuproject;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class SunshingCommuApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);
        RealmConfiguration conig = new RealmConfiguration.Builder()
                .name("SungshinCommunity")
                .deleteRealmIfMigrationNeeded()
                .build();

        Realm mRealm = Realm.getInstance(conig);

    }
}
