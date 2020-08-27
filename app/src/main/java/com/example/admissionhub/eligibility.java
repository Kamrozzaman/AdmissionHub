package com.example.admissionhub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class eligibility extends AppCompatActivity {

    ImageView aust,buet,du,ju,sust,iut;
    private DatabaseReference ref;

    FirebaseAuth mAuth;
    String email,password,fllname,phn,grp,ssgpa,hsgpa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eligibility);

        mAuth = FirebaseAuth.getInstance();

        email = getIntent().getStringExtra("EMAIL");
        //Toast.makeText(this, email, Toast.LENGTH_SHORT).show();
        password = getIntent().getStringExtra("PASS");
        fllname = getIntent().getStringExtra("FULLNAME");
        phn = getIntent().getStringExtra("PHONE");
        grp = getIntent().getStringExtra("GROUP");
        //Toast.makeText(this, grp, Toast.LENGTH_SHORT).show();
        ssgpa = getIntent().getStringExtra("SSCGPA");
        hsgpa = getIntent().getStringExtra("HSCGPA");

        aust = findViewById(R.id.aust);
        buet = findViewById(R.id.buet);
        du = findViewById(R.id.du);
        ju = findViewById(R.id.ju);
        iut = findViewById(R.id.iut);
        sust = findViewById(R.id.sust);


        double d=Double.parseDouble(ssgpa);
        double a=Double.parseDouble(hsgpa);

        a=a+d;

        if(a<10.0)
        {
            aust.setImageResource(R.drawable.cross);
            buet.setImageResource(R.drawable.cross);
            iut.setImageResource(R.drawable.cross);
        }

        if(a<9.00){
            aust.setImageResource(R.drawable.cross);

            buet.setImageResource(R.drawable.cross);

            iut.setImageResource(R.drawable.cross);

            du.setImageResource(R.drawable.cross);

            sust.setImageResource(R.drawable.cross);


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
            Intent intt = new Intent(eligibility.this,dashboard.class);
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
            Intent intt = new Intent(eligibility.this,Notifications.class);
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
            Intent intt = new Intent(eligibility.this,UserStatus.class);
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
            Intent intt = new Intent(eligibility.this,userprofile.class);
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
            Intent intt = new Intent(eligibility.this,activity_change_password.class);
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
