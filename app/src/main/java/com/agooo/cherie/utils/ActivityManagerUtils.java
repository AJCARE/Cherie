package com.agooo.cherie.utils;

import android.app.Activity;

import java.util.ArrayList;

/**
 * author cherie
 * date 2015/9/20
 */
public class ActivityManagerUtils {

    private static ActivityManagerUtils activityManagerUtils;
    private ArrayList<Activity> activityList = new ArrayList<Activity>();

    private ActivityManagerUtils() {

    }

    public static ActivityManagerUtils getInstance() {
        if (null == activityManagerUtils) {
            activityManagerUtils = new ActivityManagerUtils();
        }
        return activityManagerUtils;
    }

    public Activity getTopActivity() {
        return activityList.get(activityList.size() - 1);
    }

    public void addActivity(Activity ac) {
        activityList.add(ac);
    }

    /**
     * 结束所有activity
     */
    public void removeAllActivity() {
        for (Activity ac : activityList) {
            if (null != ac) {
                if (!ac.isFinishing()) {
                    ac.finish();
                }
                ac = null;
            }
        }
        activityList.clear();
    }
}
