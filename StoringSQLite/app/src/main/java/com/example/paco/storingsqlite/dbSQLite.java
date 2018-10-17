package com.example.paco.storingsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class dbSQLite extends SQLiteOpenHelper {

    public dbSQLite(Context context, String name, CursorFactory factory, int version){
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE voters (" +
                "dni INTEGER PRIMARY KEY," +
                "name TEXT," +
                "college TEXT," +
                "tableNum INTEGER" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS voters");
        db.execSQL("CREATE TABLE voters (" +
                "dni INTEGER PRIMARY KEY," +
                "name TEXT," +
                "college TEXT," +
                "tableNum INTEGER" +
                ")");
    }
}
