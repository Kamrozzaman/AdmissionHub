package com.example.admissionhub;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdminSignup_temp extends AppCompatActivity implements View.OnClickListener{

    EditText email, password;
    Button signup;

    DatabaseReference dr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_signup_temp);


        dr = FirebaseDatabase.getInstance().getReference("AdminInfo");

        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        signup = (Button) findViewById(R.id.signup);

        signup.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {


     String emal = email.getText().toString();
     String pssword = password.getText().toString();
     String key = dr.push().getKey();

     AdminInfo admininfo  = new AdminInfo(emal,pssword);

     dr.child(key).setValue(admininfo);
    }
}
