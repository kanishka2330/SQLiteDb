package com.example.localdatabase;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class MySqliteHelper extends SQLiteOpenHelper {

    public String dbPath = "/data/data/com.example.localdatabase/databases/";
    public static String dbName = "student.db";
    Context cont;
    SQLiteDatabase db;

    MySqliteHelper(Context cont){
        super(cont, dbName, null, 1);
        this.cont = cont;
    }

    void checkDatabase() {
        String myPath = dbPath + dbName;
        try {
            db = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        } catch (Exception e) {
            Toast.makeText(cont.getApplicationContext(), "Database doesn't exist", Toast.LENGTH_LONG).show();
        }

        if (db == null) {
            this.getReadableDatabase();
            this.close();

            try{

                InputStream is = cont.getAssets().open(dbName);
                OutputStream os = new FileOutputStream(myPath);

                byte b[] = new byte[1024];
                int length;

                while((length=is.read(b))>0){
                    os.write(b,0,length);
                }
                is.close();
                os.close();

                Toast.makeText(cont.getApplicationContext(), "Database successfully created!!", Toast.LENGTH_LONG).show();

            }
            catch(Exception e){
                Toast.makeText(cont.getApplicationContext(), "Copy Error", Toast.LENGTH_LONG).show();
            }


        } else {
            Toast.makeText(cont.getApplicationContext(), "Database already exists", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
