package com.example.weekboss.SQlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DaoSqlite {
    private SQLiteDatabase database;
    private static DaoSqlite daoSqlite;
    private DaoSqlite(Context context){
        Sqlite sqlite = new Sqlite(context);
         database = sqlite.getWritableDatabase();
    }
    public static DaoSqlite getDaoSqlite(Context context){
        if (daoSqlite==null){
            daoSqlite=new DaoSqlite(context);
        }
        return daoSqlite;
    }

    //添加
    public void add(String name){
        ContentValues values=new ContentValues();
        values.put("name",name);
        database.insert("week",null,values);
    }

    //查看
    public List<DaoBean> selecte(){
        List<DaoBean> strings=new ArrayList <>();
        Cursor query = database.query("week", null, null, null, null, null, null);
        if (query!=null){
            if (query.moveToNext()) {
                String str = query.getString(query.getColumnIndex("name"));
                DaoBean daoBean=new DaoBean(str);
                strings.add(daoBean);
            }
        }
        return strings;
    }
}
