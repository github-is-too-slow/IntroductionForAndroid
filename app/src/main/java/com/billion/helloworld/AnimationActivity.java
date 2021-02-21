package com.billion.helloworld;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class AnimationActivity extends AppCompatActivity {
    private TextView mTvHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        mTvHello = (TextView) findViewById(R.id.tv_hello);
//        //动画1：沿Y轴平移500dp，持续时间2秒钟
//        mTvHello.animate().translationYBy(500).setDuration(2000).start();
//        //动画2：背景色逐渐变淡，透明度
//        mTvHello.animate().alpha(0).setDuration(2000).start();
        //动画3：ValueAnimator，值动画，从0变化到100
//        final ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 100);
//        valueAnimator.setDuration(2000);
//        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                //动画的当前值
//                Log.d("value", animation.getAnimatedValue() + "");
//                //动画的当前进度0~1，不一定是均匀变化
//                Log.d("progress", animation.getAnimatedFraction() + "");
//            }
//        });
//        valueAnimator.start();
        //动画4：ObjectAnimator，对象属性变化
        //参数1：目标控件，参数2：动画字符串，取值：translationX、translationY、alpha、Roration、RorationX
        //参数3：变化起始值0--500-200
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mTvHello, "translationY", 0, 500, 200);
        objectAnimator.setDuration(4000);
        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //TODO，监听变化值
            }
        });
        objectAnimator.start();
    }
}
