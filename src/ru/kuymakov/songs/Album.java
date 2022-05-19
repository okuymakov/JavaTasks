package ru.kuymakov.songs;

import java.util.ArrayList;
import java.util.List;

public class Album {

    String name;
    String author;
    List<Song> songs;

    public Album(String name, String author, Song... songs) {
        this.name = name;
        this.author = author;
        this.songs = new ArrayList<>();
        for (Song song : songs) {
            addSong(song);
        }   
    }

    public void addSong(Song song) {
        if (song.album != null) {
            throw new IllegalArgumentException(song + " уже включена в другой альбом");
        }
        if(songs.contains(song)) {
            throw new IllegalArgumentException(song + " уже включена в этот альбом");
        }
        song.album = this;
        songs.add(song);
    }

    public List<Song> getSongs() {
        return new ArrayList<>(songs); 
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }
}
