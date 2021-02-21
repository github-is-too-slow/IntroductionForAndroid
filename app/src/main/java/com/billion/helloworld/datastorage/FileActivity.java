package com.billion.helloworld.datastorage;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.billion.helloworld.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileActivity extends AppCompatActivity {
    private EditText mEtContent;
    private Button mBtnSave, mBtnShow;
    private TextView mTvContent;
    //openFileOutput、openFileInput是File内部存储API，默认只存储到/data/data/<applicationId>目录中
    //File外部存储（又分公有目录和私有目录）使用正常的FileOutputStream、fileInputStream流进行存储，只是目录不同（在sd卡上）
    //使用提供的API获取外部目录
    private final String mFileName = "userInfo.text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
        mEtContent = (EditText) findViewById(R.id.et_content);
        mBtnSave = (Button) findViewById(R.id.btn_save);
        mBtnShow = (Button) findViewById(R.id.btn_show);
        mTvContent = (TextView) findViewById(R.id.tv_content);
        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save(mEtContent.getText().toString());
            }
        });
        mBtnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvContent.setText(read());
            }
        });
        //动态申请File外部存储权限
        //参数2：权限数组，参数3：请求码
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
    }

    private void save(String content){
        FileOutputStream fos = null;
        try {
            //指定外部存储目录
            File dir = new File(Environment.getExternalStorageDirectory()/*返回一个File对象*/, "billion");
            if(!dir.exists()){//指定目录不存在，则创建一个新目录
                dir.mkdirs();
            }
            File file = new File(dir, mFileName);
            if(!file.exists()){//指定文件不存在，则创建一个新文件
                file.createNewFile();
            }
            //File外部存储获取指定文件对应的输出流
            fos = new FileOutputStream(file);
//            File内部存储获取指定文件对应的输出流，直接写文件名即可
//            fos = openFileOutput(mFileName, MODE_PRIVATE);
            fos.write(content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null != fos){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private String read(){
        FileInputStream fis = null;
        try {
//            File内部存储获取指定文件对应的输出流，直接写文件名即可
//            fis = openFileInput(mFileName);
            //File外部存储获取指定文件对应的输出流
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() +
                                    File.separator + "billion", mFileName);
            fis = new FileInputStream(file);
            byte[] buffer = new byte[1024];
            int len = 0;
            StringBuilder sb = new StringBuilder();
            while((len = fis.read(buffer)) > 0){
                sb.append(new String(buffer, 0, len));
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null != fis){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
