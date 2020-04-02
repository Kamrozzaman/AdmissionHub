package com.example.admissionhub;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "UserInfo.db";
    private static final String TABLE_NAME = "UserDetails";
    private static final String fullname = "FullName";
    private static final String username = "UserName";
    private static final String password = "Password";
    private static final String phone = "Phone";
    private static final String group = "Grp";
    private static final String sscgpa = "SscGpa";
    private static final String hscgpa = "HscGpa";
    private static final int VERSION_NUM = 1;
    private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"( "+fullname+" VARCHAR(255) NOT NULL ,"+username+" VARCHAR(255) NOT NULL,"+password+" VARCHAR(255) NOT NULL,"+phone+" VARCHAR(255) NOT NULL,"+group+" VARCHAR(255) NOT NULL,"+sscgpa+" VARCHAR(255) NOT NULL,"+hscgpa+" VARCHAR(255) NOT NULL);";
    private Context context;
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS "+TABLE_NAME;
    public Database(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUM);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try{
            db.execSQL(CREATE_TABLE);
        }catch (Exception e){
            Toast.makeText(context, "Exception: "+e, Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        try{
            db.execSQL(DROP_TABLE);
            onCreate(db);
        }catch (Exception e){
            Toast.makeText(context, "Exception: "+e, Toast.LENGTH_SHORT).show();
        }

    }

    public void insertData(UserDetails userdetails){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentvalues =  new ContentValues();
        contentvalues.put(fullname,userdetails.getFllname());
        contentvalues.put(username,userdetails.getUsrname());
        contentvalues.put(password,userdetails.getPssword());
        contentvalues.put(phone,userdetails.getPhn());
        contentvalues.put(group,userdetails.getGrp());
        contentvalues.put(sscgpa,userdetails.getSsgpa());
        contentvalues.put(hscgpa,userdetails.getHsgpa());

        db.insert(TABLE_NAME,null,contentvalues);

    }
}
