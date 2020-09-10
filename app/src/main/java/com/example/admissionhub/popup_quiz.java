package com.example.admissionhub;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;

public class popup_quiz extends AppCompatActivity implements View.OnClickListener{

    Dialog myDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_quiz);

        myDialog = new Dialog(this);
    }

    @Override
    public void onClick(View v) {

    }
}
