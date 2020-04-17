package com.company;

public class Song {
    private String title;
    private String time;

    public Song(String title, String time) {
        this.title = title;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return this.title + " - " + this.time;
    }
}
