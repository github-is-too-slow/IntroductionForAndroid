package com.billion.helloworld.boardcast;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.billion.helloworld.R;

public class BoardcastActivity2 extends AppCompatActivity {
    private Button mBtnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boardcast2);
        mBtnClick = (Button) findViewById(R.id.btn_click);
        mBtnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //声明一个intent，参数是action，任意字符串
                Intent intent = new Intent("com.billion.update");
                //发送广播
                LocalBroadcastManager.getInstance(BoardcastActivity2.this).sendBroadcast(intent);
            }
        });
    }
}
