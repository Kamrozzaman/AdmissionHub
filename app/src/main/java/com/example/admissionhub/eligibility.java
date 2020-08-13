package com.example.admissionhub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class eligibility extends AppCompatActivity {

    String emal,pssword,fllname,phn,grp,ssgpa,hsgpa;
    TextView aust,buet,du,ju,sust,iut;
    private DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eligibility);

        ssgpa = getIntent().getStringExtra("SSCGPA");
        hsgpa = getIntent().getStringExtra("HSCGPA");

        aust = findViewById(R.id.aust);
        buet = findViewById(R.id.buet);
        du = findViewById(R.id.du);
        ju = findViewById(R.id.ju);
        iut = findViewById(R.id.iut);
        sust = findViewById(R.id.sust);


        double d=Double.parseDouble(ssgpa);
        double a=Double.parseDouble(hsgpa);

        a=a+d;

        if(a<10.0)
        {
            aust.setText("NO\n");
            buet.setText("NO\n");
            iut.setText("NO\n");
        }

        if(a<9.00){
            aust.setText("NO\n");
            aust.setBackgroundColor(Color.parseColor("#FF0000"));
            buet.setText("NO\n");
            buet.setBackgroundColor(Color.parseColor("#FF0000"));
            iut.setText("NO\n");
            iut.setBackgroundColor(Color.parseColor("#FF0000"));
            du.setText("NO\n");
            du.setBackgroundColor(Color.parseColor("#FF0000"));
            sust.setText("NO\n");
            sust.setBackgroundColor(Color.parseColor("#FF0000"));

        }


    }
}
