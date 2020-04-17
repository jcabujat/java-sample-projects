package com.company;

import java.util.Iterator;
import java.util.LinkedList;

public class Playlist {
    private String playList;
    private LinkedList<Song> songs;

    public Playlist(String name) {
        this.playList = name;
        this.songs = new LinkedList<>();
    }

    public String getPlayList() {
        return playList;
    }

    public LinkedList<Song> getSongs() {
        return this.songs;
    }

    public void add(Album album) {
        LinkedList<Song> albumSongs = album.getSongs();
        for (Song songFromAlbum : albumSongs) {
            if (!songOnList(songFromAlbum)) {
                this.songs.add(songFromAlbum);
                System.out.println(songFromAlbum.toString() + " added to " + this.playList);
            } else {
                System.out.println(songFromAlbum.toString() + " already on " + this.playList);
            }
        }
    }

    private boolean songOnList(Song song) {
        Iterator<Song> songList = songs.iterator();
        boolean alreadyStored = false;
        while (songList.hasNext()) {
            Song songNext = songList.next();
            if (songNext.getTitle().equals(song.getTitle())) {
                alreadyStored = true;
                break;
            }
        }
        return alreadyStored;
    }

}
