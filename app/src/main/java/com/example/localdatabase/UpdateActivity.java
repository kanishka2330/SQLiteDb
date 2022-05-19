package com.example.localdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    EditText etid, etna, etag;
    Button btnupd, btncan;
    public String dbPath = "/data/data/com.example.localdatabase/databases/";
    public static String dbName = "student.db";

    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        etid = findViewById(R.id.etid);
        etna = findViewById(R.id.etna);
        etag = findViewById(R.id.etag);

        btnupd = findViewById(R.id.btnin);
        btncan = findViewById(R.id.btncan);

        btnupd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int vid = Integer.parseInt(etid.getText().toString());
                String vname = etna.getText().toString();
                int vag = Integer.parseInt(etag.getText().toString());

                String myPath = dbPath+dbName;

                try{
                    db = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
                }
                catch(Exception e){
                    Toast.makeText(getApplicationContext(), "Error"+ e.getMessage(), Toast.LENGTH_LONG).show();
                }
                db.execSQL("update mytab set sna='"+vname+"', sag="+vag+" where sid="+vid);

                db.close();
                Toast.makeText(getApplicationContext(), "Record Inserted", Toast.LENGTH_LONG).show();
            }

        });

        btncan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etid.setText("");
                etna.setText("");
                etag.setText("");
            }
        });
    }
}