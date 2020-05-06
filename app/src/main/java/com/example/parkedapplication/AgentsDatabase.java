package com.example.parkedapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AgentsDatabase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="parked_database_agent.db";
    public static final String TABLE_NAME="agent_table";
    public static final String COL1="ID";
    public static final String COL2="PHONE_NUMBER";
    public static final String COL3="FULL_NAME";
    public static final String COL4="NATIONAL_ID";
    public static final String COL5="EMAIL";
    public static final String COL6="PASSWORD";

    public AgentsDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public AgentsDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("  create table "+TABLE_NAME+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT,PHONE_NUMBER TEXT,FULL_NAME TEXT,NATIONAL_ID TEXT," +
                "EMAIL TEXT, PASSWORD TEXT)");


        // ADD AGENTS BY DEFAULT
        // Agent 1
        ContentValues contentValues= new ContentValues();
        contentValues.put(COL2, "0780348088");
        contentValues.put(COL3, "Yves Mugenga");
        contentValues.put(COL4, "123456789");
        contentValues.put(COL5, "ymugenga@gmail.com");
        contentValues.put(COL6, "password");

        // Agent 2
        ContentValues contentValues2= new ContentValues();
        contentValues2.put(COL2, "0787502423");
        contentValues2.put(COL3, "Pax Mfura");
        contentValues2.put(COL4, "546373829397");
        contentValues2.put(COL5, "pax@gmail.com");
        contentValues2.put(COL6, "password");

        // Agent 3
        ContentValues contentValues3= new ContentValues();
        contentValues3.put(COL2, "0783273388");
        contentValues3.put(COL3, "Iyamarere Ivan");
        contentValues3.put(COL4, "123456789");
        contentValues3.put(COL5, "ivan@gmail.com");
        contentValues3.put(COL6, "password");

        // Agent 4
        ContentValues contentValues4= new ContentValues();
        contentValues4.put(COL2, "0787947290");
        contentValues4.put(COL3, "Herve Musangwa");
        contentValues4.put(COL4, "123456789");
        contentValues4.put(COL5, "herve@gmail.com");
        contentValues4.put(COL6, "password");

        db.insert(TABLE_NAME,null,contentValues);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

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
