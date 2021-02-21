package com.billion.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.billion.helloworld.jump.SrcActivity;

public class UIActivity extends AppCompatActivity {
    private Button mBtnTextView;
    private Button mBtnButton;
    private Button mBtnEditText;
    private Button mBtnRadioButton;
    private Button mBtnCheckedBox;
    private Button mBtnImageView;
    private Button mBtnListView;
    private Button mBtnGridView;
    private Button mBtnRecyclerView;
    private Button mBtnWebView;
    private Button mBtnToast;
    private Button mBtnDialog;
    private Button mBtnProgressBar;
    private Button mBtnCustomDialog;
    private Button mBtnPopupWindow;
    private Button mBtnLifeCycle;
    private Button mBtnIntent;
    private Button mBtnFragment;
    private Button mBtnRipple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);
        //region Description
        ////        设置按钮单击监听事件
//        mBtnTextView = (Button) findViewById(R.id.btn_textview);
//        mBtnTextView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //跳转到TextView展示页面
//                Intent intent = new Intent(UIActivity.this, TextViewActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        mBtnButton = (Button) findViewById(R.id.btn_Button);
//        mBtnButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //跳转到Button展示页面
//                Intent intent = new Intent(UIActivity.this, ButtonActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        mBtnEditText = (Button) findViewById(R.id.btn_editText);
//        mBtnEditText.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //跳转到EditText展示页面
//                Intent intent = new Intent(UIActivity.this, EditTextActivity.class);
//                startActivity(intent);
//            }
//        });
        //endregion
        setOnClickListeners();
    }

    //批量设置单击监听事件
    private void setOnClickListeners(){
        OnClick onClick =new OnClick();
        //设置单击监听事件
        mBtnTextView = (Button) findViewById(R.id.btn_textview);
        mBtnTextView.setOnClickListener(onClick);
        mBtnButton = (Button) findViewById(R.id.btn_Button);
        mBtnButton.setOnClickListener(onClick);
        mBtnEditText = (Button) findViewById(R.id.btn_editText);
        mBtnEditText.setOnClickListener(onClick);
        mBtnRadioButton = (Button) findViewById(R.id.btn_radioButton);
        mBtnRadioButton.setOnClickListener(onClick);
        mBtnCheckedBox = (Button) findViewById(R.id.btn_checkBox);
        mBtnCheckedBox.setOnClickListener(onClick);
        mBtnImageView = (Button) findViewById(R.id.btn_imgview);
        mBtnImageView.setOnClickListener(onClick);
        mBtnListView = (Button) findViewById(R.id.btn_listview);
        mBtnListView.setOnClickListener(onClick);
        mBtnGridView = (Button) findViewById(R.id.btn_gridview);
        mBtnGridView.setOnClickListener(onClick);
        mBtnRecyclerView = (Button) findViewById(R.id.btn_recycleView);
        mBtnRecyclerView.setOnClickListener(onClick);
        mBtnWebView = (Button) findViewById(R.id.btn_webView);
        mBtnWebView.setOnClickListener(onClick);
        mBtnToast = (Button) findViewById(R.id.btn_toast);
        mBtnToast.setOnClickListener(onClick);
        mBtnDialog = (Button) findViewById(R.id.btn_dialog);
        mBtnDialog.setOnClickListener(onClick);
        mBtnProgressBar = (Button) findViewById(R.id.btn_progressBar);
        mBtnProgressBar.setOnClickListener(onClick);
        mBtnCustomDialog = (Button) findViewById(R.id.btn_customDialog);
        mBtnCustomDialog.setOnClickListener(onClick);
        mBtnPopupWindow = (Button) findViewById(R.id.btn_popupWindow);
        mBtnPopupWindow.setOnClickListener(onClick);
        mBtnLifeCycle = (Button) findViewById(R.id.btn_lifeCycle);
        mBtnLifeCycle.setOnClickListener(onClick);
        mBtnIntent = (Button) findViewById(R.id.btn_intent);
        mBtnIntent.setOnClickListener(onClick);
        mBtnFragment = (Button) findViewById(R.id.btn_fragment);
        mBtnFragment.setOnClickListener(onClick);
        mBtnRipple = (Button) findViewById(R.id.btn_ripple);
        mBtnRipple.setOnClickListener(onClick);
    }

    //内部类重写onClick()方法
    private class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.btn_textview:
                    //跳转到TextView展示页面
                    intent = new Intent(UIActivity.this, TextViewActivity.class);
                    break;
                case R.id.btn_Button:
                    //跳转到Button展示页面
                    intent = new Intent(UIActivity.this, ButtonActivity.class);
                    break;
                case R.id.btn_editText:
                    //跳转到EditText展示页面
                    intent = new Intent(UIActivity.this, EditTextActivity.class);
                    break;
                case R.id.btn_radioButton:
                    //跳转到RadioButton展示页面
                    intent = new Intent(UIActivity.this, RadioButtonActivity.class);
                    break;
                case R.id.btn_checkBox:
                    //跳转到CheckedBox展示页面
                    intent = new Intent(UIActivity.this, CheckedBoxActivity.class);
                    break;
                case R.id.btn_imgview:
                    //跳转到ImageView展示页面
                    intent = new Intent(UIActivity.this, ImageViewActivity.class);
                    break;
                case R.id.btn_listview:
                    //跳转到ListView展示页面
                    intent = new Intent(UIActivity.this, com.billion.helloworld.listview.ListViewActivity.class);
                    break;
                case R.id.btn_gridview:
                    //跳转到GridView展示页面
                    intent = new Intent(UIActivity.this, com.billion.helloworld.gridview.GridViewActivity.class);
                    break;
                case R.id.btn_recycleView:
                    //跳转到RecycleView展示页面
                    intent = new Intent(UIActivity.this, com.billion.helloworld.recyclerview.RecyclerViewActivity.class);
                    break;
                case R.id.btn_webView:
                    //跳转到WebView展示页面
                    intent = new Intent(UIActivity.this, WebViewActivity.class);
                    break;
                case R.id.btn_toast:
                    //跳转到Toast展示页面
                    intent = new Intent(UIActivity.this, ToastActivity.class);
                    break;
                case R.id.btn_dialog:
                    //跳转到Dialog展示页面
                    intent = new Intent(UIActivity.this, DialogActivity.class);
                    break;
                case R.id.btn_progressBar:
                    //跳转到ProgressBar展示页面
                    intent = new Intent(UIActivity.this, ProgressActivity.class);
                    break;
                case R.id.btn_customDialog:
                    //跳转到CustomDialog展示页面
                    intent = new Intent(UIActivity.this, CustomDialogActivity.class);
                    break;
                case R.id.btn_popupWindow:
                    //跳转到PopupWindow展示页面
                    intent = new Intent(UIActivity.this, PopupWindowActivity.class);
                    break;
                case R.id.btn_lifeCycle:
                    //跳转到LifeCycle展示页面
                    intent = new Intent(UIActivity.this, LifeCycleActivity.class);
                    break;
                case R.id.btn_intent:
                    //跳转到Intent跳转展示页面
                    intent =new Intent(UIActivity.this, SrcActivity.class);
                    break;
                case R.id.btn_fragment:
                    //跳转到Fragment跳转展示页面
                    intent =new Intent(UIActivity.this, com.billion.helloworld.fragment.FragmentActivity.class);
                    break;
                case R.id.btn_ripple:
                    //跳转到Ripple水波纹跳转展示页面
                    intent =new Intent(UIActivity.this, RippleActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
