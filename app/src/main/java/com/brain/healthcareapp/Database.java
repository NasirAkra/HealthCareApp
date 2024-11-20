package com.brain.healthcareapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qry1 = "CREATE TABLE users(username TEXT, email TEXT, password TEXT)";
        db.execSQL(qry1); // Use 'db' here instead of 'sqLiteDatabase'
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Code to handle database upgrades, such as altering tables or migrating data.
    }
    public void register(String username,String email,String password )
    {
        ContentValues cv=new ContentValues();
        cv.put("Username",username);
        cv.put("Email",email);
        cv.put("Password",password);
        SQLiteDatabase db=getWritableDatabase();
        db.insert("users",null,cv);
        db.close();

    }
    public int login(String username,String password)
    {
   int result=0;
   String str[]=new String[2];
   str[0]=username;
   str[1]=password;
   SQLiteDatabase db= getReadableDatabase();
        Cursor c =db.rawQuery("select * from users where username=? and password=?",str);
        if (c.moveToFirst())
        {
            result=1;
        }
   return result;
    }
}
