package com.billion.helloworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class CheckedBoxActivity extends AppCompatActivity {
    private CheckBox cb4, cb5, cb6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checked_box);
        cb4 = (CheckBox) findViewById(R.id.cb4);
        cb4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(CheckedBoxActivity.this, isChecked? "4选中": "4未选中", Toast.LENGTH_SHORT).show();
            }
        });
        cb5 = (CheckBox) findViewById(R.id.cb5);
        cb5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(CheckedBoxActivity.this, isChecked? "5选中": "5未选中", Toast.LENGTH_SHORT).show();
            }
        });
        cb6 = (CheckBox) findViewById(R.id.cb6);
        cb6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(CheckedBoxActivity.this, isChecked? "6选中": "6未选中", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
