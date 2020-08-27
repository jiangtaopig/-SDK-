package com.fraker.phone.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class ResultActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("sssss", "onCreate: " + getIntent().getBundleExtra("result").toString());
    }
}
