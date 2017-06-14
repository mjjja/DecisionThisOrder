package com.example.kmj.decisionthisorder;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class ManageDB {
    private static DB database = null;
    private static SQLiteDatabase SQLdatabase = null;
    private static ManageDB mInstance = null;

    public final static ManageDB getmInstance(Context context) {
        if (mInstance == null) {
            mInstance = new ManageDB(context);
        }
        return mInstance;
    }

    ManageDB(Context context){
        database = new DB(context, "SQLdatabase", null, 1);
        SQLdatabase = database.getWritableDatabase();
    }



    public Cursor execSELECTRestaurants(String sql){
        Cursor cursor = SQLdatabase.rawQuery(sql,null);
        return cursor;
    }

    public void execRestaurants(String sql){
        SQLdatabase.execSQL(sql);
    }
}