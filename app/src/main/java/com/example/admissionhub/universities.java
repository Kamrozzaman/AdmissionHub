package com.example.admissionhub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class universities extends AppCompatActivity implements View.OnClickListener {

    TextView buet,du,ju,sust,aust,iut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_universities);

        buet = (TextView) findViewById(R.id.buet);
        buet.setOnClickListener(this);

        du = (TextView) findViewById(R.id.du);
        du.setOnClickListener(this);

        sust = (TextView) findViewById(R.id.sust);
        sust.setOnClickListener(this);

        ju = (TextView) findViewById(R.id.ju);
        ju.setOnClickListener(this);

        aust = (TextView) findViewById(R.id.aust);
        aust.setOnClickListener(this);

        iut = (TextView) findViewById(R.id.iut);
        iut.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.buet)
        {
            Intent intent = new Intent(universities.this,Buet.class);
            startActivity(intent);
        }
        if(v.getId() == R.id.du)
        {
            Intent intent = new Intent(universities.this,DU.class);
            startActivity(intent);
        }
        if(v.getId() == R.id.sust)
        {
            Intent intent = new Intent(universities.this,Sust.class);
            startActivity(intent);
        }
        if(v.getId() == R.id.ju)
        {
            Intent intent = new Intent(universities.this,JU.class);
            startActivity(intent);
        }
        if(v.getId() == R.id.aust)
        {
            Intent intent = new Intent(universities.this,AUST.class);
            startActivity(intent);
        }
        if(v.getId() == R.id.iut)
        {
            Intent intent = new Intent(universities.this,IUT.class);
            startActivity(intent);
        }
    }
}
