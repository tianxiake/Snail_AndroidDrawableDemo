package com.nebulaera.myandroidtestdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 使用AnimationDrawable的补间动画
 */
public class AnimationDrawableActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String LYJ_TAG = "LYJ_AnimationActivity";
    @BindView(R.id.image_view_test_animation)
    ImageView animationImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_drawable);
        ButterKnife.bind(this);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.my_anim);
        //表示 补间动画运行结束或 停留在结束位置
        animation.setFillAfter(true);
        animationImageView.startAnimation(animation);
        animationImageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.i(LYJ_TAG, "onClick");
    }
}
