package com.example.admissionhub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class activity_change_password extends AppCompatActivity implements View.OnClickListener {

    String email,password,fllname,phn,grp,ssgpa,hsgpa;

    EditText old_pass, new_pass, confirm_pass;
    Button change_password_button;
    FirebaseAuth auth;
    private DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        email = getIntent().getStringExtra("EMAIL");
        //Toast.makeText(this, email, Toast.LENGTH_SHORT).show();
        password = getIntent().getStringExtra("PASS");
        fllname = getIntent().getStringExtra("FULLNAME");
        phn = getIntent().getStringExtra("PHONE");
        grp = getIntent().getStringExtra("GROUP");
        //Toast.makeText(this, grp, Toast.LENGTH_SHORT).show();
        ssgpa = getIntent().getStringExtra("SSCGPA");
        hsgpa = getIntent().getStringExtra("HSCGPA");

        old_pass = (EditText) findViewById(R.id.change_password_old);
        new_pass = (EditText) findViewById(R.id.change_password_new);
        confirm_pass = (EditText) findViewById(R.id.change_password_confirm);

        change_password_button = (Button) findViewById(R.id.change_password_button);
        change_password_button.setOnClickListener(this);

        auth = FirebaseAuth.getInstance();
    }

    public void change_password(View v) {
        /*FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            user.updatePassword(confirm_pass.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(getApplicationContext(), "Password Changed Successfully!", Toast.LENGTH_SHORT).show();
                        auth.signOut();
                        finish();
                        Intent intt = new Intent(activity_change_password.this, logSign.class);
                        startActivity(intt);
                    } else {
                        Toast.makeText(getApplicationContext(), "Password couldn't be Changed!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }*/

      /* if(old_pass.getText()!=null && new_pass.getText()!=null && confirm_pass.getText()!=null)
       {
            if(new_pass.getText().toString().equals(confirm_pass.getText().toString()))
            {
                final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if(user!=null && user.getEmail()!=null)
                {
                    AuthCredential credential = EmailAuthProvider.getCredential(user.getEmail(), old_pass.getText().toString());

                    // Prompt the user to re-provide their sign-in credentials
                    user.reauthenticate(credential).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful())
                                    {
                                        Toast.makeText(getApplicationContext(),"Re-authentication Successful!",Toast.LENGTH_SHORT).show();

                                        user.updatePassword(confirm_pass.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<Void> task) {
                                                        if (task.isSuccessful()) {
                                                            Toast.makeText(getApplicationContext(),"Password Changed Successfully!",Toast.LENGTH_SHORT).show();
                                                            auth.signOut();
                                                            finish();
                                                            Intent intt = new Intent(activity_change_password.this,logSign.class);
                                                            startActivity(intt);
                                                        }
                                                    }
                                                });
                                    }
                                    else
                                    {
                                        Toast.makeText(getApplicationContext(),"Re-authentication Failed!",Toast.LENGTH_SHORT).show();
                                    }
                                }
                    });
                }
                else
                {
                    finish();
                    Intent intt = new Intent(activity_change_password.this,logSign.class);
                    startActivity(intt);
                }
            }
            else
            {
                Toast.makeText(getApplicationContext(),"New password and Confirm Password missmatching!",Toast.LENGTH_SHORT).show();
            }
       }
       else
       {
           Toast.makeText(getApplicationContext(),"Please fill all the fields",Toast.LENGTH_SHORT).show();
       }*/
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.change_password_button) {

        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.nav_menu_layout,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        Intent intent;

        if(item.getItemId()==R.id.dashboardMenuId)
        {
            Intent intt = new Intent(activity_change_password.this,dashboard.class);
            intt.putExtra("EMAIL",email);

            intt.putExtra("PASS",password);
            intt.putExtra("FULLNAME",fllname);
            intt.putExtra("PHONE",phn);

            intt.putExtra("GROUP",grp);
            intt.putExtra("SSCGPA",ssgpa);
            intt.putExtra("HSCGPA",hsgpa);
            startActivity(intt);
        }
        else if(item.getItemId()==R.id.notificationMenuId)
        {
            Intent intt = new Intent(activity_change_password.this,Notifications.class);
            intt.putExtra("EMAIL",email);

            intt.putExtra("PASS",password);
            intt.putExtra("FULLNAME",fllname);
            intt.putExtra("PHONE",phn);

            intt.putExtra("GROUP",grp);
            intt.putExtra("SSCGPA",ssgpa);
            intt.putExtra("HSCGPA",hsgpa);
            startActivity(intt);
        }
        else if(item.getItemId()==R.id.userStatusMenuId)
        {
            Intent intt = new Intent(activity_change_password.this,UserStatus.class);
            intt.putExtra("EMAIL",email);

            intt.putExtra("PASS",password);
            intt.putExtra("FULLNAME",fllname);
            intt.putExtra("PHONE",phn);

            intt.putExtra("GROUP",grp);
            intt.putExtra("SSCGPA",ssgpa);
            intt.putExtra("HSCGPA",hsgpa);
            startActivity(intt);
        }
        else if(item.getItemId()==R.id.userProfileMenuId)
        {
            Intent intt = new Intent(activity_change_password.this,userprofile.class);
            intt.putExtra("EMAIL",email);

            intt.putExtra("PASS",password);
            intt.putExtra("FULLNAME",fllname);
            intt.putExtra("PHONE",phn);

            intt.putExtra("GROUP",grp);
            intt.putExtra("SSCGPA",ssgpa);
            intt.putExtra("HSCGPA",hsgpa);
            startActivity(intt);
        }
        else if(item.getItemId()==R.id.changePasswordMenuId)
        {
            finish();
            Intent intt = new Intent(activity_change_password.this,activity_change_password.class);
            intt.putExtra("EMAIL",email);

            intt.putExtra("PASS",password);
            intt.putExtra("FULLNAME",fllname);
            intt.putExtra("PHONE",phn);

            intt.putExtra("GROUP",grp);
            intt.putExtra("SSCGPA",ssgpa);
            intt.putExtra("HSCGPA",hsgpa);
            startActivity(intt);
        }
        else if(item.getItemId()==R.id.LogOutMenuId)
        {
            FirebaseAuth.getInstance().signOut();
            finish();
            intent = new Intent(getApplicationContext(),adminORuser.class);
            startActivity(intent);
        }
        return false;
    }
}

