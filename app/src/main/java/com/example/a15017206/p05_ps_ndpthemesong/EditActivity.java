package com.example.a15017206.p05_ps_ndpthemesong;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity {

    Song song;

    EditText editSong, editSingerName, editYearRelease;
    RadioGroup rg;
    Button btnUpdate, btnDelete, btnCancel;
    RadioButton radioButton1, radioButton2, radioButton3, radioButton4, radioButton5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        editSong = (EditText) findViewById(R.id.editSongTitle);
        editYearRelease = (EditText) findViewById(R.id.editYearRelease);
        editSingerName = (EditText) findViewById(R.id.editSingerName);
        rg = (RadioGroup) findViewById(R.id.rg);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);

        radioButton1 = (RadioButton) findViewById(R.id.radioButton);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton) findViewById(R.id.radioButton3);
        radioButton4 = (RadioButton) findViewById(R.id.radioButton4);
        radioButton5 = (RadioButton) findViewById(R.id.radioButton5);

        Intent j = getIntent();
        int year = j.getIntExtra("year", 0);
        String songTitle = j.getStringExtra("songTitle");
        String singer = j.getStringExtra("singer");
        int rating = j.getIntExtra("rating", 0);
        final int id = j.getIntExtra("id", 0);

        editSingerName.setText(singer);
        editSong.setText(songTitle);
        editYearRelease.setText(year + "");

        if (rating == 0) {
        } else if (rating == 1) {
            radioButton1.setChecked(true);
        } else if (rating == 2) {
            radioButton2.setChecked(true);
        } else if (rating == 3) {
            radioButton3.setChecked(true);
        } else if (rating == 4) {
            radioButton4.setChecked(true);
        } else if (rating == 5) {
            radioButton5.setChecked(true);
        }

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(EditActivity.this);
                Toast.makeText(EditActivity.this, id+"", Toast.LENGTH_SHORT).show();
                dbh.deleteNote(id);
                dbh.close();
                finish();

            }
        });
    }
}
