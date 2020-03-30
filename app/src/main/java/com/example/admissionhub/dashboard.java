package com.example.admissionhub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;

import com.google.android.material.navigation.NavigationView;

public class dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    private GridView dashboardGridView;
    int[] flags={R.drawable.universities_icon,R.drawable.eligibility_icon,R.drawable.notices_icon,R.drawable.faq_icon,R.drawable.forum_icon,R.drawable.guideline_icon,
            R.drawable.quiz_icon};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        drawerLayout=findViewById(R.id.drawerId);

        NavigationView navigationView=findViewById(R.id.navigationId);
        navigationView.setNavigationItemSelectedListener(this);
        toggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.nav_open,R.string.nav_close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dashboardGridView=(GridView) findViewById(R.id.dashboardGridViewId);

        CustomAdapter adapter = new CustomAdapter(this,flags);
        dashboardGridView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(toggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        Intent intent;

        if(menuItem.getItemId()==R.id.dashboardMenuId)
        {

        }

        else if(menuItem.getItemId()==R.id.notificationMenuId)
        {

        }

        else if(menuItem.getItemId()==R.id.userStatusMenuId)
        {

        }

        else if(menuItem.getItemId()==R.id.userProfileMenuId)
        {

        }

        else if(menuItem.getItemId()==R.id.changePasswordMenuId)
        {

        }

        else if(menuItem.getItemId()==R.id.LogOutMenuId)
        {

        }
        return false;
    }
}
