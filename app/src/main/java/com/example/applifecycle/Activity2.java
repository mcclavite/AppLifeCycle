package com.example.applifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import timber.log.Timber;

public class Activity2 extends AppCompatActivity {
    private Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
    }

    protected void onPause(){
        super.onPause();
        Timber.d("on Pause: Activity 2 dead!");
    }
}
