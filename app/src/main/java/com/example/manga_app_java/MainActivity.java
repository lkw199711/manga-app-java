package com.example.manga_app_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webview = (WebView)findViewById(R.id.webview);

        //是否允许执行js，默认为false。设置true时，会提醒可能造成XSS漏洞
        webview.getSettings().setJavaScriptEnabled(true);
        //设置js可以直接打开窗口，如window.open()，默认为false
        webview.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        //是否使用缓存
        webview.getSettings().setAppCacheEnabled(true);

        webview.getSettings().setDomStorageEnabled(true);//DOM Storage

        webview.getSettings().setUseWideViewPort(true);//设置此属性，可任意比例缩放。大视图模式

        webview.getSettings().setSupportZoom(true);//是否可以缩放，默认true

        webview.getSettings().setLoadWithOverviewMode(true);//和setUseWideViewPort(true)一起解决网页自适应问题

        //加载地址
        webview.loadUrl("https://manga.tt2.ink");

        //加载webView自己的环境 去加载页面
        webview.setWebViewClient(new WebViewClient() {
            @Override

            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                view.loadUrl(url);

                return true;

            }

        });


        /*网上的配置示例
        webview.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);//设置js可以直接打开窗口，如window.open()，默认为false
        webview.getSettings().setJavaScriptEnabled(true);//是否允许执行js，默认为false。设置true时，会提醒可能造成XSS漏洞
        webview.getSettings().setSupportZoom(true);//是否可以缩放，默认true
        webview.getSettings().setBuiltInZoomControls(true);//是否显示缩放按钮，默认false
        webview.getSettings().setUseWideViewPort(true);//设置此属性，可任意比例缩放。大视图模式
        webview.getSettings().setLoadWithOverviewMode(true);//和setUseWideViewPort(true)一起解决网页自适应问题
        webview.getSettings().setAppCacheEnabled(true);//是否使用缓存
        webview.getSettings().setDomStorageEnabled(true);//DOM Storage
        // displayWebview.getSettings().setUserAgentString("User-Agent:Android");//设置用户代理，一般不用
        */
    }
}