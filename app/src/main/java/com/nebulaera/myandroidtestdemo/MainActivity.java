package com.nebulaera.myandroidtestdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.btn_test_animation_drawable)
    Button animationDrawableBtn;
    @BindView(R.id.btn_test_property_animator)
    Button propertyAnimatorBtn;
    @BindView(R.id.btn_test_raw_xml)
    Button rawXmlBtn;
    @BindView(R.id.btn_test_custom_attribute)
    Button customAttributeBtn;
    @BindView(R.id.btn_test_use_raw_source)
    Button useRawSourceBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        animationDrawableBtn.setOnClickListener(this);
        propertyAnimatorBtn.setOnClickListener(this);
        rawXmlBtn.setOnClickListener(this);
        customAttributeBtn.setOnClickListener(this);
        useRawSourceBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_test_animation_drawable:
                startInsideActivity(AnimationActivity.class);
                break;
            case R.id.btn_test_property_animator:
                startInsideActivity(PropertyAnimatorActivity.class);
                break;
            case R.id.btn_test_raw_xml:
                startInsideActivity(RawXmlActivity.class);
                break;
            case R.id.btn_test_custom_attribute:
                startInsideActivity(CustomAttributeActivity.class);
                break;
            case R.id.btn_test_use_raw_source:
                startInsideActivity(UseRawSourceActivity.class);
                break;
        }
    }

    private void startInsideActivity(Class<? extends Activity> activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }
}
