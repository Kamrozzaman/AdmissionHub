package com.example.admissionhub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 4500;
    AnimationDrawable animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView loading =  (ImageView)findViewById(R.id.loading);
         animation = (AnimationDrawable)loading.getDrawable();
         animation.start();
        new Handler().postDelayed(new Runnable() {

            public void run() {

                Intent one = new Intent(MainActivity.this,adminORuser.class);
                startActivity(one);
                finish();
            }
        },SPLASH_TIME_OUT);
        getSupportActionBar().hide();

    }
}
