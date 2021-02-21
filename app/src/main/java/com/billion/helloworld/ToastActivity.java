package com.billion.helloworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.billion.helloworld.utils.ToastUtils;

public class ToastActivity extends AppCompatActivity {
    private Button mToast1, mToast2, mToast3, mtoast4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        mToast1 = (Button) findViewById(R.id.btn_toast1);
        mToast2 = (Button) findViewById(R.id.btn_toast2);
        mToast3 = (Button) findViewById(R.id.btn_toast3);
        mtoast4 = (Button) findViewById(R.id.btn_toast4);
        OnClick onClick = new OnClick();
        mToast1.setOnClickListener(onClick);
        mToast2.setOnClickListener(onClick);
        mToast3.setOnClickListener(onClick);
        mtoast4.setOnClickListener(onClick);
    }

    class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_toast1://默认样式
                    Toast.makeText(getApplicationContext(), "默认Toast", Toast.LENGTH_LONG).show();
                    break;
                case R.id.btn_toast2://居中显示
                    Toast centerToast = Toast.makeText(getApplicationContext(), "居中Toast", Toast.LENGTH_LONG);
//                    设置居中显示
                    centerToast.setGravity(Gravity.CENTER, 0, 0);
                    centerToast.show();
                    break;
                case R.id.btn_toast3:
                    Toast customToast = new Toast(getApplicationContext());
                    LayoutInflater inflater= LayoutInflater.from(ToastActivity.this);
//                    获取对应的View
                    View view = inflater.inflate(R.layout.layout_toast, null);
//                    获取控件的子控件
                    ImageView imageView = (ImageView) view.findViewById(R.id.iv_toast);
                    TextView textView = (TextView) view.findViewById(R.id.tv_toast);
//                    设置子控件内容
                    imageView.setImageResource(R.drawable.smile_100_100);
                    textView.setText("笑哈哈");
//                    设置Toast控件的布局
                    customToast.setView(view);
//                    设置时长
                    customToast.setDuration(Toast.LENGTH_SHORT);
//                    展示
                    customToast.show();
                    break;
                case R.id.btn_toast4:
                    ToastUtils.showMsg(getApplicationContext(), "ToastUtils");
                    break;
            }
        }
    }
}
