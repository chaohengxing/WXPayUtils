package com.chx.wxpay.wxpayutils;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.tencent.mm.opensdk.openapi.IWXAPI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //在服务端签名
        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //假装请求了服务器 获取到了所有的数据
                WXPayUtils.WXPayBuilder builder = new WXPayUtils.WXPayBuilder();
                builder.setAppId("123")
                        .setPartnerId("56465")
                        .setPrepayId("41515")
                        .setPackageValue("5153")
                        .setNonceStr("5645")
                        .setTimeStamp("56512")
                        .setSign("54615")
                        .build().toWXPayNotSign(MainActivity.this,"123");
            }
        });
        //在客户端签名
        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //假装请求了服务端信息，并获取了appid、partnerId、prepayId
                WXPayUtils.WXPayBuilder builder = new WXPayUtils.WXPayBuilder();
                builder.setAppId("123")
                        .setPartnerId("213")
                        .setPrepayId("3213")
                        .setPackageValue("Sign=WXPay")
                        .build()
                        .toWXPayAndSign(MainActivity.this,"123","key");
            }
        });
    }
}
