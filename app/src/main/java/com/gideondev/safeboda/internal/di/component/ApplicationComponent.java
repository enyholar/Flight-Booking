package com.gideondev.safeboda.internal.di.component;


import com.gideondev.safeboda.base.AppApplication;
import com.gideondev.safeboda.base.BaseActionbarActivity;
import com.gideondev.safeboda.internal.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Enny on 29/11/2016.
 */
@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    void inject(AppApplication app);
    void inject(BaseActionbarActivity activity);

//    void inject(LocalDataSource localDataSource);
}
