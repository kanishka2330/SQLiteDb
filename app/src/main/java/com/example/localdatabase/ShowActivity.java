package com.example.localdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ShowActivity extends Activity
{
    ListView lv;
    public static String dbName="student.db";
    public String dbPath="/data/data/com.example.localdatabase/databases/";
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        lv = findViewById(R.id.lv);

        String myPath = dbPath+dbName;

        try
        {
            db = SQLiteDatabase.openDatabase(myPath,null,SQLiteDatabase.OPEN_READONLY);
        }
        catch(Exception e)
        {
            Toast.makeText(getApplicationContext(),""+e.getMessage(),Toast.LENGTH_LONG).show();
        }

        Cursor cur=db.rawQuery("select * from mytab",null);

        Toast.makeText(getApplicationContext(),"rows : "+cur.getColumnCount(),Toast.LENGTH_LONG).show();
        int i=0;
        String data[]=new String[cur.getCount()];

        while(cur.moveToNext())
        {
            @SuppressLint("Range") int a=cur.getInt(cur.getColumnIndex("sid"));
            @SuppressLint("Range") String b=cur.getString(cur.getColumnIndex("sna"));
            @SuppressLint("Range") int c=cur.getInt(cur.getColumnIndex("sag"));

            data[i]=" " +a+ " | " +b+ " , " +c;
            i++;
        }

        db.close();
        ArrayAdapter<String> ad=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
        lv.setAdapter(ad);




    }
}