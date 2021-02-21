package com.billion.helloworld.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.billion.helloworld.R;

/**
 * Created by 13360 on 2021/2/18.
 */

public class CustomDialog extends Dialog implements View.OnClickListener{
    private TextView mTvTitle, mTvMsg, mTvCancel, mTvConfirm;
    private String title, msg, cancel, confirm;
    private IOnCancelListener cancelListener;
    private IOnConfirmListener confirmListener;

    public CustomDialog(@NonNull Context context) {
        super(context);
    }

    public CustomDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_custom_dialog);
        //设置对话框宽度为手机屏幕宽度的80%，代码固定
        WindowManager manager = getWindow().getWindowManager();
        Display display = manager.getDefaultDisplay();
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        Point size = new Point();
        display.getSize(size);
        attributes.width = (int) (size.x * 0.8);
        getWindow().setAttributes(attributes);

        mTvTitle = (TextView) findViewById(R.id.tv_custom_title);
        mTvMsg = (TextView) findViewById(R.id.tv_custom_msg);
        mTvCancel = (TextView) findViewById(R.id.tv_custom_cancel);
        mTvConfirm= (TextView) findViewById(R.id.tv_custom_confirm);
        if(!TextUtils.isEmpty(title)){//利用TextUtils工具类判断内容是否为空
            mTvTitle.setText(title);
        }
        if(!TextUtils.isEmpty(msg)){
            mTvMsg.setText(msg);
        }
        if(!TextUtils.isEmpty(cancel)){
            mTvCancel.setText(cancel);
        }
        if(!TextUtils.isEmpty(confirm)){
            mTvConfirm.setText(confirm);
        }
        //设置监听事件
        mTvCancel.setOnClickListener(this);
        mTvConfirm.setOnClickListener(this);
    }

    //builder模式，方便链式调用
    public CustomDialog setTitle(String title) {
        this.title = title;
        return this;
    }

    public CustomDialog setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public CustomDialog setCancel(String cancel, IOnCancelListener cancelListener) {
        this.cancel = cancel;
        this.cancelListener = cancelListener;
        return this;
    }

    public CustomDialog setConfirm(String confirm, IOnConfirmListener confirmListener) {
        this.confirm = confirm;
        this.confirmListener = confirmListener;
        return this;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_custom_cancel:
                if (cancelListener != null){
                    cancelListener.onCancel(this);
                }
                dismiss();
                break;
            case R.id.tv_custom_confirm:
                if(confirmListener != null){
                    confirmListener.onConfirm(this);
                }
                dismiss();
                break;
        }
    }

    public interface IOnCancelListener {
        void onCancel(CustomDialog dialog);
    }

    public interface IOnConfirmListener{
        void onConfirm(CustomDialog dialog);
    }
}
