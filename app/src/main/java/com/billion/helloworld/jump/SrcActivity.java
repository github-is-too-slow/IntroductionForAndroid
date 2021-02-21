package com.billion.helloworld.jump;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.billion.helloworld.R;
import com.billion.helloworld.utils.ToastUtils;

public class SrcActivity extends AppCompatActivity {
    private Button mBtnJump;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_src);
        mBtnJump = (Button) findViewById(R.id.btn_jump);
        mBtnJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                //隐式跳转
                intent.setAction("srcToDest");
                //Activity间的数据传递，通过Bubble传递
                Bundle bundle = new Bundle();//类似于Map
                bundle.putString("name", "Jack");
                bundle.putInt("age", 20);
                intent.putExtras(bundle);
                //startActivity(intent);
                //参数2：请求码
                startActivityForResult(intent, 0);
            }
        });
    }


    //重载ActivityResult，接受从DestActivity中setResult(0, intent);返回的数据
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ToastUtils.showMsg(SrcActivity.this, "requestCode=" + requestCode + ", resultCode=" +
                            resultCode + ", title=" + data.getExtras().getString("title"));
    }
}
