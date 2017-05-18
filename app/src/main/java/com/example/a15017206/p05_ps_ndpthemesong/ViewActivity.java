package com.example.a15017206.p05_ps_ndpthemesong;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ViewActivity extends AppCompatActivity {

    SongAdapter aa;
    ListView lv;
    ArrayList<Song> songs = new ArrayList<Song>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        lv = (ListView) findViewById(R.id.lv);
        songs = new ArrayList<Song>();
        aa = new SongAdapter(this, R.layout.row, songs);



    }
}
