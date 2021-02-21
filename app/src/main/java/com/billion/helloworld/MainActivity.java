package com.billion.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.billion.helloworld.datastorage.DataStorageActivity;

public class MainActivity extends AppCompatActivity {
    private Button btn_ui;
    private Button btn_event;
    private Button btn_storage;
    private Button btn_broadcast;
    private Button btn_animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_ui = (Button) findViewById(R.id.btn_ui);
        btn_event = (Button) findViewById(R.id.btn_event);
        btn_storage = (Button) findViewById(R.id.btn_storage);
        btn_broadcast = (Button) findViewById(R.id.btn_broadcast);
        btn_animation = (Button) findViewById(R.id.btn_animation);
        OnClick onClick = new OnClick();
        btn_ui.setOnClickListener(onClick);
        btn_event.setOnClickListener(onClick);
        btn_storage.setOnClickListener(onClick);
        btn_broadcast.setOnClickListener(onClick);
        btn_animation.setOnClickListener(onClick);
    }

    class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.btn_ui:
                    intent = new Intent(MainActivity.this, UIActivity.class);
                    break;
                case R.id.btn_event:
                    intent = new Intent(MainActivity.this, EventActivity.class);
                    break;
                case R.id.btn_storage:
                    intent = new Intent(MainActivity.this, DataStorageActivity.class);
                    break;
                case R.id.btn_broadcast:
                    intent = new Intent(MainActivity.this, com.billion.helloworld.boardcast.BoardcastActivity1.class);
                    break;
                case R.id.btn_animation:
                    intent = new Intent(MainActivity.this, AnimationActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
