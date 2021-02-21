package com.billion.helloworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.billion.helloworld.utils.ToastUtils;

public class PopupWindowActivity extends AppCompatActivity {
    private Button mBtnPopup;
    private PopupWindow mPopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window);
        mBtnPopup = (Button) findViewById(R.id.btn_popup);
        mBtnPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = getLayoutInflater().inflate(R.layout.layout_popup_window, null);
                TextView tv_small = (TextView) view.findViewById(R.id.small);
                tv_small.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mPopup.dismiss();
                        //dosomething
                        ToastUtils.showMsg(PopupWindowActivity.this, "小学");
                    }
                });
                TextView tv_middle = (TextView) view.findViewById(R.id.middle);
                tv_middle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mPopup.dismiss();
                        //dosomething
                        ToastUtils.showMsg(PopupWindowActivity.this, "中学");
                    }
                });
                TextView tv_big = (TextView) view.findViewById(R.id.big);
                tv_big.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mPopup.dismiss();
                        //dosomething
                        ToastUtils.showMsg(PopupWindowActivity.this, "大学");
                    }
                });
                //创建一个PopupWindow对象，指定对应的view对象，宽和高
                mPopup = new PopupWindow(view, mBtnPopup.getWidth(), ViewGroup.LayoutParams.WRAP_CONTENT);
                //点击非PopupWindon区域取消显示
                mPopup.setOutsideTouchable(true);
                //toggle效果
                mPopup.setFocusable(true);
                //显示在mBtnPopup按钮下面
                mPopup.showAsDropDown(mBtnPopup);
            }
        });
    }
}
