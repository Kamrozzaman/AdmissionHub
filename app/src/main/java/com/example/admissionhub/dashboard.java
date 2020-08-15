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
    int[] flags={R.drawable.universities_icon,R.drawable.eligibility_icon,R.drawable.notices_icon,R.drawable.faq_icon,R.drawable.forum_icon,R.drawable.guideline_icon,
            R.drawable.quiz_icon};

    FirebaseAuth mAuth;
    String email,password,fllname,phn,grp,ssgpa,hsgpa;
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

                    startActivity(intt);
                }
                else if(position==1)
                {
                    Intent intt = new Intent(dashboard.this, eligibility.class);
                    intt.putExtra("SSCGPA",ssgpa);
                    intt.putExtra("HSCGPA",hsgpa);

                    startActivity(intt);
                }
                else if(position==2)
                {
                    Toast.makeText(dashboard.this, "Notices Clicked!", Toast.LENGTH_SHORT).show();
                }
                else if(position==3)
                {
                    Intent intt = new Intent(dashboard.this, FAQ.class);
                    startActivity(intt);
                }
                else if(position==4)
                {
                    Toast.makeText(dashboard.this, "Forum Clicked!", Toast.LENGTH_SHORT).show();
                }
                else if(position==5)
                {
                    Toast.makeText(dashboard.this, "Guideline Clicked!", Toast.LENGTH_SHORT).show();
                }
                else if(position==6)
                {
                    //Toast.makeText(dashboard.this, "Quiz Clicked!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(dashboard.this, logSign.class);

                    startActivity(intent);
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
            Toast.makeText(dashboard.this, "DashBoard Clicked!", Toast.LENGTH_SHORT).show();
        }
        else if(item.getItemId()==R.id.notificationMenuId)
        {
            Toast.makeText(dashboard.this, "Notification Clicked!", Toast.LENGTH_SHORT).show();
        }
        else if(item.getItemId()==R.id.userStatusMenuId)
        {
            Toast.makeText(dashboard.this, "User Status Clicked!", Toast.LENGTH_SHORT).show();
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
            startActivity(intt);
        }
        else if(item.getItemId()==R.id.changePasswordMenuId)
        {
            finish();
            Intent intt = new Intent(dashboard.this,activity_change_password.class);
            startActivity(intt);
        }
        else if(item.getItemId()==R.id.LogOutMenuId)
        {
            FirebaseAuth.getInstance().signOut();
            finish();
            intent = new Intent(getApplicationContext(),logSign.class);
            startActivity(intent);
        }
        return false;
    }

}
