package com.example.a15017206.p05_ps_ndpthemesong;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ViewActivity extends AppCompatActivity {

    SongAdapter aa;
    ListView lv;
    ArrayList<Song> songs = new ArrayList<Song>();
    Button btnShowAllSongs;
    TextView tvDebug;
    Song song;
    SongAdapter sa;

    DBHelper dbh = new DBHelper(ViewActivity.this);

    @Override
    protected void onResume() {
        super.onResume();

        //clear the arraylist songs
        songs.clear();

        // reload the arraylist from db
        songs.addAll(dbh.getAllSongs());

        aa.notifyDataSetChanged();
        lv.setAdapter(aa);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        DBHelper db = new DBHelper(this);

        lv = (ListView) findViewById(R.id.lv);
        btnShowAllSongs = (Button) findViewById(R.id.btnShowAllSongs);
        tvDebug = (TextView) findViewById(R.id.debug) ;
        songs = new ArrayList<Song>();
        aa = new SongAdapter(this, R.layout.row, songs);
        lv.setAdapter(aa);

        songs.addAll(db.getAllSongs());

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song selectedSong = songs.get(position);

                Intent i = new Intent(ViewActivity.this, EditActivity.class);
                i.putExtra("id", selectedSong.getId());
                i.putExtra("year", selectedSong.getYear());
                i.putExtra("songTitle", selectedSong.getSongTitle());
                i.putExtra("singer", selectedSong.getSinger());
                i.putExtra("rating", selectedSong.getNoOfStars());

                startActivity(i);
            }
        });

        btnShowAllSongs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Song> fs = new ArrayList<Song>();
                fs = new ArrayList<Song>();
fs = dbh.getAllSongs("5");
                aa = new SongAdapter(ViewActivity.this, R.layout.row, fs) ;
                lv.setAdapter(aa);
                aa.notifyDataSetChanged();
            }
        });


    }
}
