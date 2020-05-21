package com.example.praktikum;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "biodatadiri.db";
    private static final int DATABASE_VERSION = 1;
    public DataHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate (SQLiteDatabase db){
        String sql = "create table biodata(npm integer primary key, nama text null, tgl text null, jk text null, alamat text null);";
        Log.d("Data", "onCreate : " + sql);
        db.execSQL(sql);
        sql = "INSERT INTO biodata (npm, nama, tgl, jk, alamat) VALUES ('180403010003', 'Dina', '1998-10-10', 'p', 'Banjarmasin');";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

    }
}
