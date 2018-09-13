package com.gideondev.safeboda.base;

import android.support.multidex.MultiDexApplication;

import com.gideondev.safeboda.internal.di.component.ApplicationComponent;
import com.gideondev.safeboda.internal.di.component.DaggerApplicationComponent;
import com.gideondev.safeboda.internal.di.module.ApplicationModule;


public class AppApplication
    extends MultiDexApplication {
    private static AppApplication application;
    private ApplicationComponent mComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;

    }


    private void initApplication() {
        mComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        mComponent.inject(this);
    }


    public static AppApplication get() {
        return application;
    }

}
