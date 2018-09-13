package com.gideondev.safeboda.internal.di.module;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.gideondev.safeboda.base.AppApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Enny on 29/11/2016.
 */
@Module
public class ApplicationModule {
    private AppApplication mApp;

    public ApplicationModule(AppApplication app) {
        mApp = app;
    }

    @Provides
    @Singleton
    SharedPreferences provideSharedPrefs() {
        return PreferenceManager.getDefaultSharedPreferences(mApp);
    }

}