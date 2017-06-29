package com.zdd.widgettypeface.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;

import com.zdd.widgettypeface.widget.ClockWidgetUtil;



/**
 * @CreateDate: 2017/6/20 下午4:42
 * @Author: lucky
 * @Description:
 * @Version: [v1.0]
 */

public class ClockService extends Service {
    private static final String TAG = "ClockService";

    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        //动态注册 修改时间，时间更新广播
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_TIME_TICK);
        filter.addAction(Intent.ACTION_TIME_CHANGED);
        registerReceiver(timeTickReceiver, filter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(timeTickReceiver);
    }


    BroadcastReceiver timeTickReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(TAG, "broadcastReceiver==" + intent.getAction());
            ClockWidgetUtil.updateView(ClockService.this);
        }
    };
}
