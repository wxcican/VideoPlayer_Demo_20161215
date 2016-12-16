package com.fuicuiedu.idedemo.videoplayer_demo_20161215.DemoD;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.fuicuiedu.idedemo.videoplayer_demo_20161215.R;
import com.fuicuiedu.idedemo.videoplayer_demo_20161215.VideoUrlRes;

import io.vov.vitamio.widget.VideoView;

public class DemoDActivity extends AppCompatActivity {
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_d);

        videoView = (VideoView) findViewById(R.id.main_d_vv);

        videoView.setVideoPath(VideoUrlRes.getTestUrl1());

        videoView.start();

    }
}
