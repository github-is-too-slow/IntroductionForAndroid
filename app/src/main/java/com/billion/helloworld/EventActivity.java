package com.billion.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EventActivity extends AppCompatActivity {
    private Button mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        mHandler = (Button) findViewById(R.id.btn_handler);
        mHandler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到HandlerActivity
                Intent intent = new Intent(EventActivity.this, HandlerActivity.class);
                startActivity(intent);
            }
        });
    }
}
