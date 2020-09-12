package com.example.admissionhub;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class eligibility extends AppCompatActivity implements View.OnClickListener {

    ImageView aust,buet,du,ju,sust,iut;
    RadioButton austb,buetb,dub,jub,sustb,iutb;
    Button update;


    FirebaseAuth mAuth;
    DatabaseReference reference;
    String email,password,fllname,phn,grp,ssgpa,hsgpa,usrId;
    String austt,juu,iutt,buett,sustt,duu,quiz_marks;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eligibility);

        mAuth = FirebaseAuth.getInstance();
        reference = FirebaseDatabase.getInstance().getReference().child("USERINFO");

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


        aust = findViewById(R.id.aust);
        buet = findViewById(R.id.buet);
        du = findViewById(R.id.du);
        ju = findViewById(R.id.ju);
        iut = findViewById(R.id.iut);
        sust = findViewById(R.id.sust);
        update= findViewById(R.id.update);


        austb = findViewById(R.id.austb);
        buetb = findViewById(R.id.buetb);
        dub = findViewById(R.id.dub);
        jub = findViewById(R.id.jub);
        iutb = findViewById(R.id.iutb);
        sustb = findViewById(R.id.sustb);






        double d=Double.parseDouble(ssgpa);
        double a=Double.parseDouble(hsgpa);



        a=a+d;



        if(a>=10.0){
            ju.setVisibility(View.GONE);
            du.setVisibility(View.GONE);
            sust.setVisibility(View.GONE);

            aust.setVisibility(View.GONE);
            iut.setVisibility(View.GONE);
            buet.setVisibility(View.GONE);

        }

        else if(a>=9.0 && a<10.0)
        {
            aust.setImageResource(R.drawable.cross);
            buet.setImageResource(R.drawable.cross);
            iut.setImageResource(R.drawable.cross);

            austb.setVisibility(View.GONE);
            buetb.setVisibility(View.GONE);
            iutb.setVisibility(View.GONE);

            sust.setVisibility(View.GONE);
            du.setVisibility(View.GONE);
            ju.setVisibility(View.GONE);



        }

        else{
            aust.setImageResource(R.drawable.cross);

            buet.setImageResource(R.drawable.cross);

            iut.setImageResource(R.drawable.cross);

            du.setImageResource(R.drawable.cross);

            sust.setImageResource(R.drawable.cross);

            austb.setVisibility(View.GONE);
            buetb.setVisibility(View.GONE);
            iutb.setVisibility(View.GONE);
            sustb.setVisibility(View.GONE);
            dub.setVisibility(View.GONE);

            ju.setVisibility(View.GONE);


        }


        if(austt.length()==2){
            austb.setVisibility(View.GONE);
            aust.setVisibility(View.VISIBLE);
        }

        if(juu.length()==2){
            jub.setVisibility(View.GONE);
            ju.setVisibility(View.VISIBLE);
        }

        if(buett.length()==2){
            buetb.setVisibility(View.GONE);
            buet.setVisibility(View.VISIBLE);

        }

        if(iutt.length()==2){
            iutb.setVisibility(View.GONE);
            iut.setVisibility(View.VISIBLE);
        }

        if(duu.length()==2){
            dub.setVisibility(View.GONE);
            du.setVisibility(View.VISIBLE);
        }
        if(sustt.length()==2){
            sustb.setVisibility(View.GONE);
            sust.setVisibility(View.VISIBLE);
        }





        update.setOnClickListener(this);







    }

    public void onClick(View v) {


        if(austb.isChecked()) {
            reference.child(usrId).child("aust").setValue("OK");

        }

        if(sustb.isChecked()) {
            reference.child(usrId).child("sust").setValue("OK");

        }

        if(buetb.isChecked()){
            reference.child(usrId).child("buet").setValue("OK");

        }

        if(iutb.isChecked()){
            reference.child(usrId).child("iut").setValue("OK");

        }

        if(dub.isChecked()){
            reference.child(usrId).child("du").setValue("OK");

        }

        if(jub.isChecked()) {
            reference.child(usrId).child("ju").setValue("OK");

        }






        Toast.makeText(eligibility.this, "Application Data updated", Toast.LENGTH_SHORT).show();

        Intent intt = new Intent(eligibility.this,dashboard.class);



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
            Intent intt = new Intent(eligibility.this,userprofile.class);
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
            Intent intt = new Intent(eligibility.this,activity_change_password.class);
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
