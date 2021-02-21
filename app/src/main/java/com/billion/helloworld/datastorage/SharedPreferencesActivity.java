package com.billion.helloworld.datastorage;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.billion.helloworld.R;

public class SharedPreferencesActivity extends AppCompatActivity {
    private EditText mEtContent;
    private Button mBtnSave, mBtnShow;
    private TextView mTvContent;
    private SharedPreferences mShared;
    private SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);
        mEtContent = (EditText) findViewById(R.id.et_content);
        mBtnSave = (Button) findViewById(R.id.btn_save);
        mBtnShow = (Button) findViewById(R.id.btn_show);
        mTvContent = (TextView) findViewById(R.id.tv_content);
        //存储为.xml文件，参数1：存储文件名，参数2：存储模式（仅当前应用可存取）
        //存储位置：/data/data/<application-id>/shared_prefs/userInfo.xml
        mShared = getSharedPreferences("userInfo", MODE_PRIVATE);
        mEditor = mShared.edit();
        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //以键值对的形式存储内容
                mEditor.putString("name", mEtContent.getText().toString());
                //异步提交存储至磁盘中
                mEditor.apply();
                //同步存储至磁盘中
                //mEditor.commit();
            }
        });
        mBtnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //从userInfo.xml文件中读取内容，参数2：默认值
                mTvContent.setText(mShared.getString("name", ""));
            }
        });
    }
}

/*
查看存储的userInfo.xml文件
1.PS S:\Androidsdk\platform-tools> ./adb shell
2.generic_x86:/ $ run-as com.billion.helloworld
3.generic_x86:/data/data/com.billion.helloworld $ ls
4.app_textures app_webview cache code_cache databases files shared_prefs
5.generic_x86:/data/data/com.billion.helloworld $ cd shared_prefs
6.generic_x86:/data/data/com.billion.helloworld/shared_prefs $ ls
7.WebViewChromiumPrefs.xml com.billion.helloworld_preferences.xml userInfo.xml
8.generic_x86:/data/data/com.billion.helloworld/shared_prefs $ cat userInfo.xml

具体内容：
<?xml version='1.0' encoding='utf-8' standalone='yes' ?>
<map>
    //键值对形式
    <string name="name">JackAndRose</string>
</map>
generic_x86:/data/data/com.billion.helloworld/shared_prefs $
 */