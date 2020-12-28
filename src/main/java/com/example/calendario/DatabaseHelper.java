package com.example.calendario;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import java.sql.Array;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String TAG = "DatabaseHelper";
    public static final String DATABASE_NAME = "ToDoList";
    public static final String TABLE_NAME = "monday";
    public static final String TABLE_NAME2 = "tuesday";
    public static final String TABLE_NAME3 = "wednesday";
    public static final String TABLE_NAME4 = "thursday";
    public static final String TABLE_NAME5 = "friday";
    public static final String TABLE_NAME6 = "saturday";
    public static final String TABLE_NAME7 = "sunday";

    String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + COL2 + " TEXT)";
    String createTable2 = "CREATE TABLE " + TABLE_NAME2 + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + COL2 + " TEXT)";
    String createTable3 = "CREATE TABLE " + TABLE_NAME3 + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + COL2 + " TEXT)";
    String createTable4 = "CREATE TABLE " + TABLE_NAME4 + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + COL2 + " TEXT)";
    String createTable5 = "CREATE TABLE " + TABLE_NAME5 + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + COL2 + " TEXT)";
    String createTable6 = "CREATE TABLE " + TABLE_NAME6 + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + COL2 + " TEXT)";
    String createTable7 = "CREATE TABLE " + TABLE_NAME7 + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + COL2 + " TEXT)";


    public static final String COL1 = "ID";
    public static final String COL2 = "task";
    SQLiteDatabase db = this.getWritableDatabase();


    public DatabaseHelper(@Nullable Context context, String TABLE) {
        super(context, DATABASE_NAME, null, 1);
    }

    //creating the table
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTable);
        db.execSQL(createTable2);
        db.execSQL(createTable3);
        db.execSQL(createTable4);
        db.execSQL(createTable5);
        db.execSQL(createTable6);
        db.execSQL(createTable7);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME3);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME4);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME5);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME6);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME7);

        onCreate(db);
    }

    public boolean addData(String item, String TABLE) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, item);

        Log.d(TAG, "addData: Adding " + item + " to " + TABLE);

        long result = db.insert(TABLE, null, contentValues);

        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    //returns all the data from database
    public Cursor getData(String TABLE){

        String query = "SELECT * FROM " + TABLE;
        Cursor data = db.rawQuery(query, null);
        return data;

    }

    public void removeItem(String taskOnList, String TABLE){

        db.delete(TABLE, COL2 + "=?",
                new String[] { String.valueOf(taskOnList) }); // KEY_ID= id of row and third parameter is argument.
    }

}


