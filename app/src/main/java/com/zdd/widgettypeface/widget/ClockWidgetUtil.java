package com.zdd.widgettypeface.widget;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.widget.RemoteViews;

import com.zdd.widgettypeface.R;
import com.zdd.widgettypeface.util.TimeUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @CreateDate: 2017/6/29 下午1:19
 * @Author: lucky
 * @Description:
 * @Version: [v1.0]
 */

public class ClockWidgetUtil {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 更新事件的方法
     */
    public static void updateView(Context context) {
        String time = sdf.format(new Date());

        RemoteViews rViews = new RemoteViews(context.getPackageName(),
                R.layout.clock_widget_1x2_content);

        rViews.setTextViewText(R.id.tv_clock, time);
        rViews.setTextViewText(R.id.clock_time,
                TimeUtil.formatTime(new Date().getTime(), TimeUtil.FORMAT_HM));
        rViews.setTextViewText(R.id.clock_date,
                TimeUtil.formatTime(new Date().getTime(), TimeUtil.FORMAT_MD));
        rViews.setTextViewText(R.id.clock_week,
                TimeUtil.getDayOfWeekText(context, new Date().toString()));

        // 刷新
        AppWidgetManager manager = AppWidgetManager
                .getInstance(context.getApplicationContext());
        ComponentName cName = new ComponentName(context.getApplicationContext(),
                ClockWidget1x2.class);
        manager.updateAppWidget(cName, rViews);
    }

}
