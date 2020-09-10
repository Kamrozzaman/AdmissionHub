package com.example.admissionhub;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Quiz extends AppCompatActivity implements View.OnClickListener{

    FirebaseAuth mAuth;
    String email,password,fllname,phn,grp,ssgpa,hsgpa,usrId;
    String austt,juu,iutt,buett,sustt,duu,quiz_marks;
    RadioGroup radioGroup1,radioGroup2,radioGroup3,radioGroup4,radioGroup5,radioGroup6,radioGroup7,radioGroup8,radioGroup9,radioGroup10;
    Button finishAttemptButton;
    RadioButton radioButton1, radioButton2, radioButton3, radioButton4, radioButton5, radioButton6, radioButton7, radioButton8, radioButton9,radioButton10;
    int curMark=0;
    String prevMark;
    DatabaseReference reference;
    Dialog myDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

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

        prevMark=quiz_marks;

        radioGroup1 = findViewById(R.id.question1);
        radioGroup2 = findViewById(R.id.Question2);
        radioGroup3 = findViewById(R.id.Question3);
        radioGroup4 = findViewById(R.id.Question4);
        radioGroup5 = findViewById(R.id.Question5);
        radioGroup6 = findViewById(R.id.Question6);
        radioGroup7 = findViewById(R.id.Question7);
        radioGroup8 = findViewById(R.id.Question8);
        radioGroup9 = findViewById(R.id.Question9);
        radioGroup10 = findViewById(R.id.Question10);

        radioButton1 = findViewById(R.id.qstn1Optn2);
        radioButton2 = findViewById(R.id.qstn2Optn3);
        radioButton3 = findViewById(R.id.qstn3Optn4);
        radioButton4 = findViewById(R.id.qstn4Optn2);
        radioButton5 = findViewById(R.id.qstn5Optn2);
        radioButton6 = findViewById(R.id.qstn6Optn2);
        radioButton7 = findViewById(R.id.qstn7Optn1);
        radioButton8 = findViewById(R.id.qstn8Optn2);
        radioButton9 = findViewById(R.id.qstn9Optn3);
        radioButton10 = findViewById(R.id.qstn10Optn1);

        finishAttemptButton = findViewById(R.id.finishAttemptButtonId);
        finishAttemptButton.setOnClickListener(this);

        myDialog = new Dialog(this);
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
            Intent intt = new Intent(Quiz.this,dashboard.class);
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
            Intent intt = new Intent(Quiz.this,userprofile.class);
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
            Intent intt = new Intent(Quiz.this,activity_change_password.class);
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

    @Override
    public void onClick(View v) {
        curMark=0;
        if(radioButton1.isChecked())
            curMark++;
        if(radioButton2.isChecked())
            curMark++;
        if(radioButton3.isChecked())
            curMark++;
        if(radioButton4.isChecked())
            curMark++;
        if(radioButton5.isChecked())
            curMark++;
        if(radioButton6.isChecked())
            curMark++;
        if(radioButton7.isChecked())
            curMark++;
        if(radioButton8.isChecked())
            curMark++;
        if(radioButton9.isChecked())
            curMark++;
        if(radioButton10.isChecked())
            curMark++;

        String str = Integer.toString(curMark);
        //Toast.makeText(this,"Obtained Mark: "+str,Toast.LENGTH_SHORT).show();

        reference.child(usrId).child("quiz_marks").setValue(str);
        quiz_marks=str;

        EditText curmarkEditText,prevMarkEditText;
        TextView congratulationTextView,tryAgainTextView;
        Button OkButton;

        curmarkEditText =(EditText) myDialog.findViewById(R.id.currentMarkId);
        prevMarkEditText =(EditText) myDialog.findViewById(R.id.previousMarkId);

        congratulationTextView= myDialog.findViewById(R.id.congratulationTextId);
        tryAgainTextView= myDialog.findViewById(R.id.congratulationTextId);
        OkButton = myDialog.findViewById(R.id.OkButtonId);

        curmarkEditText.setText(str);
        prevMarkEditText.setText(prevMark);

        myDialog.setContentView(R.layout.activity_popup_quiz);

        if(str.compareTo(prevMark)>0)
        {
            tryAgainTextView.setVisibility(View.GONE);
        }
        if(str.compareTo(prevMark)<0)
        {
            congratulationTextView.setVisibility(View.GONE);
        }

        OkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
                Intent intt = new Intent(Quiz.this,dashboard.class);
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
        });
        myDialog.show();
    }
}
