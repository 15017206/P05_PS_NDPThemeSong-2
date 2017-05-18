package com.example.a15017206.p05_ps_ndpthemesong;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class EditActivity extends AppCompatActivity {

    EditText editSong, editSingerName, editYearRelease;
    RadioGroup rg;
    Button btnInsert, btnShowList, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        Intent j = getIntent();
        String year = j.getStringExtra("year");
        String songTitle = j.getStringExtra("songTitle");
        String singer = j.getStringExtra("singer");
        String rating = j.getStringExtra("rating");

        editSingerName.setText(singer);
        editSong.setText(songTitle);
        editYearRelease.setText(year);



    }
}
