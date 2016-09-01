package com.miguelcr.a02_mediaplayer;

/**
 * Created by miguelcampos on 1/9/16.
 */
public class SongItem {
    private String cover;
    private String title;
    private String artist;

    public SongItem(String cover, String title, String artist) {
        this.cover = cover;
        this.title = title;
        this.artist = artist;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
