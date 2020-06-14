package com.example.covidhelp;

import android.app.Activity;
import android.app.Application;

public class LoKi extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    private Activity mCurrentActivity = null;

    public Activity getmCurrentActivity() {
        return mCurrentActivity;
    }

    public void setmCurrentActivity(Activity activity){
        mCurrentActivity = activity;
    }
}
