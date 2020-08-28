package com.example.admissionhub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forgotPassword extends AppCompatActivity {
    Button bt;
    EditText em;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        bt = findViewById(R.id.frbutton);
        em= findViewById(R.id.fremail);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = em.getText().toString();
                if(email.length()==0){
                    em.setError("");
                    return;
                }

                FirebaseAuth.getInstance().sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        if(task.isSuccessful()){
                            Toast.makeText(forgotPassword.this , "Please check your email" , Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(forgotPassword.this, logSign.class);
                            startActivity(intent);
                        }
                        else{
                          Toast.makeText(forgotPassword.this , "Enter Correct Email", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}
