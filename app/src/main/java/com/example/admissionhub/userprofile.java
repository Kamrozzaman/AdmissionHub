package com.example.admissionhub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class userprofile extends AppCompatActivity implements View.OnClickListener{


    FirebaseAuth mAuth;
    Button updateInfoButton;

    String emal,pssword,fllname,phn,grp,ssgpa,hsgpa,sgpa,hgpa,usrId;
    TextView fullname,email,phone,group,sscgpa,hscgpa;
    String austt,juu,iutt,buett,sustt,duu,quiz_marks;
    private DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofile);

        FirebaseAuth mAuth;

        updateInfoButton = (Button) findViewById(R.id.updateDataButtonId);
        updateInfoButton.setOnClickListener(this);

        emal = getIntent().getStringExtra("EMAIL");
        //Toast.makeText(this, emal, Toast.LENGTH_SHORT).show();
        pssword = getIntent().getStringExtra("PASS");
        fllname = getIntent().getStringExtra("FULLNAME");
        phn = getIntent().getStringExtra("PHONE");
        grp = getIntent().getStringExtra("GROUP");
        ssgpa = getIntent().getStringExtra("SSCGPA");
        hsgpa = getIntent().getStringExtra("HSCGPA");
        usrId = getIntent().getStringExtra("USERID");

        austt= getIntent().getStringExtra("AUST");
        duu = getIntent() .getStringExtra("DU");
        juu = getIntent().getStringExtra("JU");
        sustt = getIntent().getStringExtra("SUST");
        iutt = getIntent().getStringExtra("IUT");
        buett = getIntent().getStringExtra("BUET");
        quiz_marks =getIntent().getStringExtra("QUIZ_MARKS");

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
            intt.putExtra("USERID",usrId);
            intt.putExtra("AUST",austt);
            intt.putExtra("DU",duu);
            intt.putExtra("JU",juu);
            intt.putExtra("BUET",buett);
            intt.putExtra("QUIZ_MARKS",quiz_marks);
            intt.putExtra("SUST",sustt);
            intt.putExtra("IUT",iutt);
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
            intt.putExtra("USERID",usrId);

            intt.putExtra("AUST",austt);
            intt.putExtra("DU",duu);
            intt.putExtra("JU",juu);
            intt.putExtra("BUET",buett);
            intt.putExtra("QUIZ_MARKS",quiz_marks);
            intt.putExtra("SUST",sustt);
            intt.putExtra("IUT",iutt);
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
            intt.putExtra("USERID",usrId);

            intt.putExtra("AUST",austt);
            intt.putExtra("DU",duu);
            intt.putExtra("JU",juu);
            intt.putExtra("BUET",buett);
            intt.putExtra("QUIZ_MARKS",quiz_marks);
            intt.putExtra("SUST",sustt);
            intt.putExtra("IUT",iutt);
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
    public void onClick(View v) {
        if (v.getId() == R.id.updateDataButtonId) {
            Intent intt = new Intent(userprofile.this, updateData.class);
            intt.putExtra("EMAIL",emal);

            intt.putExtra("PASS",pssword);
            intt.putExtra("FULLNAME",fllname);
            intt.putExtra("PHONE",phn);

            intt.putExtra("GROUP",grp);
            intt.putExtra("SSCGPA",sgpa);
            intt.putExtra("HSCGPA",hgpa);
            intt.putExtra("USERID",usrId);

            intt.putExtra("AUST",austt);
            intt.putExtra("DU",duu);
            intt.putExtra("JU",juu);
            intt.putExtra("BUET",buett);
            intt.putExtra("QUIZ_MARKS",quiz_marks);
            intt.putExtra("SUST",sustt);
            intt.putExtra("IUT",iutt);
            startActivity(intt);
        }
    }
}
