package com.billion.helloworld;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import com.billion.helloworld.utils.ToastUtils;

public class HandlerActivity extends AppCompatActivity {
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
//        //Handler类的作用1：未来某时做某事
//        //延迟3秒钟‘从HandlerActivity跳转至ButtonActivity
//        mHandler = new Handler();
//        mHandler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent = new Intent(HandlerActivity.this, ButtonActivity.class);
//                startActivity(intent);
//            }
//        }, 3000);

        //Handler类的作用2：线程间通讯
        mHandler = new Handler(){
            //主线程即UI线程接受消息并处理消息
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                //根据msg的what属性处理不同的类型消息
                switch (msg.what){
                    case 0:
                        ToastUtils.showMsg(HandlerActivity.this, "线程间通讯成功");
                        break;
                }
            }
        };

        new Thread(){
            @Override
            public void run() {
                Message message = new Message();
                message.what = 0;
                //子线程给主线程发送一条消息处理
                mHandler.sendMessage(message);
            }
        }.start();
    }
}
