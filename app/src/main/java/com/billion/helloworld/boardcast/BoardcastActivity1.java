package com.billion.helloworld.boardcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.billion.helloworld.R;

public class BoardcastActivity1 extends AppCompatActivity {
    private Button mBtnIntent;
    private TextView mTvContent;
    private BroadcastReceiver mBroadcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boardcast1);
        mBtnIntent = (Button) findViewById(R.id.btn_intent);
        mTvContent = (TextView) findViewById(R.id.tv_content);
        mBtnIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BoardcastActivity1.this, BoardcastActivity2.class);
                startActivity(intent);
            }
        });

        //注册广播接收器
        mBroadcast = new MyBroadcastReceiver();
        //通过action过滤广播
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.billion.update");
        LocalBroadcastManager.getInstance(BoardcastActivity1.this).registerReceiver(mBroadcast, intentFilter);
    }

    //重定义一个广播接收器
    class MyBroadcastReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction()){
                case "com.billion.update":
                    mTvContent.setText("新内容：123");
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消接收器的注册，避免内存泄漏
        LocalBroadcastManager.getInstance(BoardcastActivity1.this).unregisterReceiver(mBroadcast);
    }
}
