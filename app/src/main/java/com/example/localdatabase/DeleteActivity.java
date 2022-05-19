package com.example.localdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity {

    EditText etid;
    Button btndel, btncan;

    public String dbPath = "/data/data/com.example.localdatabase/databases/";
    public static String dbName = "student.db";

    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        etid = findViewById(R.id.etid);
        btndel = findViewById(R.id.btndel);
        btncan = findViewById(R.id.btncan);

        btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int vid = Integer.parseInt(etid.getText().toString());

                String myPath = dbPath+dbName;

                try{
                    db = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
                }
                catch(Exception e){
                    Toast.makeText(getApplicationContext(), "Error"+ e.getMessage(), Toast.LENGTH_LONG).show();
                }
                db.execSQL("delete from mytab where sid="+vid);

                db.close();
                Toast.makeText(getApplicationContext(), "Record Deleted", Toast.LENGTH_LONG).show();
            }
        });

        btncan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etid.setText("");

            }
        });
    }
}