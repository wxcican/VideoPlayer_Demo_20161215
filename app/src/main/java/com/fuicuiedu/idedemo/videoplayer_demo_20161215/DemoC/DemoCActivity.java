package com.fuicuiedu.idedemo.videoplayer_demo_20161215.DemoC;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.Toast;
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

        //加入视频控制器
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        //默认上一首下一首隐藏，知道调用setPrevNextListeners()
//        mediaController.setPrevNextListeners(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(DemoCActivity.this, "下一首", Toast.LENGTH_SHORT).show();
//            }
//        }, new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(DemoCActivity.this, "上一首", Toast.LENGTH_SHORT).show();
//            }
//        });

        //开始播放
        videoView.start();

    }
}
