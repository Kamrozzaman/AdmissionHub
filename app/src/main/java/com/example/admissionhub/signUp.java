package com.example.admissionhub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class signUp extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener{

    String[] Group_names;
    Database db;
    Spinner group;
    EditText fullname,username,password,confirmpassword,phone,sscgpa,hscgpa;
    Button signup;
    String grp;
    UserDetails userdetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        fullname = (EditText) findViewById(R.id.fullname);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        confirmpassword = (EditText) findViewById(R.id.confirmpassword);
        phone = (EditText) findViewById(R.id.phone);
        sscgpa = (EditText) findViewById(R.id.sscgpa);
        hscgpa = (EditText) findViewById(R.id.hscgpa);
        signup = (Button) findViewById(R.id.signup);
        group = (Spinner) findViewById(R.id.group);

        userdetails = new UserDetails();
        db = new Database(this);


        signup.setOnClickListener(this);



        Group_names = getResources().getStringArray(R.array.Group_names);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.Group_names,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        group.setAdapter(adapter);
        group.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

       grp = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {

        String fllname = fullname.getText().toString();
        String usrname = username.getText().toString();
        String pssword = password.getText().toString();
        String confirmpssword = confirmpassword.getText().toString();
        String phn = phone.getText().toString();
        String ssgpa = sscgpa.getText().toString();
        String hsgpa = hscgpa.getText().toString();

        //Toast.makeText(this, pssword+" "+confirmpssword, Toast.LENGTH_SHORT).show();


               userdetails.setFllname(fllname);
               userdetails.setUsrname(usrname);
               userdetails.setPssword(pssword);

               userdetails.setPhn(phn);
               userdetails.setSsgpa(ssgpa);
               userdetails.setHsgpa(hsgpa);
               userdetails.setGrp(grp);


               db.insertData(userdetails);

               Toast.makeText(this, "Sign Up Successful!", Toast.LENGTH_SHORT).show();
               Intent intent = new Intent(signUp.this, logSign.class);
               startActivity(intent);


    }
}
