package com.billion.helloworld.datastorage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.billion.helloworld.R;

public class DataStorageActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mBtnShared;
    private Button mBtnFile;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_storage);
        mBtnShared = (Button) findViewById(R.id.btn_shared);
        mBtnFile = (Button) findViewById(R.id.btn_file);
        mBtnShared.setOnClickListener(this);
        mBtnFile.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()){
            case R.id.btn_shared:
                intent =  new Intent(DataStorageActivity.this, SharedPreferencesActivity.class);
                break;
            case R.id.btn_file:
                intent =  new Intent(DataStorageActivity.this, FileActivity.class);
                break;
        }
        startActivity(intent);
    }
}
