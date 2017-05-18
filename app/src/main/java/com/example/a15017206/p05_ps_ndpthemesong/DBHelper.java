package com.example.a15017206.p05_ps_ndpthemesong;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by 15017206 on 18/05/2017.
 */

public class DBHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "ndpThemeSong.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "ndp";

    //creating column names
    private static final String SONG_ID = "song_id";
    private static final String SONG_TITLE = "song_title";
    private static final String SINGER_NAME = "singer_name";
    private static final String YEAR_RELEASE = "year_released";
    private static final String NO_OF_STARS = "no_of_stars";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createNoteTableSql = "CREATE TABLE " + TABLE_NAME + "(" + SONG_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + SONG_TITLE + "TEXT" + SINGER_NAME + "TEXT" + YEAR_RELEASE +"TEXT" + NO_OF_STARS + " INTEGER ) ";
        db.execSQL(createNoteTableSql);
        Log.i("info", "created tables");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public long insertSong(String songTitle, String singerName, int yearReleased, int noOfStars) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(SONG_TITLE, songTitle);
        values.put(SINGER_NAME, singerName);
        values.put(YEAR_RELEASE, yearReleased);
        values.put(NO_OF_STARS, noOfStars);
        long result = db.insert(TABLE_NAME, null, values);

        if (result == -1) {
            Log.d("DBHelper", "Insert failed");
        }

        db.close();
        Log.d("SQL Insert", "" + result); //id returned, shouldn’t be -1
        return result;
    }
}
