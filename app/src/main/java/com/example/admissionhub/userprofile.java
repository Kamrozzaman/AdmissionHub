package com.example.admissionhub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class userprofile extends AppCompatActivity {

    String emal,pssword,fllname,phn,grp,ssgpa,hsgpa;
    TextView fullname,email,phone,group,sscgpa,hscgpa;
    private DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofile);

        emal = getIntent().getStringExtra("EMAIL");
        //Toast.makeText(this, emal, Toast.LENGTH_SHORT).show();
        pssword = getIntent().getStringExtra("PASS");
        fllname = getIntent().getStringExtra("FULLNAME");
        phn = getIntent().getStringExtra("PHONE");
        grp = getIntent().getStringExtra("GROUP");
        ssgpa = getIntent().getStringExtra("SSCGPA");
        hsgpa = getIntent().getStringExtra("HSCGPA");

        fullname = (TextView) findViewById(R.id.fullname);
        email = (TextView) findViewById(R.id.email);
        phone = (TextView) findViewById(R.id.phone);
        group = (TextView) findViewById(R.id.group);
        sscgpa = (TextView) findViewById(R.id.sscgpa);
        hscgpa = (TextView) findViewById(R.id.hscgpa);

        ssgpa+=" (SSC)";
        hsgpa+=" (HSC)";


           // Toast.makeText(this, emal, Toast.LENGTH_SHORT).show();

        fullname.setText(fllname);
        email.setText(emal);
        phone.setText(phn);
        group.setText(grp);
        sscgpa.setText(ssgpa);
        hscgpa.setText(hsgpa);




    }
}
