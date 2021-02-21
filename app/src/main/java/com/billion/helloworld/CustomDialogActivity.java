package com.billion.helloworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.billion.helloworld.utils.ToastUtils;
import com.billion.helloworld.widget.CustomDialog;

public class CustomDialogActivity extends AppCompatActivity {
    private Button mBtnCustom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);
        mBtnCustom = (Button) findViewById(R.id.btn_custom_dialog);
        mBtnCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog customDialog =  new CustomDialog(CustomDialogActivity.this);
                customDialog.setTitle("提示：")
                        .setMsg("正在下载...")
                        .setCancel("取消", new CustomDialog.IOnCancelListener() {
                            @Override
                            public void onCancel(CustomDialog dialog) {
                                ToastUtils.showMsg(CustomDialogActivity.this, "OnCancel...");
                            }
                        })
                        .setConfirm("确认", new CustomDialog.IOnConfirmListener() {
                            @Override
                            public void onConfirm(CustomDialog dialog) {
                                ToastUtils.showMsg(CustomDialogActivity.this, "OnConfirm...");
                            }
                        }).show();
            }
        });
    }
}
