package com.pao.laboratory05.playlist;

import java.util.Comparator;

public class SongDurationComparator implements Comparator<Song> {
    // compare: sortare după durationSeconds crescător
    @Override public int compare(Song x, Song y){
        if(x.durationSeconds() < y.durationSeconds()){
            return -1;
        }
        if(x.durationSeconds()>y.durationSeconds()){
            return 1;
        }
        return 0;
    }
}