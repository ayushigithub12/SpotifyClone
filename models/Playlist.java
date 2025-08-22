package Spotify.models;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private String playlistName;
    List<Song> songs;

    public Playlist(String playlist){
        this.playlistName = playlist;
        songs = new ArrayList<>();
    }

    public void setPlaylistName(String pname){
        this.playlistName = pname;
    }

    public String getPlaylistName(){
        return playlistName;
    }

    public List<Song> getSongs(){
        return songs;
    }

    public int getSize(){
        return songs.size();
    }

    // add the song in the playlist
    public void addSong(Song songName){
        songs.add(songName);
    }
}
