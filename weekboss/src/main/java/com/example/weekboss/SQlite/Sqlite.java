package com.example.weekboss.SQlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class Sqlite extends SQLiteOpenHelper {
    public Sqlite( @Nullable Context context) {
        super(context, "Week.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table week(id integer primary key autoincrement," +
                    "name text )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
