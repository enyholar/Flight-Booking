package com.gideondev.safeboda.base;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.transition.Transition;
import android.view.View;

import com.gideondev.safeboda.base.presenter.Presenter;



public abstract class BaseActionbarActivity
    extends AppCompatActivity
    implements View.OnClickListener {

  private android.support.v4.app.FragmentManager mFragmentManager;

  public abstract void initView();

  public abstract void initModel();

  public abstract Presenter getPresenter();


  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mFragmentManager = getSupportFragmentManager();

  }
  abstract protected void injectInjector();
  /**
   * Switch content tab
   */
  public void switchContent(int contentId, Fragment fragment) {
    FragmentTransaction transaction = mFragmentManager.beginTransaction();
    transaction.replace(contentId, fragment);
    transaction.commit();
  }

  private void initTransaction() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      Transition enterTrans = new Explode();
      getWindow().setEnterTransition(enterTrans);
    }
  }


  @Override
  public void onClick(View v) {

  }



  @Override
  public void onResume() {
    super.onResume();

    if (null != getPresenter()) {
      getPresenter().resume();
    }
  }

  @Override
  public void onPause() {
    super.onPause();
    if (null != getPresenter()) {
      getPresenter().pause();
    }
  }

  @Override
  public void onDestroy() {
    if (null != getPresenter()) {
      getPresenter().destroy();
    }
    super.onDestroy();
  }



}
