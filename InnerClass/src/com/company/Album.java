package com.company;

import java.util.Iterator;
import java.util.LinkedList;

public class Album {
    private String album;
    private Songlist songlist;


    public Album(String album) {
        this.album = album;
        this.songlist = new Songlist();
    }

    public String getAlbum() {
        return album;
    }

    public LinkedList<Song> getSongs() {
        return songlist.getSongs();
    }

    public void addSong(Song song) {
        if (this.songlist.addSong(song)) {
            System.out.println(song.getTitle() + " successfully added to " + this.album);
        } else {
            System.out.println(song.getTitle() + " already existing on " + this.album);
        }
    }


    public void addToPlaylist(int trackNo, Playlist playlist) {
        if (trackNo > this.songlist.getSongs().size()) {
            System.out.println("There is no such track in " + this.album);
            return;
        }
        LinkedList<Song> playlistSongs = playlist.getSongs();
        playlistSongs.add(this.songlist.findSong(trackNo));
        System.out.println(this.songlist.findSong(trackNo).toString() + " added to " + playlist.getPlayList());

    }

    public void addToPlaylist(String songName, Playlist playlist) {
        if (songlist.songOnAlbum(songName)) {
            LinkedList<Song> playlistSongs = playlist.getSongs();
            playlistSongs.add(songlist.findSong(songName));
            System.out.println(songlist.findSong(songName).toString() + " added to " + playlist.getPlayList());
        } else {
            System.out.println("There is no such track in " + this.album);
        }
    }

    public void printSongs() {
        System.out.println(this.album + " songs:");
        Iterator<Song> songList = this.songlist.getSongs().iterator();
        int position = 0;
        while (songList.hasNext()) {
            position++;
            Song songPrint = songList.next();
            System.out.println(position + ". " + songPrint.toString());
        }
    }

    private class Songlist {
        private LinkedList<Song> songs;

        public Songlist() {
            this.songs = new LinkedList<>();
        }

        public LinkedList<Song> getSongs() {
            return songs;
        }

        public boolean addSong(Song song) {
            if (songs.isEmpty()) {
                this.songs.add(song);
                return true;
            }
            if (!songOnAlbum(song.getTitle())) {
                this.songs.add(song);
                return true;
            } else {
                return false;
            }
        }

        public boolean songOnAlbum(String songTitle) {
            boolean alreadyStored = false;
            for (Song songStored : songs) {
                if (songStored.getTitle().equals(songTitle)) {
                    alreadyStored = true;
                    break;
                }
            }
            return alreadyStored;
        }

        public Song findSong(String songTitle) {
            for (Song checkSong : this.songs) {
                if (checkSong.getTitle().equals(songTitle)) {
                    return checkSong;
                }
            }
            return null;
        }

        public Song findSong(int trackNo) {
            return this.songs.get(trackNo - 1);
        }


    }
}
