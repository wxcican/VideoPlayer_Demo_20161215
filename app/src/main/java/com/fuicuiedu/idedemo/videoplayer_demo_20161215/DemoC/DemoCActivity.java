package com.fuicuiedu.idedemo.videoplayer_demo_20161215.DemoC;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;

import com.fuicuiedu.idedemo.videoplayer_demo_20161215.R;
import com.fuicuiedu.idedemo.videoplayer_demo_20161215.VideoUrlRes;

public class DemoCActivity extends AppCompatActivity {
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_c);

        videoView = (VideoView) findViewById(R.id.main_c_vv);

        //设置数据源
        videoView.setVideoPath(VideoUrlRes.getTestUrl1());

        //开始播放
        videoView.start();

    }
}
