package com.example.a15017206.p05_ps_ndpthemesong;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editSong, editSingerName, editYearRelease;
    RadioGroup rg;
    Button btnInsert, btnShowList;
    TextView debugText;

    int starChosenNumber = 0;

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
        debugText = (TextView) findViewById(R.id.debugText);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (checkedId == R.id.radioButton) {
                    starChosenNumber = 5;
                } else if (checkedId == R.id.radioButton2) {
                    starChosenNumber = 4;
                } else if (checkedId == R.id.radioButton3) {
                    starChosenNumber = 3;
                } else if (checkedId == R.id.radioButton4) {
                    starChosenNumber = 2;
                } else if (checkedId == R.id.radioButton5) {
                    starChosenNumber = 1;
                }
                debugText.setText(starChosenNumber + "");
            }
        });

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String songTitle = editSong.getText().toString();
                String songSinger = editSingerName.getText().toString();
                int songYear = Integer.parseInt(editYearRelease.getText().toString());
                int noOfStars = starChosenNumber;

                DBHelper dbh = new DBHelper(MainActivity.this);
                debugText.setText(songTitle + songSinger + songYear + noOfStars + "");
                long row_affected = dbh.insertSong(songTitle, songSinger, songYear, noOfStars);
                dbh.close();

                if (row_affected != -1) {
                    Toast.makeText(MainActivity.this, "Insert successful",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ViewActivity.class);
                startActivity(i);
            }
        });

    }
}
