package com.example.admissionhub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class logSign extends AppCompatActivity implements View.OnClickListener{

    TextView signup,forgotpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_sign);

        getSupportActionBar().hide();

        signup = (TextView) findViewById(R.id.signup);
        signup.setOnClickListener(this);

        forgotpassword = (TextView) findViewById(R.id.forgotpassword);
        forgotpassword.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.signup)
        {
            Intent intent = new Intent(logSign.this,signUp.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.forgotpassword)
        {
            Intent intent = new Intent(logSign.this,forgotPassword.class);
            startActivity(intent);
        }
    }
}
