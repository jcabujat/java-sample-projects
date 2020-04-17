package com.company;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Album album1 = new Album("Album 1");
        Song song1 = new Song("Song1", "03:10");
        Song song2 = new Song("Song2", "03:15");
        album1.addSong(song1);
        album1.addSong(song2);
        album1.addSong(song1);
        album1.printSongs();
        Album album2 = new Album("Album 2");
        Song song3 = new Song("Song3", "04:00");
        album2.addSong(song3);
        Playlist playlist1 = new Playlist("Playlist1");
        playlist1.add(album2);
        playlist1.add(album2);
        album1.addToPlaylist(1, playlist1);
        album1.addToPlaylist("Song2", playlist1);
        album1.addToPlaylist(3, playlist1);
        album1.addToPlaylist("Song4", playlist1);
        album1.addToPlaylist(4, playlist1);
        printSongs(playlist1);
        playSongs(playlist1);
    }

    private static void printSongs(Playlist playlist) {
        System.out.println(playlist.getPlayList() + " songs:");
        LinkedList<Song> playListSongs = playlist.getSongs();
        ListIterator<Song> songList = playListSongs.listIterator();
        int position = 0;
        while (songList.hasNext()) {
            position++;
            System.out.println(position + ". " + songList.next().toString());
        }
    }

    private static void playSongs(Playlist playlist) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        boolean endOfList = false;
        boolean startOfList = true;
        int action;
        LinkedList<Song> playListSongs = playlist.getSongs();
        ListIterator<Song> songList = playListSongs.listIterator();

        if (playListSongs.isEmpty()) {
            System.out.println("There are no songs on " + playlist.getPlayList());
            return;
        }

        printActions();

        while (!quit) {
            action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    if (!goingForward) {
                        if (songList.hasNext()) {
                            songList.next();
                        }
                        goingForward = true;
                    }
                    if (songList.hasNext()) {
                        System.out.println("Now playing " + songList.next().toString());
                        startOfList = false;
                        endOfList = false;
                    } else {
                        System.out.println("You're at the end of playlist");
                        endOfList = true;
                        goingForward = false;
                    }
                    break;
                case 2:
                    if (goingForward) {
                        if (songList.hasPrevious()) {
                            songList.previous();
                        }
                        goingForward = false;
                    }
                    if (songList.hasPrevious()) {
                        System.out.println("Now playing " + songList.previous().toString());
                        startOfList = false;
                        endOfList = false;
                    } else {
                        System.out.println("You're at the start of playlist");
                        startOfList = true;
                        goingForward = true;
                    }
                    break;
                case 3:
                    if (endOfList) {
                        System.out.println("Replaying " + songList.previous().toString());
                        goingForward = false;
                        endOfList = false;
                    } else if (startOfList) {
                        System.out.println("Replaying " + songList.next().toString());
                        goingForward = true;
                        startOfList = false;
                    } else if (!goingForward && !endOfList) {
                        System.out.println("Replaying " + songList.next().toString());
                        goingForward = true;
                    } else if (goingForward && !startOfList) {
                        System.out.println("Replaying " + songList.previous().toString());
                        goingForward = false;
                    }
                    break;
                case 4:
                    printActions();
                    break;
                case 5:
                    songList.remove();
                    if (songList.hasNext()) {
                        System.out.println("Now playing " + songList.next().toString());
                    } else if (songList.hasPrevious()) {
                        System.out.println("Now playing " + songList.previous().toString());
                    } else {
                        System.out.println("All songs have been removed from the playlist." +
                                "\nExiting the music player now...");
                        quit = true;
                    }
                    break;
                default:
                    System.out.println("Invalid selection. Please select from below.");
                    printActions();
                    break;
            }
        }
    }

    private static void printActions() {
        System.out.println("Actions: " +
                "\n0. Quit" +
                "\n1. Play next song" +
                "\n2. Play previous song" +
                "\n3. Replay song" +
                "\n4. Print actions" +
                "\n5. Remove current song from playlist");
    }


}
