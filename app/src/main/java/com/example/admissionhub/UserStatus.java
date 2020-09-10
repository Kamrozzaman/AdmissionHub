package com.example.admissionhub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserStatus extends AppCompatActivity {

    FirebaseAuth mAuth;
    String email,password,fllname,phn,grp,ssgpa,hsgpa,usrId;
    TextView noapply;
    TextView head1 ,head2 , aust1 , aust2 , ju1 , ju2 , du1 , du2 , iut1 , iut2 ;
    TextView buet1 , buet2 , sust1 , sust2;

    String austt,juu,iutt,buett,sustt,duu,quiz_marks;
    boolean check;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_status);



        mAuth = FirebaseAuth.getInstance();

        noapply = findViewById(R.id.noapply);
        head1 = findViewById(R.id.head1);
        head2 = findViewById(R.id.head2);

        aust1 = findViewById(R.id.aust1);
        aust2 = findViewById(R.id.aust2);

        du1 = findViewById(R.id.du1);
        du2 = findViewById(R.id.du2);

        ju1 = findViewById(R.id.ju1);
        ju2 = findViewById(R.id.ju2);

        iut1 = findViewById(R.id.iut1);
        iut2 = findViewById(R.id.iut2);

        buet1 = findViewById(R.id.buet1);
        buet2 = findViewById(R.id.buet2);

        sust1 = findViewById(R.id.sust1);
        sust2 = findViewById(R.id.sust2);







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


        head1.setVisibility(View.GONE);
        head2.setVisibility(View.GONE);

        aust1.setVisibility(View.GONE);
        aust2.setVisibility(View.GONE);

        ju1.setVisibility(View.GONE);
        ju2.setVisibility(View.GONE);

        du1.setVisibility(View.GONE);
        du2.setVisibility(View.GONE);

        buet2.setVisibility(View.GONE);
        buet1.setVisibility(View.GONE);

        du1.setVisibility(View.GONE);
        du2.setVisibility(View.GONE);

        iut1.setVisibility(View.GONE);
        iut2.setVisibility(View.GONE);

        noapply.setVisibility(View.GONE);

        sust1.setVisibility(View.GONE);
        sust2.setVisibility(View.GONE);

        check = false;

        if(austt.length()==2){
            check = true;
        }

        if(juu.length()==2){
            check = true;
        }

        if(buett.length()==2){
            check = true;

        }

        if(iutt.length()==2){
            check = true;
        }

        if(duu.length()==2){
            check = true;
        }
        if(sustt.length()==2){
            check = true;
        }


        if(check==false){
            noapply.setVisibility(View.VISIBLE);
        }

        if(check==true){
            head1.setVisibility(View.VISIBLE);
            head2.setVisibility(View.VISIBLE);

            if(austt.length()==2){
                aust1.setVisibility(View.VISIBLE);
                aust2.setVisibility(View.VISIBLE);
            }

            if(juu.length()==2){
                ju1.setVisibility(View.VISIBLE);
                ju2.setVisibility(View.VISIBLE);
            }

            if(buett.length()==2){
                check = true;
                buet1.setVisibility(View.VISIBLE);
                buet2.setVisibility(View.VISIBLE);

            }

            if(iutt.length()==2){
                check = true;
                iut1.setVisibility(View.VISIBLE);
                iut2.setVisibility(View.VISIBLE);
            }

            if(duu.length()==2){
                check = true;
                du1.setVisibility(View.VISIBLE);
                du2.setVisibility(View.VISIBLE);
            }
            if(sustt.length()==2){
                check = true;
                sust1.setVisibility(View.VISIBLE);
                sust2.setVisibility(View.VISIBLE);
            }

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
            Intent intt = new Intent(UserStatus.this,dashboard.class);
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
            Intent intt = new Intent(UserStatus.this,userprofile.class);
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
            Intent intt = new Intent(UserStatus.this,activity_change_password.class);
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
