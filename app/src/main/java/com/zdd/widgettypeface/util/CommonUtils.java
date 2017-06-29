package com.zdd.widgettypeface.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

/**
 * @CreateDate: 2017/6/26 下午3:17
 * @Author: lucky
 * @Description:
 * @Version: [v1.0]
 */

public class CommonUtils {

    public static Bitmap buildUpdate(String time, Context context) {
        Bitmap myBitmap = Bitmap.createBitmap(250, 68, Bitmap.Config.ARGB_4444);
        Canvas myCanvas = new Canvas(myBitmap);
        Paint paint = new Paint();
        Typeface tf = Typeface.createFromAsset(context.getAssets(), "fonts/GEELYNarrow.ttf");
        paint.setAntiAlias(true);
        paint.setAlpha(110);//取值范围为0~255，值越小越透明
        paint.setSubpixelText(true);
        paint.setTypeface(tf);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        paint.setTextSize(80);
        paint.setTextAlign(Paint.Align.LEFT);
        myCanvas.drawText(time, 100, 60, paint);
        return myBitmap;
    }
}
