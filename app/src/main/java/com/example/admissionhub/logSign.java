package com.example.admissionhub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.FirebaseDatabase;

public class logSign extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth authenticate;
    TextView signup,forgotpassword;
    EditText User , Password;

    String password,usrname;
    Button loginButton;

    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_sign);

        getSupportActionBar().hide();

        reference = FirebaseDatabase.getInstance().getReference().child("USERINFO");

        signup = (TextView) findViewById(R.id.signup);
        signup.setOnClickListener(this);

        User = findViewById(R.id.username);
        Password = findViewById(R.id.password);
        authenticate= FirebaseAuth.getInstance();

        forgotpassword = (TextView) findViewById(R.id.forgotpassword);
        forgotpassword.setOnClickListener(this);

        loginButton=(Button) findViewById(R.id.login);
        loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.signup) {
            Intent intent = new Intent(logSign.this, signUp.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.forgotpassword) {
            Intent intent = new Intent(logSign.this, forgotPassword.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.login) {

            usrname = User.getText().toString();
            password = Password.getText().toString();

            if (usrname.length() == 0) {
                User.setError("");

            }

            if (password.length() == 0) {
                Password.setError("");

            }

            else{


                authenticate.signInWithEmailAndPassword(usrname, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            reference.addValueEventListener(new ValueEventListener() {

                                boolean check = false;

                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                        userInfo userinfo = dataSnapshot1.getValue(userInfo.class);

                                        if (usrname.equals(userinfo.getUsrname()) ) {

                                            Intent intent = new Intent(logSign.this, dashboard.class);
                                            intent.putExtra("EMAIL",usrname);
                                            intent.putExtra("PASS",password);
                                            intent.putExtra("FULLNAME",userinfo.getFllname());
                                            intent.putExtra("PHONE",userinfo.getPhn());
                                            intent.putExtra("GROUP",userinfo.getGrp());
                                            intent.putExtra("SSCGPA",userinfo.getSsgpa());
                                            intent.putExtra("HSCGPA",userinfo.getHsgpa());
                                            intent.putExtra("USERID",userinfo.getUSERID());
                                            intent.putExtra("AUST",userinfo.getAust());
                                            intent.putExtra("DU",userinfo.getDu());
                                            intent.putExtra("JU",userinfo.getJu());
                                            intent.putExtra("BUET",userinfo.getBuet());
                                            intent.putExtra("QUIZ_MARKS",userinfo.getQuiz_marks());
                                            intent.putExtra("SUST",userinfo.getSust());
                                            intent.putExtra("IUT",userinfo.getIut());

                                            startActivity(intent);
                                            break;


                                        }


                                    }


                                }


                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });

                        }

                        else{
                            Toast.makeText(logSign.this,"Login Failed",Toast.LENGTH_SHORT).show();
                        }

                    }
                });






        }

    }
    }
}
