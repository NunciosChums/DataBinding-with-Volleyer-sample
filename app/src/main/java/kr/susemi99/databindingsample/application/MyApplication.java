package kr.susemi99.databindingsample.application;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.navercorp.volleyextensions.volleyer.Volleyer;
import com.navercorp.volleyextensions.volleyer.factory.DefaultRequestQueueFactory;

public class MyApplication extends Application
{
  @Override
  public void onCreate()
  {
    super.onCreate();

    RequestQueue rq = DefaultRequestQueueFactory.create(this);
    rq.start();
    Volleyer.volleyer(rq).settings().setAsDefault().done();
  }
}
