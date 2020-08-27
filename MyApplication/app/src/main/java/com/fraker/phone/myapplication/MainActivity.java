package com.fraker.phone.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URLEncoder;
import java.nio.charset.Charset;

public class MainActivity extends AppCompatActivity {

    public static final String APPID = "2021001187657520"; // 申请的ID

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
    }


    @SuppressLint("WrongConstant")
    public void openTestScheme(View view) {
        String url = "https://authweb.alipay.com/auth?auth_type=PURE_OAUTH_SDK&app_id=" + APPID + "&scope=auth_user&state=init";
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("package", "com.fraker.phone.myapplication"); // 需要集成的应用的包名，就是你们自己APP的包名
            jsonObject.put("appId", "20000067");// 写死的
            jsonObject.put("sdkVersion", "h.a.3.6.4"); // 写死的
            jsonObject.put("scheme", "__test123__"); // 必须和AndroidManifest.xml中注册的 AlipayResultActivity 中的 scheme 保持一致
            jsonObject.put("session", "112233");
            jsonObject.put("mqpURL", "alipays://platformapi/startapp?appId=20000067&mqpPkgName=com.alipay.sdk.pay.demo&mqpScene=sdk&url=" + URLEncoder.encode(url));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        String payload = Base64.encodeToString(jsonObject.toString().getBytes(Charset.forName("UTF-8")), Base64.NO_WRAP);
        Uri uri = (new Uri.Builder()).scheme("alipays").authority("platformapi").path("startapp").appendQueryParameter("appId", "20001129").appendQueryParameter("payload", payload).build();
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        intent.setPackage("com.eg.android.AlipayGphone"); // 支付宝的包名 写死的 不用修改
        startActivity(intent);
    }
}
