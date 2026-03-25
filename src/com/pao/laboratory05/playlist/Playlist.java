package com.pao.laboratory05.playlist;

import java.util.Arrays;

public class Playlist {
    private String name;
    private Song[] songs = new Song[0];

    public Playlist(String name){
        this.name = name;
    }

    public String getName(){return this.name;}
    public Song[] getSongs(){return this.songs.clone();}
    
    public void addSong(Song song){
        System.arraycopy(songs, 0, songs = new Song[songs.length + 1], 0, songs.length - 1);
        songs[songs.length - 1] = song;
    }

    public void printSortedByTitle(){
        Song[] copy = this.songs.clone();
        Arrays.sort(copy);
        for (Song song : copy) {
            System.out.println(song);
        }
    }

    public void printSortedByDuration(){
        Song[] copy = this.songs.clone();
        Arrays.sort(copy, new SongDurationComparator());
        for (Song song : copy) {
            System.out.println(song);
        }
    }

    public int getTotalDuration(){
        int sum = 0;
        for (Song song : this.songs.clone()) {
            sum += song.durationSeconds();
        }
        return sum;
    }
}
