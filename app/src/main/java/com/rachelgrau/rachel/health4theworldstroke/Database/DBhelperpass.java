package com.rachelgrau.rachel.health4theworldstroke.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Anjali on 29-Mar-17.
 */

public class DBhelperpass extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="password.db";
    private static final int DATABASE_VERSION = 4;
    private static final String TABLE_NAME="password_table";
    public static final String ID="id";
    public static final String PASSWORD="password";

   public DBhelperpass(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE" + TABLE_NAME + "(" +
                ID + " INTEGER PRIMARY KEY, " +
                PASSWORD + "TEXT)" ;
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS"+ TABLE_NAME);
            onCreate(db);
    }
    public boolean insertData(String pass)
    {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(PASSWORD,pass);
        long result=db.insert(TABLE_NAME,null,contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }

}