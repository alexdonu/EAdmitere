package com.example.eadmitere;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBConnector extends SQLiteOpenHelper {

    public DBConnector(Context contex){
        super(contex,"usm.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createuserTable="CREATE TABLE USERS (ID INTEGER PRIMARY KEY AUTOINCREMENT, EMAIL TEXT, NUME TEXT, PRENUME TEXT,MEDIASC TEXT, MEDIABAC TEXT)";

        sqLiteDatabase.execSQL(createuserTable);
    }

    public void addUser(User user){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues cv=new ContentValues();

        cv.put("EMAIL",user.getEmail());
        cv.put("NUME",user.getNume());
        cv.put("PRENUME",user.getPrenume());
        cv.put("MEDIASC",user.getMediaScolara());
        cv.put("MEDIABAC",user.getMediaBAC());

        db.insert("USERS",null,cv);
    }

    public List<User> getAllUsers(){
        List<User> result=new ArrayList<>();
        String query="SELECT * FROM USERS";
        SQLiteDatabase db=getReadableDatabase();

        Cursor cursor=db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do {
                int id=cursor.getInt(0);
                String email=cursor.getString(1);
                String nume=cursor.getString(2);
                String prenume=cursor.getString(3);
                String mediaSc=cursor.getString(4);
                String mediaBAC=cursor.getString(5);

                User newUser=new User(id,email,nume,prenume,mediaSc,mediaBAC);
                result.add(newUser);
            } while (cursor.moveToNext());
        }
        cursor.close();

        return result;


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
