package com.agooo.cherie.utils;

import android.util.Log;
import com.agooo.cherie.commons.Constant;

/**
 * Created by Administrator on 2015/9/20.
 */
public class LogUtils {

    public static void cLog(String desc, String info) {
        if (Constant.debug) {
            Log.e(desc, info);
        }
    }
}
