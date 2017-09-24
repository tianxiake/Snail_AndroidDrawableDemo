package com.nebulaera.myandroidtestdemo;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 使用 assets目录下原始资源和 res/raw下原始资源
 */
public class UseRawSourceActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.btn_test_play_raw_source)
    Button playRawSourceBtn;
    @BindView(R.id.btn_test_play_assert_source)
    Button playAssertSourceBtn;
    private MediaPlayer mediaPlayerTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_raw_source);
        ButterKnife.bind(this);
        playRawSourceBtn.setOnClickListener(this);
        playAssertSourceBtn.setOnClickListener(this);
        try {
            mediaPlayerTwo = new MediaPlayer();
            AssetManager assets = getAssets();
            AssetFileDescriptor assetFileDescriptor = assets.openFd("koushao.mp3");
            //设置播放的流的类型，不然prepare一直报错
            mediaPlayerTwo.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayerTwo.setDataSource(assetFileDescriptor.getFileDescriptor());
            mediaPlayerTwo.prepare();
        } catch (IOException e) {
            Log.e("LYJ", e.toString());
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_test_play_raw_source:
                MediaPlayer mediaPlayerOne = MediaPlayer.create(this, R.raw.koushao);
                mediaPlayerOne.start();
                break;
            case R.id.btn_test_play_assert_source:
                mediaPlayerTwo.start();
                break;
        }
    }
}
