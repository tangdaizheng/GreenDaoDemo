package com.tdz.greendaodemo.helper;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 通用帮助类
 * Created by HaoXi on 2017/12/1.
 */

public class CommonHelper {

    /**
     * 获取当前日期字符串
     *
     * @return String 格式yyyy-MM-dd hh:mm:ss
     */
    public static String getDatetime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.CHINA);
        return sdf.format(new Date());
    }


    /**
     * 转换为float
     *
     * @param o
     * @return
     */
    public static float toFloat(Object o) {
        if (o == null) {
            return 0;
        }

        if (o.toString().equals("null")) {
            return 0;
        }
        try {
            return Float.parseFloat(o.toString().trim());
        } catch (Exception e) {
            Log.e("warning to Float error", e.toString());
            return 0;
        }

    }
}
