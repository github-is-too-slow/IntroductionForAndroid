package com.billion.helloworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageViewActivity extends AppCompatActivity {
    private ImageView  mImg2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        mImg2 = (ImageView) findViewById(R.id.img2);
//        使用第三方工具glide设置网络图片
//        1,github上搜索glide
//        2.使用Gradle下载glide
//        3.同步下载
//        4.在manifest文件中开启网络请求
//        5.使用glide下载网络图片至imageView控件中
        Glide.with(this).load("http://sjbz.fd.zol-img.com.cn/t_s320x480c/g5/M00/00/02/ChMkJlfJU3-IRNNIAANS2BCeetEAAU9qgGgPA0AA1Lw853.jpg").into(mImg2);
    }
}
