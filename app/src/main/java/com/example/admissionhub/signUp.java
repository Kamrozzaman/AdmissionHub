package com.example.admissionhub;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class signUp extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] Group_names;
    Spinner group;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Group_names = getResources().getStringArray(R.array.Group_names);
        group = (Spinner) findViewById(R.id.group);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.Group_names,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        group.setAdapter(adapter);
        group.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
