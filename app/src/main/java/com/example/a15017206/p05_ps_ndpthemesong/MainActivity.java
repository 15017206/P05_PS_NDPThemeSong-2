package com.example.a15017206.p05_ps_ndpthemesong;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText editSong, editSingerName, editYearRelease;
    RadioGroup rg;
    Button btnInsert, btnShowList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editSong = (EditText) findViewById(R.id.editSong);
        editSingerName = (EditText) findViewById(R.id.editSingerName);
        editYearRelease = (EditText) findViewById(R.id.editYearRelease);
        rg = (RadioGroup) findViewById(R.id.rg);
        btnInsert = (Button) findViewById(R.id.btnInsert);
        btnShowList = (Button) findViewById(R.id.btnShowList);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String songTitle = editSong.getText().toString() ;
                String songSinger = editSingerName.getText().toString();
                String songYear = editYearRelease.getText().toString();

DBHelper dbh = new DBHelper(MainActivity.this);

            }
        });

    }
}
