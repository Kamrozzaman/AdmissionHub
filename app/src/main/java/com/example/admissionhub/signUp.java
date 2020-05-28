package com.example.admissionhub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.graphics.drawable.Drawable;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.ProviderQueryResult;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signUp extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    String[] Group_names;
    Spinner group;
    EditText fullname, username, password, confirmpassword, phone, sscgpa, hscgpa;
    Button signup;
    String grp;
    DatabaseReference dr;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        dr = FirebaseDatabase.getInstance().getReference("USERINFO");

        fullname = (EditText) findViewById(R.id.fullname);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        confirmpassword = (EditText) findViewById(R.id.confirmpassword);
        phone = (EditText) findViewById(R.id.phone);
        sscgpa = (EditText) findViewById(R.id.sscgpa);
        hscgpa = (EditText) findViewById(R.id.hscgpa);
        signup = (Button) findViewById(R.id.signup);
        group = (Spinner) findViewById(R.id.group);


        mAuth = FirebaseAuth.getInstance();

        signup.setOnClickListener(this);


        Group_names = getResources().getStringArray(R.array.Group_names);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Group_names, android.R.layout.simple_spinner_item);
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
        int var = pssword.compareTo(confirmpssword);


        //Toast.makeText(this, pssword+" "+confirmpssword, Toast.LENGTH_SHORT).show();

        if (fllname.length() == 0) {

            fullname.setError("");
        }

        if (usrname.length() == 0) {
            username.setError("");

        }

        if (pssword.length() == 0) {

            password.setError("");
        }

        if (confirmpssword.length() == 0) {
            confirmpassword.setError("");

        }

        if (phn.length() == 0) {
            phone.setError("");
        }

        if (ssgpa.length() == 0) {
            sscgpa.setError("");
        }

        if (hsgpa.length() == 0) {
            hscgpa.setError("");
        } else if (var != 0) {
            Toast.makeText(this, "password and confirm password does not match", Toast.LENGTH_SHORT).show();

        } else {

            UserRegister();

            //userRegister();


           /* Toast.makeText(this, "Sign Up Successful!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(signUp.this, logSign.class);
            startActivity(intent);*/

        }


    }

    private void UserRegister() {
        String email = username.getText().toString().trim();
        String pssword = password.getText().toString().trim();

        //Checking validity of email
        if(email.isEmpty())
        {
            username.setError("Enter an email address");
            username.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            username.setError("Enter a valid email address");
            username.requestFocus();
            return;
        }

        mAuth.fetchSignInMethodsForEmail(email).addOnCompleteListener(new OnCompleteListener<SignInMethodQueryResult>() {
            @Override
            public void onComplete(@NonNull Task<SignInMethodQueryResult> task) {
                boolean check=task.getResult().getSignInMethods().isEmpty();

                if(!check) {
                    username.setError("You are already registered with this E-mail address!");
                    username.requestFocus();
                    return;
                }
            }
        });

        if(pssword.isEmpty())
        {
            password.setError("Enter a password");
            password.requestFocus();
            return;
        }

        if(pssword.length()<6)
        {
            password.setError("Minimum length of a password should be 6");
            password.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email,pssword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    //Toast.makeText(getApplicationContext(), "Authentication Successful!", Toast.LENGTH_SHORT).show();
                    userRegister();

                    Toast.makeText(getApplicationContext(), "Sign Up Successful!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(signUp.this, logSign.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Sign Up Not Successful!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


    private void userRegister() {

        String fllname = fullname.getText().toString();
        String usrname = username.getText().toString();
        String pssword = password.getText().toString();
        String confirmpssword = confirmpassword.getText().toString();
        String phn = phone.getText().toString();
        String ssgpa = sscgpa.getText().toString();
        String hsgpa = hscgpa.getText().toString();
        //grp = parent.getItemAtPosition(position).toString();

        //Toast.makeText(this, grp, Toast.LENGTH_SHORT).show();
        String key = dr.push().getKey();
        userInfo userinfo = new userInfo(fllname,usrname,pssword,phn,ssgpa,hsgpa,grp);

        dr.child(key).setValue(userinfo);
    }
}
