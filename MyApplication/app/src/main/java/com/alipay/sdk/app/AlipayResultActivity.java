package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


public class AlipayResultActivity extends Activity {


    protected void onCreate(Bundle var1) {
        super.onCreate(var1);

        Intent intent = getIntent();
        // 获取 authCode
        String authCode = intent != null ? intent.getBundleExtra("result").getString("auth_code") : "-10001";
        Log.e("xxxxxx", "authcode = " + authCode);
        Toast.makeText(this, "authCode = " + authCode, Toast.LENGTH_SHORT).show();
        finish();
    }

}
