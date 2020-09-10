package com.example.admissionhub;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class popup_quiz extends AppCompatActivity implements View.OnClickListener{

    String email,password,fllname,phn,grp,ssgpa,hsgpa,usrId;
    String austt,juu,iutt,buett,sustt,duu,quiz_marks;
    String prevMark;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_quiz);
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
        prevMark = getIntent().getStringExtra("PQUIZ");

        TextView curmarkEditText,prevMarkEditText;
        TextView congratulationTextView,tryAgainTextView;
        Button OkButton;

        curmarkEditText =findViewById(R.id.currentMarkId);
        prevMarkEditText =findViewById(R.id.previousMarkId);

        congratulationTextView= findViewById(R.id.congratulationTextId);
        tryAgainTextView= findViewById(R.id.improveTextId);
        OkButton = findViewById(R.id.OkButtonId);

        curmarkEditText.setText("  "+quiz_marks);
        prevMarkEditText.setText("  "+prevMark);

        if(quiz_marks.length()==2)
        {
            tryAgainTextView.setVisibility(View.GONE);
        }
        else if(quiz_marks.length()==1)
        {
            congratulationTextView.setVisibility(View.GONE);
        }
        OkButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        reference.child(usrId).child("quiz_marks").setValue(quiz_marks);

        Intent intt = new Intent(popup_quiz.this , dashboard.class);

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
