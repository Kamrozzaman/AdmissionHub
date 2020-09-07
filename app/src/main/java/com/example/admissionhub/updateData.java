package com.example.admissionhub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class updateData extends AppCompatActivity implements View.OnClickListener{

    FirebaseAuth mAuth;
    DataSnapshot dataSnapshot;
    String email,password,fllname,phn,grp,ssgpa,hsgpa,usrId;
    Button updateDataButton;
    EditText fullname,phone,sscgpa,hscgpa;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);

        mAuth = FirebaseAuth.getInstance();
        reference = FirebaseDatabase.getInstance().getReference().child("USERINFO");

        updateDataButton = (Button) findViewById(R.id.updateInfoButtonId);
        updateDataButton.setOnClickListener(this);

        email = getIntent().getStringExtra("EMAIL");
        //Toast.makeText(this, emal, Toast.LENGTH_SHORT).show();
        password = getIntent().getStringExtra("PASS");
        fllname = getIntent().getStringExtra("FULLNAME");
        phn = getIntent().getStringExtra("PHONE");
        grp = getIntent().getStringExtra("GROUP");
        ssgpa = getIntent().getStringExtra("SSCGPA");
        hsgpa = getIntent().getStringExtra("HSCGPA");
        usrId = getIntent().getStringExtra("USERID");


        fullname = findViewById(R.id.fullNameId);
        phone = findViewById(R.id.phoneId);
        sscgpa = findViewById(R.id.sscgpaId);
        hscgpa =  findViewById(R.id.hscgpaId);

        reference.addValueEventListener(new ValueEventListener() {
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    userInfo userinfo = dataSnapshot1.getValue(userInfo.class);
                    if (email.equals(userinfo.getUsrname()) )
                    {
                        usrId = userinfo.getUSERID();
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        // Toast.makeText(this, emal, Toast.LENGTH_SHORT).show();

        fullname.setText(fllname);
        phone.setText(phn);
        sscgpa.setText(ssgpa);
        hscgpa.setText(hsgpa);
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
            Intent intt = new Intent(updateData.this,dashboard.class);
            intt.putExtra("EMAIL",email);

            intt.putExtra("PASS",password);
            intt.putExtra("FULLNAME",fllname);
            intt.putExtra("PHONE",phn);

            intt.putExtra("GROUP",grp);
            intt.putExtra("SSCGPA",ssgpa);
            intt.putExtra("HSCGPA",hsgpa);
            intt.putExtra("USERID",usrId);
            startActivity(intt);
        }
        else if(item.getItemId()==R.id.userProfileMenuId)
        {
            Intent intt = new Intent(updateData.this,userprofile.class);
            intt.putExtra("EMAIL",email);

            intt.putExtra("PASS",password);
            intt.putExtra("FULLNAME",fllname);
            intt.putExtra("PHONE",phn);

            intt.putExtra("GROUP",grp);
            intt.putExtra("SSCGPA",ssgpa);
            intt.putExtra("HSCGPA",hsgpa);
            intt.putExtra("USERID",usrId);
            startActivity(intt);
        }
        else if(item.getItemId()==R.id.changePasswordMenuId)
        {
            finish();
            Intent intt = new Intent(updateData.this,activity_change_password.class);
            intt.putExtra("EMAIL",email);

            intt.putExtra("PASS",password);
            intt.putExtra("FULLNAME",fllname);
            intt.putExtra("PHONE",phn);

            intt.putExtra("GROUP",grp);
            intt.putExtra("SSCGPA",ssgpa);
            intt.putExtra("HSCGPA",hsgpa);
            intt.putExtra("USERID",usrId);
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

    @Override
    public void onClick(View v)
    {
        update();

    }

    public void update()
    {

        if(isDataChanged())
        {
            Toast.makeText(this,"Data has been updated!",Toast.LENGTH_SHORT).show();
            Intent intt = new Intent(updateData.this,userprofile.class);
            intt.putExtra("EMAIL",email);

            intt.putExtra("PASS",password);
            intt.putExtra("FULLNAME",fllname);
            intt.putExtra("PHONE",phn);

            intt.putExtra("GROUP",grp);
            intt.putExtra("SSCGPA",ssgpa);
            intt.putExtra("HSCGPA",hsgpa);
            startActivity(intt);
        }
        else
        {
            Toast.makeText(this,"Data is same and can not be updated!",Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isDataChanged()
    {
        boolean check = false;
        String name= fullname.getText().toString();
        String mob=  phone.getText().toString();
        String gpa1= sscgpa.getText().toString();
        String gpa2= hscgpa.getText().toString();
        if(!fllname.equals(fullname.getText().toString()))
        {
            if (name.length() == 0)
            {
                fullname.setError("");
                check=false;
            }
            else {
                reference.child(usrId).child("fllname").setValue(fullname.getText().toString());
                fllname = fullname.getText().toString();
                check=true;
            }
        }
        if(!phn.equals(phone.getText().toString()))
        {
            if (mob.length() == 0)
            {
                phone.setError("");
                check=false;
            }
            else
            {
                reference.child(usrId).child("phn").setValue(phone.getText().toString());
                phn=phone.getText().toString();
                check=true;
            }
        }
        if(!ssgpa.equals(sscgpa.getText().toString()))
        {
            if (gpa1.length() == 0)
            {
                sscgpa.setError("");
                check=false;
            }
            else
            {
                reference.child(usrId).child("ssgpa").setValue(sscgpa.getText().toString());
                ssgpa=sscgpa.getText().toString();
                check=true;
            }
        }
        if(!hsgpa.equals(hscgpa.getText().toString()))
        {
            if (gpa2.length() == 0)
            {
                hscgpa.setError("");
                check=false;
            }
            else
            {
                reference.child(usrId).child("hsgpa").setValue(hscgpa.getText().toString());
                hsgpa=hscgpa.getText().toString();
                check=true;
            }
        }
        return check;
    }

}
