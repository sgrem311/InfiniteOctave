package com.octavesix.infiniteoctave;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Accounts.db";
    public static final String TABLE_NAME = "account_table";
    public static final String FIRST = "FIRST";
    public static final String LAST = "LAST";
    public static final String USERNAME = "USERNAME";
    public static final String PASSWORD = "PASSWORD";
    public static final String EMAIL = "EMAIL";
    public static final String PHONE = "PHONE";
    public static final String COUNTRY = "COUNTRY";
    public static final String CITY = "CITY";
    public static final String STATE = "STATE";
    public static final String GENDER = "GENDER";
    public static final String BIRTHDAY = "BIRTHDAY";

    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME,null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (FIRST TEXT PRIMARY KEY, LAST TEXT, USERNAME TEXT, PASSWORD TEXT, EMAIL TEXT, COUNTRY TEXT, STATE TEXT, CITY TEXT, GENDER TEXT, PHONE INTEGER, BIRTHDAY INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData (String first, String last, String username, String password, String email, String country, String city, String state, String gender, String phone, String birthday){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(FIRST, first);
        contentValues.put(LAST, last);
        contentValues.put(USERNAME, username);
        contentValues.put(PASSWORD, password);
        contentValues.put(EMAIL, email);
        contentValues.put(COUNTRY, country);
        contentValues.put(STATE, state);
        contentValues.put(CITY, city);
        contentValues.put(PHONE, phone);
        contentValues.put(GENDER, gender);
        contentValues.put(BIRTHDAY, birthday);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1)
            return false;
        else return true;
    }
    public Boolean checkUsername(String username){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from " +TABLE_NAME + " where username=?", new String[] {username});

        if(cursor.getCount() > 0) return false;
        else return true;
    }
    public Boolean usernamePassword(String username, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from " + TABLE_NAME + " where username=? and password=?",new String[]{username, password});
        if(cursor.getCount() > 0) return true;
        else return false;
    }
}
