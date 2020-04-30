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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        drawerLayout=findViewById(R.id.drawerId);







        mAuth = FirebaseAuth.getInstance();

       dashboardGridView=(GridView) findViewById(R.id.dashboardGridViewId);

        CustomAdapter adapter = new CustomAdapter(this,flags);
        dashboardGridView.setAdapter(adapter);

        dashboardGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position==0)
                {
                    Toast.makeText(dashboard.this, "Universities Clicked!", Toast.LENGTH_SHORT).show();
                }
                else if(position==1)
                {
                    Toast.makeText(dashboard.this, "Eligibility Clicked!", Toast.LENGTH_SHORT).show();
                }
                else if(position==2)
                {
                    Toast.makeText(dashboard.this, "Notices Clicked!", Toast.LENGTH_SHORT).show();
                }
                else if(position==3)
                {
                    Toast.makeText(dashboard.this, "FAQ Clicked!", Toast.LENGTH_SHORT).show();
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
            Toast.makeText(dashboard.this, "User Profile Clicked!", Toast.LENGTH_SHORT).show();
        }
        else if(item.getItemId()==R.id.changePasswordMenuId)
        {
            Toast.makeText(dashboard.this, "Change Password Clicked!", Toast.LENGTH_SHORT).show();
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
