package Spotify.managers;

import java.util.HashMap;
import java.util.Map;

import Spotify.models.Playlist;
import Spotify.models.Song;

public class PlaylistManager {
    private static PlaylistManager instance=null;
    private Map<String,Playlist> playlist;

    private PlaylistManager(){
        playlist = new HashMap<>();
    }

    public static PlaylistManager getInstance(){
        if(instance ==null){
            instance = new PlaylistManager();
        }
        return instance;
    }

    // create playlist
    public void createPlaylist(String pname){
        if(playlist.containsKey(pname)){
            System.out.println("Playlist already exist.");
        }
        playlist.put(pname, new Playlist(pname));
    }

    // add song in the playlist
    public void addSongInPlaylist(String pname, Song song){
        if(!playlist.containsKey(pname)){
            throw new RuntimeException("Playlist \"" + pname + "\" not found.");
        }

        playlist.get(pname).addSong(song);
    }

    // get the list of songs in the playlist
    public Playlist getPlaylist(String pname){
        if(!playlist.containsKey(pname)){
            throw new RuntimeException("Playlist \"" + pname + "\" not found.");
        }
        return playlist.get(pname);
    }

}
