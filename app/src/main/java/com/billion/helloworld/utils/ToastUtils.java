package com.billion.helloworld.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by 13360 on 2021/2/17.
 */

public class ToastUtils {
//    静态类变量避免了多次显示Toast内容排队的情形
    private static Toast mCustomToast;

    public static void showMsg(Context context, String msg){
        if(mCustomToast == null){
            mCustomToast = Toast.makeText(context, msg, Toast.LENGTH_LONG);
        }else{
            mCustomToast.setText(msg);
        }
        mCustomToast.show();
    }
}
