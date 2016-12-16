package com.fuicuiedu.idedemo.videoplayer_demo_20161215.DemoF;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.fuicuiedu.idedemo.videoplayer_demo_20161215.R;
import com.fuicuiedu.idedemo.videoplayer_demo_20161215.VideoUrlRes;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

import static android.R.attr.start;

public class DemoFActivity extends AppCompatActivity {
    private VideoView videoView;
    private TextView tvDownloadRate;//缓冲速度
    private TextView tvLoadRate;//缓冲百分比
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_f);

        videoView = (VideoView) findViewById(R.id.main_f_vv);
        tvDownloadRate = (TextView) findViewById(R.id.main_f_downloadRate);
        tvLoadRate = (TextView) findViewById(R.id.main_f_loadRate);
        progressBar = (ProgressBar) findViewById(R.id.main_f_prb);

        videoView.setVideoPath(VideoUrlRes.getTestUrl2());
        //添加视频控制器
        videoView.setMediaController(new MediaController(this));

        //第一步，在准备的监听中设置缓冲大小
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                //设置缓冲大小
                videoView.setBufferSize(512 * 1024);
            }
        });

        //第二步，监听缓冲的开始，结束，下载速率变化（更新UI）
        videoView.setOnInfoListener(new MediaPlayer.OnInfoListener() {
            @Override
            public boolean onInfo(MediaPlayer mp, int what, int extra) {
                switch (what){
                    //当缓冲开始
                    case MediaPlayer.MEDIA_INFO_BUFFERING_START:
                        startBuffer();
                        break;
                    //当缓冲结束
                    case MediaPlayer.MEDIA_INFO_BUFFERING_END:
                        endBuffer();
                        break;
                    //下载速率的变化
                    case MediaPlayer.MEDIA_INFO_DOWNLOAD_RATE_CHANGED:
                        tvDownloadRate.setText(extra + "KB/S");
                        break;
                }
                return false;
            }
        });

        //第三步，监听缓冲进度，更新当前缓冲的百分比
        videoView.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
            @Override
            public void onBufferingUpdate(MediaPlayer mp, int percent) {
                tvLoadRate.setText(percent + "%");
            }
        });
    }

    //缓冲开始，更新UI
    private void startBuffer(){
        //判断是否正在播放
        if (videoView.isPlaying()){
            //暂停
            videoView.pause();
            progressBar.setVisibility(View.VISIBLE);
            tvDownloadRate.setVisibility(View.VISIBLE);
            tvLoadRate.setVisibility(View.VISIBLE);
            tvDownloadRate.setText("");
            tvLoadRate.setText("");
        }
    }

    //缓冲结束，更新UI
    private void endBuffer(){
        //开始播放
        videoView.start();
        progressBar.setVisibility(View.INVISIBLE);
        tvDownloadRate.setVisibility(View.INVISIBLE);
        tvLoadRate.setVisibility(View.INVISIBLE);

    }
}
