package com.fuicuiedu.idedemo.videoplayer_demo_20161215;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.fuicuiedu.idedemo.videoplayer_demo_20161215.DemoA.DemoAactivity;
import com.fuicuiedu.idedemo.videoplayer_demo_20161215.DemoB.DemoBActivity;
import com.fuicuiedu.idedemo.videoplayer_demo_20161215.DemoC.DemoCActivity;
import com.fuicuiedu.idedemo.videoplayer_demo_20161215.DemoD.DemoDActivity;
import com.fuicuiedu.idedemo.videoplayer_demo_20161215.DemoE.DemoEActivity;
import com.fuicuiedu.idedemo.videoplayer_demo_20161215.DemoF.DemoFActivity;

import io.vov.vitamio.Vitamio;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView mLv;
    private ArrayAdapter<String> adapter;
    private String[] datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Vitamio初始化！！！！重要！！！！
        Vitamio.isInitialized(this);

        mLv = (ListView) findViewById(R.id.main_lv);

        datas = new String[]{
                "A Android MediaPlayer+SurfaceView",
                "B Vitamio MediaPlayer+SurfaceView",
                "C Android VideoView",
                "D Vitamio VideoView",
                "E Vitamio MediaController",
                "F Vitamio Buffer"
        };

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datas);

        mLv.setAdapter(adapter);

        mLv.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent();
        switch (position) {
            case 0:
                intent.setClass(this, DemoAactivity.class);
                startActivity(intent);
                break;
            case 1:
                intent.setClass(this, DemoBActivity.class);
                startActivity(intent);
                break;
            case 2:
                intent.setClass(this, DemoCActivity.class);
                startActivity(intent);
                break;
            case 3:
                intent.setClass(this, DemoDActivity.class);
                startActivity(intent);
                break;
            case 4:
                intent.setClass(this, DemoEActivity.class);
                startActivity(intent);
                break;
            case 5:
                intent.setClass(this, DemoFActivity.class);
                startActivity(intent);
                break;
        }
    }
}
