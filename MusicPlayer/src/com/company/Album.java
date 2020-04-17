package com.company;

import java.util.Iterator;
import java.util.LinkedList;

public class Album {
    private String album;
    private LinkedList<Song> songs;

    public Album(String album) {
        this.album = album;
        this.songs = new LinkedList<>();
    }

    public String getAlbum() {
        return album;
    }

    public LinkedList<Song> getSongs() {
        return songs;
    }

    public void addSong(Song song) {
        if (songs.isEmpty()) {
            this.songs.add(song);
            System.out.println(song.getTitle() + " successfully added to " + this.album);
            return;
        }
        if (!songOnAlbum(song.getTitle())) {
            this.songs.add(song);
            System.out.println(song.getTitle() + " successfully added to " + this.album);
        } else {
            System.out.println(song.getTitle() + " already existing on " + this.album);
        }
    }

    public void addToPlaylist(int trackNo, Playlist playlist) {
        if (trackNo > this.songs.size()) {
            System.out.println("There is no such track in " + this.album);
            return;
        }
        Song searchSong = this.songs.get(trackNo - 1);
        if (songOnAlbum(searchSong.getTitle())) {
            LinkedList<Song> playlistSongs = playlist.getSongs();
            playlistSongs.add(searchSong);
            System.out.println(searchSong.toString() + " added to " + playlist.getPlayList());
        } else {
            System.out.println("There is no such track in " + this.album);
        }
    }

    public void addToPlaylist(String songName, Playlist playlist) {
        if (songOnAlbum(songName)) {
            LinkedList<Song> playlistSongs = playlist.getSongs();
            playlistSongs.add(getSong(songName));
            System.out.println(getSong(songName).toString() + " added to " + playlist.getPlayList());
        } else {
            System.out.println("There is no such track in " + this.album);
        }
    }

    public void printSongs() {
        System.out.println(this.album + " songs:");
        Iterator<Song> songList = this.songs.iterator();
        int position = 0;
        while (songList.hasNext()) {
            position++;
            Song songPrint = songList.next();
            System.out.println(position + ". " + songPrint.toString());
        }
    }

    private boolean songOnAlbum(String songTitle) {
        boolean alreadyStored = false;
        for (Song songStored : songs) {
            if (songStored.getTitle().equals(songTitle)) {
                alreadyStored = true;
                break;
            }
        }
        return alreadyStored;
    }

    private Song getSong(String songTitle) {
        for (Song checkSong : this.songs) {
            if (checkSong.getTitle().equals(songTitle)) {
                return checkSong;
            }
        }
        return null;
    }
}
