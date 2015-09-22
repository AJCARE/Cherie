package com.agooo.cherie.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import java.io.File;
import com.agooo.cherie.utils.ActivityManagerUtils;

/**
 * author cherie
 * date 2015/9/20
 * */
public class CherieApplication extends Application {
    public static CherieApplication mInstance;

    public static synchronized CherieApplication getInstance() {
        if (mInstance == null) {
            mInstance = new CherieApplication();
        }
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    //获取系统任务栏高度
    public int getDimensionMiss(Context context){
        Resources resources = context.getResources();
        int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
        return resources.getDimensionPixelSize(resourceId);
    }

    public void addActivity(Activity ac) {
        ActivityManagerUtils.getInstance().addActivity(ac);
    }

    public void exit() {
        ActivityManagerUtils.getInstance().removeAllActivity();
    }

    public Activity getTopActivity() {
        return ActivityManagerUtils.getInstance().getTopActivity();
    }
}
