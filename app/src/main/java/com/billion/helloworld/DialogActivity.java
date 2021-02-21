package com.billion.helloworld;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.billion.helloworld.utils.ToastUtils;

public class DialogActivity extends AppCompatActivity {
    private Button mBtnDialog1, mBtnDialog2, mBtnDialog3, mBtnDialog4, mBtnDialog5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        mBtnDialog1 = (Button) findViewById(R.id.btn_dialog1);
        mBtnDialog2 = (Button) findViewById(R.id.btn_dialog2);
        mBtnDialog3 = (Button) findViewById(R.id.btn_dialog3);
        mBtnDialog4 = (Button) findViewById(R.id.btn_dialog4);
        mBtnDialog5 = (Button) findViewById(R.id.btn_dialog5);
        OnClick onClick = new OnClick();
        mBtnDialog1.setOnClickListener(onClick);
        mBtnDialog2.setOnClickListener(onClick);
        mBtnDialog3.setOnClickListener(onClick);
        mBtnDialog4.setOnClickListener(onClick);
        mBtnDialog5.setOnClickListener(onClick);
    }

    class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_dialog1://AlertDialog默认样式，添加标题、图标、提示信息msg、三个按钮
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(DialogActivity.this);
                    builder1.setTitle("请回答：")
                            .setIcon(R.drawable.smile_100_100)
                            .setMessage("你觉得课程如何？")
                            //参数1：提示信息，参数2：单击事件
                            .setPositiveButton("棒", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtils.showMsg(getApplicationContext(), "你眼光不错");
                                }
                            })
                            .setNeutralButton("还行", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtils.showMsg(getApplicationContext(), "你再考虑考虑");
                                }
                            })
                            .setNegativeButton("不好", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtils.showMsg(getApplicationContext(), "睁眼说瞎话");
                                }
                            }).show();
                    break;
                case R.id.btn_dialog2:
//                    AlertDialog设置items选项
                    final String[] sexArray2 = new String[]{"男", "女"};
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(DialogActivity.this);
                    builder2.setTitle("选择性别：")
                            .setItems(sexArray2, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtils.showMsg(DialogActivity.this, sexArray2[which]);
                                }
                            }).show();
                    break;
                case R.id.btn_dialog3:
//                    AlertDialog设置单选项SingleChoiceItems
                    final String[] sexArray3 = new String[]{"男", "女"};
                    AlertDialog.Builder builder3 = new AlertDialog.Builder(DialogActivity.this);
                    builder3.setTitle("选择性别：")
                            .setSingleChoiceItems(sexArray3, 1, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtils.showMsg(DialogActivity.this, sexArray3[which]);
                                    //当点击对话框时取消对话框的显示
                                    dialog.dismiss();
                                }
                            })
                            .setCancelable(false)//设置为点击对话框外的部分不会取消对话框的显示
                            .show();
                    break;
                case R.id.btn_dialog4:
//                    AlertDialog设置多选项
                    final String[] hobbies = new String[]{"唱歌", "跳舞", "敲代码"};
                    //默认选择数组
                    boolean[] defaluts = new boolean[]{false, true, true};
                    AlertDialog.Builder builder4 = new AlertDialog.Builder(DialogActivity.this);
                    builder4.setTitle("选择兴趣：")
                            .setMultiChoiceItems(hobbies, defaluts, new DialogInterface.OnMultiChoiceClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                    ToastUtils.showMsg(getApplicationContext(), hobbies[which] + "：" + isChecked);
                                }
                            })
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //pass
                                }
                            })
                            .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //pass
                                }
                            })
                            .setCancelable(false)//设置为点击对话框外的部分不会取消对话框的显示
                            .show();
                    break;
                case R.id.btn_dialog5:
                    //通过自定义xml布局生成自定义dialog对话框
                    AlertDialog.Builder builder5 = new AlertDialog.Builder(DialogActivity.this);
                    LayoutInflater inflater = LayoutInflater.from(DialogActivity.this);
                    //从布局xml文件生成一个对应的View对象
                    View view = inflater.inflate(R.layout.layout_dialog, null);
                    EditText et_username = (EditText) view.findViewById(R.id.et_username);
                    EditText et_password = (EditText) view.findViewById(R.id.et_password);
                    Button btn_login = (Button) view.findViewById(R.id.btn_login);
                    btn_login.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //根据et_username控件获取用户名
                            //根据et_password控件获取密码
                            //后续操作...
                        }
                    });
                    builder5.setTitle("请登录")
                            .setView(view)
                            .show();
                    break;
            }
        }
    }
}
