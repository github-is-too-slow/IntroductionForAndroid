package com.billion.helloworld;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {
    private WebView mWb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        mWb = (WebView) findViewById(R.id.wv);
//        //1.加载本地app/src/main/assets/下的HTML文件
//        mWb.loadUrl("file:///android_asset/duniang.html");
        //2.加载网络URL,m代表移动端站点,www代表PC端站点
            //开启javascript
        mWb.getSettings().setJavaScriptEnabled(true);
            //设置在Activity内部加载网页，而不跳转到浏览器加载
        mWb.setWebViewClient(new MyWebViewClient());
            //设置进度条和activity标题为网页标题
        mWb.setWebChromeClient(new MyWebChromeClient());
        mWb.loadUrl("https://m.baidu.com");

    }

    class MyWebChromeClient extends WebChromeClient{
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
//            设置加载进度条，newProgress值在0-100之间
            super.onProgressChanged(view, newProgress);
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            //设置activity标题为网页标题，网页标题被当做参数title传进来
            setTitle(title);
        }
    }

    class MyWebViewClient extends WebViewClient{
        //页面开始加载回调函数
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            Log.d("pageStarted", "onPageStarted...");
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            //加载指定页面,url被封装到request中
            view.loadUrl(request.getUrl().toString());
            //指定不跳转
            return true;
        }

        //页面加载结束
        @Override
        public void onPageFinished(WebView view, String url) {
//            //native执行js代码方式1
//            mWb.loadUrl("javascript:alert('加载结束')");
            //native执行js代码方式2,第二个参数指定回调函数
            mWb.evaluateJavascript("javascript:alert('加载结束')", null);
            super.onPageFinished(view, url);
        }
    }

    //重载onKeyDown方法可以回退至上一页面，而不是退出activity
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == event.KEYCODE_BACK && mWb.canGoBack()){
            mWb.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
