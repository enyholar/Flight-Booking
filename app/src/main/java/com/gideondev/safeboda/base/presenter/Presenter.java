package com.gideondev.safeboda.base.presenter;

import android.support.annotation.NonNull;

public interface Presenter<T extends LoadDataView> {

    void resume();


    void pause();

    void destroy();

    void setView(@NonNull T view);


}
