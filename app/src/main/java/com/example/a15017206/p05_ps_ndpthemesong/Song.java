package com.example.a15017206.p05_ps_ndpthemesong;

/**
 * Created by 14049561 on 18/5/2017.
 */

public class Song {
    private int id;
    private String songTitle;
    private String singer;
    private int year;
    private int NoOfStars;

    public Song(int id, String songTitle, String singer, int year, int noOfStars) {
        this.id = id;
        this.songTitle = songTitle;
        this.singer = singer;
        this.year = year;
        this.NoOfStars = noOfStars;
    }

    public String getSongTitle(){
        return songTitle;
    }

    public int getId(){
        return id;
    }

    public String getSinger() {
        return singer;
    }

    public int getYear() {
        return year;
    }

    public int getNoOfStars() {
        return NoOfStars;
    }
}
