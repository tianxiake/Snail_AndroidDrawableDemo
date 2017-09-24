package com.nebulaera.myandroidtestdemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by Barry on 2017/9/24.
 */

/**
 * 自定义一个简单的view用于使用自定义的属性
 */
public class AlphaImageView extends ImageView {
    private static final String LYJ_TAG = "LYJ_AlphaImageView";
    private int duration;
    //设置变化的速度
    private int SPEED = 100;
    private float alphaDelta = 0;
    private float curAlpha = 0;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            curAlpha += alphaDelta;
            Log.i(LYJ_TAG, "handleMessage. alphaDelta=" + alphaDelta + ",curAlpha=" + curAlpha);
            if (curAlpha > 1.0) {
                curAlpha = 1.0f;
            }
            Log.i(LYJ_TAG, "result curAlpha=" + curAlpha);
            AlphaImageView.this.setAlpha(curAlpha);
        }
    };

    public AlphaImageView(Context context) {
        super(context);
    }

    public AlphaImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //获取自定义的xml属性值
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.AlphaImageView);
        duration = typedArray.getInt(R.styleable.AlphaImageView_duration, 0);
        Log.i(LYJ_TAG, "duration=" + duration);
//        setImageAlpha(10);
        alphaDelta = 1.0f * SPEED / duration;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Log.i(LYJ_TAG, "TimeTask curAlpha=" + curAlpha);
                if (curAlpha >= 1.0) {
                    Log.i(LYJ_TAG, "cancel");
                    timer.cancel();
                } else {
                    handler.sendEmptyMessage(1);
                }
            }
        }, 0, SPEED);
    }
}
