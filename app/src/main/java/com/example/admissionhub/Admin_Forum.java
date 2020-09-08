package com.example.admissionhub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Admin_Forum extends AppCompatActivity implements  AdapterView.OnItemSelectedListener, View.OnClickListener{

    //FirebaseAuth mAuth;

    EditText appstart,append,exam;
    Spinner universityname;
    Button add;

    DatabaseReference reference;
    String id,university;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__forum);




        universityname = (Spinner) findViewById(R.id.universityname);
        appstart = (EditText) findViewById(R.id.appstart);
        append = (EditText)  findViewById(R.id.append);
        exam = (EditText) findViewById(R.id.exam);
        add = (Button) findViewById(R.id.add);

        add.setOnClickListener(this);


        //mAuth = FirebaseAuth.getInstance();



        reference = FirebaseDatabase.getInstance().getReference().child("UniversityInfo");



       /* reference.addValueEventListener(new ValueEventListener() {



            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Toast.makeText(Admin_Forum.this,"Worked!",Toast.LENGTH_SHORT).show();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    universityInfo uniinfo = dataSnapshot1.getValue(universityInfo.class);
                    if (university.equals(uniinfo.getUniversity()) )
                    {
                        id = uniinfo.getUid();
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });*/


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.University_names, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        universityname.setAdapter(adapter);
        universityname.setOnItemSelectedListener(this);

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
            Intent intt = new Intent(Admin_Forum.this,AdminDashboard.class);
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


         final String apstart = appstart.getText().toString();
        final String apend = append.getText().toString();
        final String exm = exam.getText().toString();

        //Toast.makeText(Admin_Forum.this,university,Toast.LENGTH_SHORT).show();



        if(university.equals("Ahsanullah University of Science and Technology"))
          id= "-MGhRUcWKlxGWeRU3cuC";
        if(university.equals("Shahjalal University of Science and Technology"))
            id= "-MGhR_5dLxr9_NzxmZKm";
        if(university.equals("Islamic University of Technology"))
            id= "-MGhRgKLcRNuQyYR3GU4";
        if(university.equals("Bangladesh University of Engineering and Technology"))
            id= "-MGhRom5GQM45C-j6Wye";
        if(university.equals("University of Dhaka"))
            id= "-MGhRxtCk4a9R2sFN32i";
        if(university.equals("Jahangirnagar University"))
            id= "-MGhS1N8GEWCm6WHfX77";

        reference.child(id).child("apstart").setValue(apstart);
        reference.child(id).child("apend").setValue(apend);
        reference.child(id).child("exm").setValue(exm);

        Toast.makeText(Admin_Forum.this,"Information Updated",Toast.LENGTH_SHORT).show();


       /* String key = reference.push().getKey();

        universityInfo uniinfo = new universityInfo(university, apstart, apend, exm, key);

        reference.child(key).setValue(uniinfo);*/





    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        university = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
