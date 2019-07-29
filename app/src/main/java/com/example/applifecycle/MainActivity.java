package com.example.applifecycle;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.sql.Time;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity {
    private Button helloBtn, activity2Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(BuildConfig.DEBUG){
            Timber.plant(new Timber.DebugTree());
        }
        Timber.d("On Create: Application launched!");
        setContentView(R.layout.activity_main);
        Timber.d("On Create: Activity 1 created!");

        helloBtn = findViewById(R.id.btnHello);
        activity2Btn = findViewById(R.id.secondActBtn);

        helloBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlert();
            }
        });

        activity2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Activity2.class));
            }
        });

    }
    public void showAlert(){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("Hello World");
        Timber.d("Something on Top!");

        builder1.setPositiveButton(
                "OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        Timber.d("Something gone!");
                    }
                }
        );
        AlertDialog alertHelloWorld = builder1.create();
        alertHelloWorld.show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Timber.d("On Stop: Activity 1 Stopped");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Timber.d("On Start: Activity 1 Started");
    }

//    @Override
//    protected void onResume(){
//        super.onResume();
//        Timber.d("On Resume: Activity 1 Started!");
//    }

//    @Override
//    protected void onPause(){
//        super.onPause();
//        Timber.d("On Pause: Pause!");
//    }
}
