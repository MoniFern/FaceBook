package com.example.myfb.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class Mydatabase extends SQLiteOpenHelper { //create db

    // Database Name and Version
    public static final String DB_NAME = "myface.db";
    public static final int DB_VERSION=1;
    public static final String TABLE_NAME="student_table";
    public static final String COL_1="name";
    public static final String COL_2="age";
    public static final String COL_3="marks";






    public Mydatabase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, null, 1);
        //SQLiteDatabase db= this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {  //tables create krnwa me method eka atule
        Log.d(TAG ,"onCreate: " + " Database Create Successfully ");
        db.execSQL("create table "+TABLE_NAME+"(id integer primary key autoincrement,name TEXT,age integer,marks integer)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG ,"onCreate: " + " Database Update Successfully ");
        db.execSQL("DROP TABLE IF EXISTS "+DB_NAME);
        onCreate(db);
    }

    public boolean insertData(String name,String age,String mark){
        SQLiteDatabase db= this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1,name);
        contentValues.put(COL_2,age);
        contentValues.put(COL_3,mark);

        long rs = db.insert(TABLE_NAME,null,contentValues);

        if (rs==-1)
            return false;
        else
            return true;
    }


}
