package com.example.a15017206.p05_ps_ndpthemesong;

/**
 * Created by 14049561 on 18/5/2017.
 */

public class Song {
    private String songTitle;
    private String singer;
    private int year;
    private int NoOfStars;

    public Song(String songTitle, String singer, int year, int noOfStars) {
        this.songTitle = songTitle;
        this.singer = singer;
        this.year = year;
        this.NoOfStars = noOfStars;
    }

    public String getSongTitle(){
        return songTitle;
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
