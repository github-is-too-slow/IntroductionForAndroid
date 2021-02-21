package com.billion.helloworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class LifeCycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
        //dosomething...设置布局文件
        Log.d("lifeCycle", "-----onCreate-----");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lifeCycle", "-----onStart-----");
    }

    @Override
    protected void onResume() {
        super.onResume();
        //继续执行
        Log.d("lifeCycle", "-----onResume-----");
    }

    @Override
    protected void onPause() {
        super.onPause();
        //暂停进入后台运行
        Log.d("lifeCycle", "-----onPause-----");
    }

    @Override
    protected void onStop() {
        super.onStop();
        //按下home键执行onPause、onStop方法
        Log.d("lifeCycle", "-----onStop-----");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //从stopped状态转换到resumed状态
        Log.d("lifeCycle", "-----onRestart-----");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //销毁活动
        Log.d("lifeCycle", "-----onDestroy-----");
    }
}
