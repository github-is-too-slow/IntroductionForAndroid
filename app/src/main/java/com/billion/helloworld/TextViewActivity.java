package com.billion.helloworld;

import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TextViewActivity extends AppCompatActivity {
    private TextView mTv_4;
    private TextView mTv_5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);
//        代码设置中划线
        mTv_4 = (TextView) findViewById(R.id.tv_4);
        mTv_4.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        mTv_4.getPaint().setAntiAlias(true);
//        代码设置下划线
        mTv_5 = (TextView) findViewById(R.id.tv_5);
        mTv_5.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
    }
}
