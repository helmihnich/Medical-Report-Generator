package com.example.mrg;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;


public class PatientDbHelper extends SQLiteOpenHelper {
    public long addPatient(String name, int age, String address) {
        SQLiteDatabase db = getWritableDatabase(); // Use getWritableDatabase to get a writable database

        ContentValues values = new ContentValues();
        values.put(PatientContract.PatientEntry.COLUMN_NAME_NAME, name);
        values.put(PatientContract.PatientEntry.COLUMN_NAME_AGE, age);
        values.put(PatientContract.PatientEntry.COLUMN_NAME_ADDRESS, address);

        return db.insert(PatientContract.PatientEntry.TABLE_NAME, null, values);
    }

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Patients.db";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + PatientContract.PatientEntry.TABLE_NAME + " (" +
                    PatientContract.PatientEntry._ID + " INTEGER PRIMARY KEY," +
                    PatientContract.PatientEntry.COLUMN_NAME_NAME + " TEXT," +
                    PatientContract.PatientEntry.COLUMN_NAME_AGE + " INTEGER," +
                    PatientContract.PatientEntry.COLUMN_NAME_ADDRESS + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + PatientContract.PatientEntry.TABLE_NAME;

    public PatientDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }



}
