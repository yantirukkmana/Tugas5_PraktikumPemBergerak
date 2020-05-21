package com.example.praktikum;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BuatBiodata extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button btn1, btn2;
    EditText text1, text2, text3, text4, text5;

    public static Intent getActIntent(Activity activity) {
        return new Intent(activity, BuatBiodata.class);
    }

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buat_biodata);

        dbHelper = new DataHelper(this);
        text1    = (EditText) findViewById(R.id.text1);
        text2    = (EditText) findViewById(R.id.text2);
        text3    = (EditText) findViewById(R.id.text3);
        text4    = (EditText) findViewById(R.id.text4);
        text5    = (EditText) findViewById(R.id.text5);
        btn1     = (Button) findViewById(R.id.btn1);
        btn2     = (Button) findViewById(R.id.btn2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("INSERT into biodata(npm, nama, tgl, jk, alamat) values ('" +
                        text1.getText().toString() + "','" +
                        text2.getText().toString() + "','" +
                        text3.getText().toString() + "','" +
                        text4.getText().toString() + "','" +
                        text5.getText().toString() + "')");
                Toast.makeText(getApplicationContext(),"Data Berhasil Ditambahkan ", Toast.LENGTH_LONG).show();
                MainActivity.ma.RefreshList();
                finish();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                finish();
            }
        });
    }
}
