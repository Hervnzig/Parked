package com.example.parkedapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ClientsDatabase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="parked_database.db";
    public static final String TABLE_NAME="client_table";
    public static final String COL1="ID";
    public static final String COL2="PHONE_NUMBER";
    public static final String COL3="FULL_NAME";
    public static final String COL4="NATIONAL_ID";
    public static final String COL5="EMAIL";
    public static final String COL6="PASSWORD";

    public ClientsDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public ClientsDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("  create table "+TABLE_NAME+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT,PHONE_NUMBER TEXT,FULL_NAME TEXT,NATIONAL_ID TEXT," +
                "EMAIL TEXT, PASSWORD TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
    public long clientRegistration(String phone_number,String full_name, String national_id, String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(COL2,phone_number);
        contentValues.put(COL3,full_name);
        contentValues.put(COL4,national_id);
        contentValues.put(COL5,email);
        contentValues.put(COL6,password);

        long result = db.insert(TABLE_NAME,null,contentValues);
        if (result==-1){
            return  -1;
        }
        else {
            return result;
        }
    }

    public Cursor getProfile(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+ TABLE_NAME + " where "+COL1+" = "+id,null);
        return res;
    }

    public Cursor login(String phonenumber, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+ TABLE_NAME + " where "+COL2+" LIKE '%"+phonenumber+
                "%' AND "+COL6+" = "+password+ " LIMIT 1",null);
        return res;
    }

    public boolean updatedata(String id, String name , String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(COL1,id);
        contentValues.put(COL2,name);
        contentValues.put(COL3,email);
        contentValues.put(COL4,password);
        db.update(TABLE_NAME,contentValues,"ID = ?",new String[] {id});
        return true;

    }
    public Integer deletedata(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,"ID = ?",new String[]{id});

    }
}
