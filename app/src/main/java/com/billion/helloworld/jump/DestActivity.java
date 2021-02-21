package com.billion.helloworld.jump;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.billion.helloworld.R;

public class DestActivity extends AppCompatActivity {
    private TextView mTv_title;
    private Button mBtnFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dest);
        mTv_title = (TextView) findViewById(R.id.tv_title);
        final Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        int age = bundle.getInt("age");
        mTv_title.setText("name=" + name + ", age=" + age);
        mBtnFinish = (Button) findViewById(R.id.btn_finish);
        mBtnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("title", "我回来了");
                intent.putExtras(bundle);
                //设置Activity返回，参数1：返回码，参数2：Intent
                setResult(Activity.RESULT_OK, intent);
                //手动关闭Activity
                finish();
            }
        });
    }
}
