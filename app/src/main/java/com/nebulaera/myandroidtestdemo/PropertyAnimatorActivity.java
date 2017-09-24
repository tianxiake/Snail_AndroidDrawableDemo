package com.nebulaera.myandroidtestdemo;

import android.animation.AnimatorInflater;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 属性动画的基本使用
 */
public class PropertyAnimatorActivity extends AppCompatActivity {
    @BindView(R.id.ll_test_container)
    LinearLayout containerLinerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animator);
        ButterKnife.bind(this);
        containerLinerLayout.addView(new MyAnimatorView(this));
    }

    public class MyAnimatorView extends View {
        public MyAnimatorView(Context context) {
            super(context);
            ObjectAnimator animator = (ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.my_object);
            animator.setEvaluator(new ArgbEvaluator());
            animator.setTarget(this);
            animator.start();
        }
    }
}
