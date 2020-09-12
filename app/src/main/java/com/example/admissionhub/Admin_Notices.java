package com.example.admissionhub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Admin_Notices extends AppCompatActivity implements View.OnClickListener {

    FirebaseAuth mAuth;

    EditText title,description;
    Button add;
    DatabaseReference dr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__notices);

        mAuth = FirebaseAuth.getInstance();

        title = (EditText) findViewById(R.id.title);
        description = (EditText) findViewById(R.id.description);
        add = (Button) findViewById(R.id.add);

        add.setOnClickListener(this);

        dr = FirebaseDatabase.getInstance().getReference("Notices");
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
            Intent intt = new Intent(Admin_Notices.this,AdminDashboard.class);
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

        String titl = title.getText().toString();
        String des = description.getText().toString();
        String key = dr.push().getKey();

        NoticeInfo noti = new NoticeInfo(titl,des);

        dr.child(key).setValue(noti);

        title.setText(null);
        description.setText(null);

        Toast.makeText(Admin_Notices.this, "Notice Added", Toast.LENGTH_SHORT).show();




    }
}
