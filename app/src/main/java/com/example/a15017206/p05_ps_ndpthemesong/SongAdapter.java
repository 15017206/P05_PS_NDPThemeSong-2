package com.example.a15017206.p05_ps_ndpthemesong;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 15017206 on 18/05/2017.
 */

public class SongAdapter extends ArrayAdapter<Song>{

    ArrayList<Song> songs;
    Context context;
    int resource;

    TextView tvYear, tvSongTitle, tvSinger;
    ImageView iv1star, iv2star, iv3star, iv4star, iv5star;

    public SongAdapter(@NonNull Context context, @LayoutRes int resource, ArrayList<Song> objects) {
        super(context, resource, objects);
        songs = objects;
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, parent, false);

        //findViewById - from row.xml
        tvYear = (TextView) rowView.findViewById(R.id.tvYear);
        tvSinger = (TextView) rowView.findViewById(R.id.tvSinger);
        tvSongTitle = (TextView) rowView.findViewById(R.id.tvSongTitle);

        iv1star = (ImageView) rowView.findViewById(R.id.iv1star);
        iv2star = (ImageView) rowView.findViewById(R.id.iv2star);
        iv3star = (ImageView) rowView.findViewById(R.id.iv3star);
        iv4star = (ImageView) rowView.findViewById(R.id.iv4star);
        iv5star = (ImageView) rowView.findViewById(R.id.iv5star);

        Song currentSong = songs.get(position);






        return super.getView(position, convertView, parent);
    }
}
