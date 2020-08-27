package com.example.admissionhub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class userprofile extends AppCompatActivity {


    FirebaseAuth mAuth;

    String emal,pssword,fllname,phn,grp,ssgpa,hsgpa,sgpa,hgpa;
    TextView fullname,email,phone,group,sscgpa,hscgpa;
    private DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofile);

        FirebaseAuth mAuth;

        emal = getIntent().getStringExtra("EMAIL");
        //Toast.makeText(this, emal, Toast.LENGTH_SHORT).show();
        pssword = getIntent().getStringExtra("PASS");
        fllname = getIntent().getStringExtra("FULLNAME");
        phn = getIntent().getStringExtra("PHONE");
        grp = getIntent().getStringExtra("GROUP");
        ssgpa = getIntent().getStringExtra("SSCGPA");
        hsgpa = getIntent().getStringExtra("HSCGPA");

        sgpa=ssgpa;
        hgpa=hsgpa;

        fullname = (TextView) findViewById(R.id.fullname);
        email = (TextView) findViewById(R.id.email);
        phone = (TextView) findViewById(R.id.phone);
        group = (TextView) findViewById(R.id.group);
        sscgpa = (TextView) findViewById(R.id.sscgpa);
        hscgpa = (TextView) findViewById(R.id.hscgpa);

        ssgpa+=" (SSC)";
        hsgpa+=" (HSC)";


           // Toast.makeText(this, emal, Toast.LENGTH_SHORT).show();

        fullname.setText(fllname);
        email.setText(emal);
        phone.setText(phn);
        group.setText(grp);
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
            Intent intt = new Intent(userprofile.this,dashboard.class);
            intt.putExtra("EMAIL",emal);

            intt.putExtra("PASS",pssword);
            intt.putExtra("FULLNAME",fllname);
            intt.putExtra("PHONE",phn);

            intt.putExtra("GROUP",grp);
            intt.putExtra("SSCGPA",sgpa);
            intt.putExtra("HSCGPA",hgpa);
            startActivity(intt);
        }
        else if(item.getItemId()==R.id.notificationMenuId)
        {
            Intent intt = new Intent(userprofile.this,Notifications.class);
            intt.putExtra("EMAIL",emal);

            intt.putExtra("PASS",pssword);
            intt.putExtra("FULLNAME",fllname);
            intt.putExtra("PHONE",phn);

            intt.putExtra("GROUP",grp);
            intt.putExtra("SSCGPA",sgpa);
            intt.putExtra("HSCGPA",hgpa);
            startActivity(intt);
        }
        else if(item.getItemId()==R.id.userStatusMenuId)
        {
            Intent intt = new Intent(userprofile.this,UserStatus.class);
            intt.putExtra("EMAIL",emal);

            intt.putExtra("PASS",pssword);
            intt.putExtra("FULLNAME",fllname);
            intt.putExtra("PHONE",phn);

            intt.putExtra("GROUP",grp);
            intt.putExtra("SSCGPA",sgpa);
            intt.putExtra("HSCGPA",hgpa);
            startActivity(intt);
        }
        else if(item.getItemId()==R.id.userProfileMenuId)
        {
            Intent intt = new Intent(userprofile.this,userprofile.class);
            intt.putExtra("EMAIL",emal);

            intt.putExtra("PASS",pssword);
            intt.putExtra("FULLNAME",fllname);
            intt.putExtra("PHONE",phn);

            intt.putExtra("GROUP",grp);
            intt.putExtra("SSCGPA",sgpa);
            intt.putExtra("HSCGPA",hgpa);
            startActivity(intt);
        }
        else if(item.getItemId()==R.id.changePasswordMenuId)
        {
            finish();
            Intent intt = new Intent(userprofile.this,activity_change_password.class);
            intt.putExtra("EMAIL",emal);

            intt.putExtra("PASS",pssword);
            intt.putExtra("FULLNAME",fllname);
            intt.putExtra("PHONE",phn);

            intt.putExtra("GROUP",grp);
            intt.putExtra("SSCGPA",sgpa);
            intt.putExtra("HSCGPA",hgpa);
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
