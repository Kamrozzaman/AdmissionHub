package com.example.admissionhub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class logSign extends AppCompatActivity implements View.OnClickListener{

    TextView signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_sign);

        getSupportActionBar().hide();

        signup = (TextView) findViewById(R.id.signup);
        signup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.signup)
        {
            Intent intent = new Intent(logSign.this,signUp.class);
            startActivity(intent);
        }

    }
}
