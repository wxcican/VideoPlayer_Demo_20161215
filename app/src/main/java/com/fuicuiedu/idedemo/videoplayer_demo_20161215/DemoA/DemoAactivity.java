package com.fuicuiedu.idedemo.videoplayer_demo_20161215.DemoA;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.fuicuiedu.idedemo.videoplayer_demo_20161215.R;
import com.fuicuiedu.idedemo.videoplayer_demo_20161215.VideoUrlRes;

import java.io.IOException;

public class DemoAactivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private SurfaceView surfaceView;
    private SurfaceHolder surfaceHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_aactivity);


//        准备阶段，需要获取MediaPlayer实例，设置数据源 和 准备播放。
        //1,获取mediaPlayer实例
//        mediaPlayer = new MediaPlayer();
//        //2,设置数据源
//        try {
//            mediaPlayer.setDataSource(VideoUrlRes.getTestUrl1());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        //3,准备播放，推荐异步准备
//        mediaPlayer.prepareAsync();
//        //播放
//        mediaPlayer.start();

        //但是：mediaPlater不能显示视频
//        mediaPlayer.setDisplay("SurfaceHolder");



        //SurfaceView
        //SurfaceView上面有一个Surface进行绘制处理，怎么才能拿到这个Surface,怎么才能将内容显示到Surface上
        //它提供了一个  SurfaceHolder
        //SurfaceView -> getHolder();
        surfaceView = (SurfaceView) findViewById(R.id.main_a_sfv);

        surfaceHolder = surfaceView.getHolder();
        //视频画面的处理----不用我们去做，Surface帮我们处理了

        //但是，现在只是放了一个SurfaceView的控件，它的内部是通过Surface来处理的
        //那么问题来了，你怎么知道这个Surface有没有创建好？有没有改变大小？有没有销毁呢？
        //所以它提供一个CallBack

        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
            //Surface有没有创建好
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                try {
                    //拿到mediaplayer实例
                    mediaPlayer = new MediaPlayer();
                    //mediaplater与SurfaceHolder绑定
                    mediaPlayer.setDisplay(surfaceHolder);
                    //设置数据源
                    mediaPlayer.setDataSource(VideoUrlRes.getTestUrl1());
                    //播放准备（异步）
                    mediaPlayer.prepareAsync();
                    //播放，监听是否准备好
                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mp) {
                            mediaPlayer.start();
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            //有没有改变？
            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            }
            //有没有销毁?
            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                //停止播放
                mediaPlayer.stop();
            }
        });


    }
}
