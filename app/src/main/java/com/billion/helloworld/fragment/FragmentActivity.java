package com.billion.helloworld.fragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.billion.helloworld.R;

public class FragmentActivity extends AppCompatActivity implements AFragment.OnMessageCommunication{
    private AFragment mAfragment;
    private TextView mTvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        mAfragment = AFragment.newInstance("我是标题");
        //向FrameLayout控件中添加一个Fragment实例，并提交显示
        //add()方法的第三个参数是Fragment的标签tag
        getFragmentManager().beginTransaction().add(R.id.fl_container, mAfragment, "a").commitAllowingStateLoss();
        mTvTitle = (TextView) findViewById(R.id.tv_title);
    }

    @Override
    public void communication(String msg) {
        mTvTitle.setText(msg);
    }
}
