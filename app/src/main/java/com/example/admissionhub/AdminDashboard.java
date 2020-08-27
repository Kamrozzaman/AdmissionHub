package com.example.admissionhub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class AdminDashboard extends AppCompatActivity implements View.OnClickListener {

    FirebaseAuth mAuth;
    ImageView Notice,Forum,About,Logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        mAuth = FirebaseAuth.getInstance();

        Notice = (ImageView) findViewById(R.id.adminNoticesId);
        Forum = (ImageView) findViewById(R.id.adminForumId);
        About = (ImageView) findViewById(R.id.adminAboutId);
        Logout = (ImageView) findViewById(R.id.adminLogoutId);

        Notice.setOnClickListener(this);
        Forum.setOnClickListener(this);
        About.setOnClickListener(this);
        Logout.setOnClickListener(this);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_for_non_dashboard,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        Intent intent;

        if(item.getItemId()==R.id.newDashboardMenuId)
        {
            Intent intt = new Intent(AdminDashboard.this,AdminDashboard.class);
            startActivity(intt);
        }
        else if(item.getItemId()==R.id.newLogOutMenuId)
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

        if(v.getId()==R.id.adminNoticesId)
        {
            Intent intent = new Intent(AdminDashboard.this,Admin_Notices.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.adminForumId)
        {
            Intent intent = new Intent(AdminDashboard.this , Admin_Forum.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.adminAboutId)
        {
            Intent intent = new Intent(AdminDashboard.this,Admin_About.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.adminLogoutId)
        {
            FirebaseAuth.getInstance().signOut();
            finish();
            Intent intent = new Intent(getApplicationContext(),adminORuser.class);
            startActivity(intent);
        }

    }
}


