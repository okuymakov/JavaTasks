package ru.kuymakov.songs;

import java.util.Arrays;
import java.util.Objects;

public class Song {

    String name;
    String[] authors;
    Album album;

    public Song(String name, String... authors) {
        this.name = name;
        this.authors = authors;
    }

    Song(String name, Album album, String... authors) {
        this(name, authors);
        this.album = album;
    }

    public Album getAlbum() {
        return album;
    }

    public String getName() {
        return name;
    }

    public String[] getAuthors() {
        return Arrays.copyOf(authors, authors.length);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.name);
        hash = 71 * hash + Arrays.deepHashCode(this.authors);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Song other = (Song) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Arrays.deepEquals(this.authors, other.authors)) {
            return false;
        }
        return true;
    }
    
    
    
    @Override
    public String toString() {
        String auth = "";
        if (authors.length == 1) {
            auth = ", автор: " + authors[0];
        } else if (authors.length > 1) {
            auth = ", авторы: ";
            auth += String.join(",", authors);
        }
        return name + auth;
    }
}
