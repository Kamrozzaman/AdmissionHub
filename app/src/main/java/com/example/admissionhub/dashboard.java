package com.example.admissionhub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class dashboard extends AppCompatActivity {

    DrawerLayout drawerLayout;

    private GridView dashboardGridView;
    int[] flags={R.drawable.universities_icon,R.drawable.eligibility_icon,R.drawable.notices_icon,R.drawable.faq_icon,R.drawable.userstatus_icon,R.drawable.guideline_icon,
            R.drawable.quiz_icon,R.drawable.about_icon};

    FirebaseAuth mAuth;
    String email,password,fllname,phn,grp,ssgpa,hsgpa,usrId;
    String austt,juu,iutt,buett,sustt,duu,quiz_marks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        drawerLayout=findViewById(R.id.drawerId);

        email = getIntent().getStringExtra("EMAIL");
        //Toast.makeText(this, email, Toast.LENGTH_SHORT).show();
        password = getIntent().getStringExtra("PASS");
        fllname = getIntent().getStringExtra("FULLNAME");
        phn = getIntent().getStringExtra("PHONE");
        grp = getIntent().getStringExtra("GROUP");
        //Toast.makeText(this, grp, Toast.LENGTH_SHORT).show();
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





        mAuth = FirebaseAuth.getInstance();

       dashboardGridView=(GridView) findViewById(R.id.dashboardGridViewId);

        CustomAdapter adapter = new CustomAdapter(this,flags);
        dashboardGridView.setAdapter(adapter);

        dashboardGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position==0)
                {
                    Intent intt = new Intent(dashboard.this, universities.class);

                    intt.putExtra("EMAIL",email);
                    intt.putExtra("PASS",password);
                    intt.putExtra("FULLNAME",fllname);
                    intt.putExtra("PHONE",phn);
                    intt.putExtra("GROUP",grp);
                    intt.putExtra("SSCGPA",ssgpa);
                    intt.putExtra("HSCGPA",hsgpa);
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
                else if(position==1)
                {
                    Intent intt = new Intent(dashboard.this, eligibility.class);

                    intt.putExtra("EMAIL",email);
                    intt.putExtra("PASS",password);
                    intt.putExtra("FULLNAME",fllname);
                    intt.putExtra("PHONE",phn);
                    intt.putExtra("GROUP",grp);
                    intt.putExtra("SSCGPA",ssgpa);
                    intt.putExtra("HSCGPA",hsgpa);
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
                else if(position==2)
                {
                    Intent intt = new Intent(dashboard.this, Notices.class);
                    intt.putExtra("EMAIL",email);

                    intt.putExtra("PASS",password);
                    intt.putExtra("FULLNAME",fllname);
                    intt.putExtra("PHONE",phn);

                    intt.putExtra("GROUP",grp);
                    intt.putExtra("SSCGPA",ssgpa);
                    intt.putExtra("HSCGPA",hsgpa);
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
                else if(position==3)
                {
                    Intent intt = new Intent(dashboard.this, FAQ.class);

                    intt.putExtra("EMAIL",email);
                    intt.putExtra("PASS",password);
                    intt.putExtra("FULLNAME",fllname);
                    intt.putExtra("PHONE",phn);
                    intt.putExtra("GROUP",grp);
                    intt.putExtra("SSCGPA",ssgpa);
                    intt.putExtra("HSCGPA",hsgpa);
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
                else if(position==4)
                {
                    Intent intt = new Intent(dashboard.this, UserStatus.class);
                    intt.putExtra("EMAIL",email);

                    intt.putExtra("PASS",password);
                    intt.putExtra("FULLNAME",fllname);
                    intt.putExtra("PHONE",phn);

                    intt.putExtra("GROUP",grp);
                    intt.putExtra("SSCGPA",ssgpa);
                    intt.putExtra("HSCGPA",hsgpa);
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
                else if(position==5)
                {
                    Intent intt = new Intent(dashboard.this, guidelines.class);
                    intt.putExtra("EMAIL",email);
                    intt.putExtra("PASS",password);
                    intt.putExtra("FULLNAME",fllname);
                    intt.putExtra("PHONE",phn);
                    intt.putExtra("GROUP",grp);
                    intt.putExtra("SSCGPA",ssgpa);
                    intt.putExtra("HSCGPA",hsgpa);
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
                else if(position==6)
                {
                    Intent intt = new Intent(dashboard.this, Quiz.class);
                    intt.putExtra("EMAIL",email);

                    intt.putExtra("PASS",password);
                    intt.putExtra("FULLNAME",fllname);
                    intt.putExtra("PHONE",phn);

                    intt.putExtra("GROUP",grp);
                    intt.putExtra("SSCGPA",ssgpa);
                    intt.putExtra("HSCGPA",hsgpa);
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
                else if(position==7)
                {
                    Intent intt = new Intent(dashboard.this, about.class);
                    intt.putExtra("EMAIL",email);

                    intt.putExtra("PASS",password);
                    intt.putExtra("FULLNAME",fllname);
                    intt.putExtra("PHONE",phn);

                    intt.putExtra("GROUP",grp);
                    intt.putExtra("SSCGPA",ssgpa);
                    intt.putExtra("HSCGPA",hsgpa);
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
        });
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
            Intent intt = new Intent(dashboard.this,dashboard.class);
            intt.putExtra("EMAIL",email);

            intt.putExtra("PASS",password);
            intt.putExtra("FULLNAME",fllname);
            intt.putExtra("PHONE",phn);

            intt.putExtra("GROUP",grp);
            intt.putExtra("SSCGPA",ssgpa);
            intt.putExtra("HSCGPA",hsgpa);
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
            Intent intt = new Intent(dashboard.this,userprofile.class);
            intt.putExtra("EMAIL",email);

            intt.putExtra("PASS",password);
            intt.putExtra("FULLNAME",fllname);
            intt.putExtra("PHONE",phn);

            intt.putExtra("GROUP",grp);
            intt.putExtra("SSCGPA",ssgpa);
            intt.putExtra("HSCGPA",hsgpa);
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
            Intent intt = new Intent(dashboard.this,activity_change_password.class);
            intt.putExtra("EMAIL",email);

            intt.putExtra("PASS",password);
            intt.putExtra("FULLNAME",fllname);
            intt.putExtra("PHONE",phn);

            intt.putExtra("GROUP",grp);
            intt.putExtra("SSCGPA",ssgpa);
            intt.putExtra("HSCGPA",hsgpa);
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

}
