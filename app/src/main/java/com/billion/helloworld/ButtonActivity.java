package com.billion.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ButtonActivity extends AppCompatActivity {
    private Button mBtn_6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        //设置点击响应事件方式2
        mBtn_6 = (Button) findViewById(R.id.btn_6);
        mBtn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ButtonActivity.this, "Button6被点击了", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //设置单击响应事件方式1
    public void showToast(View view){
        Toast.makeText(ButtonActivity.this, "Button5被点击了", Toast.LENGTH_SHORT).show();
    }
}
