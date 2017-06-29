package com.zdd.widgettypeface.util;

import android.content.Context;
import android.util.SparseIntArray;

import com.zdd.widgettypeface.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;


/**
 * Created by shengjieli on 17-5-23.
 * Email address: shengjieli@ecarx.com.cn
 */

public class TimeUtil {

    public static final String FORMAT_YMD = "yyyy-MM-dd";
    public static final String FORMAT_YMDHMS = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_YMDHMSM = "yyyy-MM-dd HH:mm:ss.SSS";

    public static final String FORMAT_MD = "M月dd日";
    public static final String FORMAT_HM = "HH:mm";

    public static String formatTime(long milliseconds, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(milliseconds);
        return sdf.format(cal.getTime());
    }


    public static String getDayOfWeekText(Context context, String dateStr) {
        return context.getString(mDayOfWeekArray.get(getDayOfWeek(dateStr)));
    }

    private static SparseIntArray mDayOfWeekArray = new SparseIntArray() {
        {
            put(-1, R.string.forecast_day_default);
            put(1, R.string.forecast_day_monday);
            put(2, R.string.forecast_day_tuesday);
            put(3, R.string.forecast_day_wednesday);
            put(4, R.string.forecast_day_thursday);
            put(5, R.string.forecast_day_friday);
            put(6, R.string.forecast_day_saturday);
            put(0, R.string.forecast_day_sunday);
        }
    };

    private static int getDayOfWeek(String dateStr) {
        int dayOfWeek = -1;
        if (null != dateStr) {
            try {
                Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));
                cal.setTime(new Date());
                dayOfWeek = (cal.get(Calendar.DAY_OF_WEEK) - 1) % 7;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return dayOfWeek;
    }



}
