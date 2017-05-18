package com.example.a15017206.p05_ps_ndpthemesong;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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

        DBHelper db = new DBHelper(this);

        lv = (ListView) findViewById(R.id.lv);
        songs = new ArrayList<Song>();
        aa = new SongAdapter(this, R.layout.row, songs);
        lv.setAdapter(aa);

        songs.addAll(db.getAllSongs());

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song selectedSong = songs.get(position);

                Toast.makeText(ViewActivity.this, selectedSong.getSongTitle(), Toast.LENGTH_SHORT).show();

                Intent i = new Intent(ViewActivity.this, EditActivity.class);
                i.putExtra("year",selectedSong.getYear());
                i.putExtra("songTitle",selectedSong.getSongTitle());
                i.putExtra("singer",selectedSong.getSinger());
                i.putExtra("rating", selectedSong.getNoOfStars());

                startActivity(i);
            }
        });
    }
}
