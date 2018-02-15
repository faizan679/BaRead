package com.example.a1605126.baread;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "inventory.db";
    public static final String TABLE_NAME = "Data Content";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "CONTENT";//for barcode number
    public static final String COL_3 = "NAME";
    public static final String COL_4 = "PRICE";

   public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL( "create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,CONTENT INTEGER,NAME TEXT,PRICE INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }

    void insertData(String content, String name, String price)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,content);
        contentValues.put(COL_3,name);
        contentValues.put(COL_4,price);
       db.insert(TABLE_NAME,null ,contentValues);

    }
}
