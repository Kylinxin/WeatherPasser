package com.kylinxin.myweather.base;

import android.app.Application;
import android.content.Context;

public class BaseApplication extends Application {
    public static Context context = null;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
}
