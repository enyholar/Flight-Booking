package com.gideondev.safeboda.base.presenter;

import android.content.Context;

public interface LoadDataView {

    void showLineLoading();


    void hideLineLoading();


    void showError(String message);

    Context getContext();
}
