package com.example.admissionhub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class adminORuser extends AppCompatActivity implements View.OnClickListener{

    ImageView user, admin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_oruser);

        user = (ImageView) findViewById(R.id.user);
        admin = (ImageView) findViewById(R.id.admin);

        user.setOnClickListener(this);
        admin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.user)
        {
            Intent intent = new Intent(adminORuser.this,logSign.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.admin)
        {
            Intent intent = new Intent(adminORuser.this,AdminLogin.class);
            startActivity(intent);
        }

    }
}
