package com.example.admissionhub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AdminLogin extends AppCompatActivity implements View.OnClickListener {

    EditText email, password;

    String emal, pssword;
    Button login;

    DatabaseReference dr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);


        email.setOnClickListener(this);
        password.setOnClickListener(this);
        login.setOnClickListener(this);

        dr = FirebaseDatabase.getInstance().getReference("AdminInfo");


    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.login) {
            emal = email.getText().toString();
            pssword = password.getText().toString();

            if (emal.length() == 0) {
                email.setError("");

            }

            if (pssword.length() == 0) {
                password.setError("");

            } else {


                dr.addValueEventListener(new ValueEventListener() {

                    boolean check = false;

                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            AdminInfo admininfo = dataSnapshot1.getValue(AdminInfo.class);

                            if (emal.equals(admininfo.getEmail()) && pssword.equals(admininfo.getPassword())) {

                                Intent intent = new Intent(AdminLogin.this, AdminDashboard.class);


                                startActivity(intent);
                                email.setText(null);
                                password.setText(null);
                                check = true;
                                break;


                            }


                        }

                        if (check == false) {
                            Toast.makeText(AdminLogin.this, "Wrong username or password", Toast.LENGTH_SHORT).show();
                        }


                    }


                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }

        }
    }
}
