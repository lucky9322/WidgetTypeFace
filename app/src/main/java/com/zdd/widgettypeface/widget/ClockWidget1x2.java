package com.zdd.widgettypeface.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.zdd.widgettypeface.service.ClockService;


/**
 * @CreateDate: 2017/6/20 下午4:29
 * @Author: lucky
 * @Description:
 * @Version: [v1.0]
 */

public class ClockWidget1x2 extends AppWidgetProvider {

    private static final String TAG = "ClockWidget1x2";

    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);
        Log.d(TAG, "onEnabled");
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        Log.d(TAG, "onUpdate");

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        Log.d(TAG, "onReceive" + intent.getAction());
        context.startService(new Intent(context, ClockService.class));
        ClockWidgetUtil.updateView(context);
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        super.onDeleted(context, appWidgetIds);
        Log.d(TAG, "onDeleted");
    }

    @Override
    public void onDisabled(Context context) {
        super.onDisabled(context);
        Log.d(TAG, "onDisabled");
        context.stopService(new Intent(context, ClockService.class));
    }





}
