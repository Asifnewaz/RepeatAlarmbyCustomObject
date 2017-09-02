package com.asifnewaz.alarmwithcustomobjectdb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 2/28/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";

    private static final String TABLE_NAME = "Alarm_Log";
    private static final String KEY_ID="id";
    private static final String KEY_NAME="text";
    private static final String KEY_TIME="time";


    public DatabaseHelper(Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable ="CREATE TABLE "+TABLE_NAME +"(" + KEY_ID +" INTEGER PRIMARY KEY, "+ KEY_NAME +" TEXT, "+ KEY_TIME+" TEXT )";
        // Table Create
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public void addData(AlarmLog alarmLog) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_NAME, alarmLog.getText() );
        contentValues.put(KEY_TIME, alarmLog.getTime() );
        db.insert(TABLE_NAME, null, contentValues); //passing data
        db.close(); // Closing database connection
    }

    // code to get all contacts in a list view
    public List<AlarmLog> getData() {
        List<AlarmLog> data = new ArrayList<AlarmLog>();
        // Select All Query
        String selectQuery = "Select * From " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()){
            do {
                AlarmLog alarmLog = new AlarmLog();
                alarmLog.setID(Integer.parseInt(cursor.getString(0)));
                alarmLog.setText(cursor.getString(1));
                alarmLog.setTime(cursor.getString(2));
                data.add(alarmLog);
            }while (cursor.moveToNext());
        }

        return data;
    }

}
























