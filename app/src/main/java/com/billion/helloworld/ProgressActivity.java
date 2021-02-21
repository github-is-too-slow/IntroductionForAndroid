package com.billion.helloworld;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.billion.helloworld.utils.ToastUtils;

public class ProgressActivity extends AppCompatActivity {
    private ProgressBar mPb3;
    private Button mBtnStart, mBtnProgressDialog1, mBtnProgressDialog2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        mPb3 = (ProgressBar) findViewById(R.id.pb3);
        mBtnStart = (Button) findViewById(R.id.btn_start);
        mBtnProgressDialog1 = (Button) findViewById(R.id.btn_progressDialog1);
        mBtnProgressDialog2 = (Button) findViewById(R.id.btn_progressDialog2);
        OnClick onClick = new OnClick();
        mBtnStart.setOnClickListener(onClick);
        mBtnProgressDialog1.setOnClickListener(onClick);
        mBtnProgressDialog2.setOnClickListener(onClick);
    }

    class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_start:
                    handler.sendEmptyMessage(0);
                    break;
                case R.id.btn_progressDialog1:
                    //声明一个对话框,默认为旋转型进度动画
                    ProgressDialog progressDialog1 = new ProgressDialog(ProgressActivity.this);
                    progressDialog1.setTitle("提示：");
                    progressDialog1.setMessage("正在下载");
                    //实现两个常用的两个监听事件
                    progressDialog1.setOnCancelListener(new DialogInterface.OnCancelListener() {
                        @Override
                        public void onCancel(DialogInterface dialog) {
                            ToastUtils.showMsg(getApplicationContext(), "OnCancel...");
                        }
                    });
                    progressDialog1.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        @Override
                        public void onDismiss(DialogInterface dialog) {
                            ToastUtils.showMsg(getApplicationContext(), "OnDismiss...");
                        }
                    });
                    //设置加载完才能取消对话框
                    //progressDialog1.setCancelable(false);
                    progressDialog1.show();
                    break;
                case R.id.btn_progressDialog2:
                    final ProgressDialog progressDialog2 = new ProgressDialog(ProgressActivity.this);
                    progressDialog2.setTitle("提示：");
                    progressDialog2.setMessage("正在下载...");
                    //设置水平进度条
                    progressDialog2.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                    //设置进度条最大值为100，默认也为100
                    //progressDialog2.setMax(100);
                    //设置确定和取消按钮
                    progressDialog2.setButton(ProgressDialog.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //开始下载，进度条开始滚动，当加载到100%时对话框消失
                        }
                    });
                    progressDialog2.setButton(ProgressDialog.BUTTON_NEGATIVE, "取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //取消下载，对话框消失
                            progressDialog2.dismiss();
                        }
                    });
                    //实现两个常用的两个监听事件
                    progressDialog2.setOnCancelListener(new DialogInterface.OnCancelListener() {
                        @Override
                        public void onCancel(DialogInterface dialog) {
                            ToastUtils.showMsg(getApplicationContext(), "OnCancel...");
                        }
                    });
                    progressDialog2.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        @Override
                        public void onDismiss(DialogInterface dialog) {
                            ToastUtils.showMsg(getApplicationContext(), "OnDismiss...");
                        }
                    });
                    //除非手动dismiss对话框才会消失
                    progressDialog2.setCancelable(false);
                    progressDialog2.show();
                    break;
            }
        }
    }

    //重载Handler处理消息接口
    Handler handler = new Handler(){
        //接受消息并处理消息
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(mPb3.getProgress() < 100){
                handler.postDelayed(runnable, 500);
            }else{
                ToastUtils.showMsg(getApplicationContext(), "加载完成");
            }
        }
    };

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            mPb3.setProgress(mPb3.getProgress() + 3);
            //线程结束时重新发送一条消息
            handler.sendEmptyMessage(0);
        }
    };
}
