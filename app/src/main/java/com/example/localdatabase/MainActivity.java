package com.example.localdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button show, insert, delete, update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        show = (Button) findViewById(R.id.bsh);
        insert = (Button) findViewById(R.id.bin);
        delete = (Button) findViewById(R.id.bdel);
        update= (Button) findViewById(R.id.bup);

        MySqliteHelper ms = new MySqliteHelper(getApplicationContext());
        ms.checkDatabase();

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ii = new Intent(getApplicationContext(),ShowActivity.class);
                startActivity(ii);
            }
        });
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ii = new Intent(getApplicationContext(),InsertActivity.class);
                startActivity(ii);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ii = new Intent(getApplicationContext(),DeleteActivity.class);
                startActivity(ii);
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ii = new Intent(getApplicationContext(),UpdateActivity.class);
                startActivity(ii);
            }
        });
        }
}