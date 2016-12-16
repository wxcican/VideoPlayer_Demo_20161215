package com.fuicuiedu.idedemo.videoplayer_demo_20161215.DemoB;

import android.graphics.PixelFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.fuicuiedu.idedemo.videoplayer_demo_20161215.R;
import com.fuicuiedu.idedemo.videoplayer_demo_20161215.VideoUrlRes;

import java.io.IOException;

import io.vov.vitamio.MediaPlayer;

public class DemoBActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private SurfaceView surfaceView;
    private SurfaceHolder surfaceHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_b);

        surfaceView = (SurfaceView) findViewById(R.id.main_b_sfv);
        surfaceHolder = surfaceView.getHolder();

        surfaceHolder.setFormat(PixelFormat.RGBA_8888);//不加则会花屏！！！！

        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                try {
                    //拿到mediaplayer实例
                    mediaPlayer = new MediaPlayer(getApplicationContext());
                    mediaPlayer.setDisplay(surfaceHolder);
                    mediaPlayer.setDataSource(VideoUrlRes.getTestUrl1());
                    mediaPlayer.prepareAsync();
                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mp) {
                            mediaPlayer.start();
                        }
                    });

                    //无法播放（黑屏），vitamio5.0后，要对audio处理，才能对在线视频进行播放！
                    mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() {
                        @Override
                        public boolean onInfo(MediaPlayer mp, int what, int extra) {
                            if (what == MediaPlayer.MEDIA_INFO_FILE_OPEN_OK){
                                //对audio处理
                                mediaPlayer.audioInitedOk(mediaPlayer.audioTrackInit());
                                return true;
                            }
                            return false;
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                mediaPlayer.stop();
                //用完mediaplayer后释放相关资源
                mediaPlayer.release();
            }
        });
    }
}
