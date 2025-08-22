package Spotify;

import java.util.ArrayList;
import java.util.List;

import Spotify.enums.DeviceType;
import Spotify.enums.PlayStrategyType;
import Spotify.managers.PlaylistManager;
import Spotify.models.Playlist;
import Spotify.models.Song;

public class MusicPlayerApplication {
    private static MusicPlayerApplication instance;
    private List<Song> songs;
    
    private MusicPlayerApplication(){
        songs = new ArrayList<>();
    }

    public static MusicPlayerApplication getInstance(){
        if(instance == null){
            instance = new MusicPlayerApplication();
        }

        return instance;
    }

    // function to create a song and add it in the song list
    public void createSongInLibrary(String sname, String artist, String path){
        Song newSong = new Song(sname, artist, path);
        songs.add(newSong);
    }

    // function to find song by title
    public Song findSongTitle(String songName){
        for(Song s: songs){
            if(s.getName().equals(songName)){
                return s;
            }
        }
        return null;
    }

    // function to create a playlist
    public void createPlaylist(String playlistName){
        PlaylistManager.getInstance().createPlaylist(playlistName);
    }

    // function to add the song in the playlist
    public void addSongToPlaylist(String songName, String playlistName){
        Song song = findSongTitle(songName);
        if(song==null){
            throw new RuntimeException("Song \"" + songName + "\" not found in library.");
        }
        PlaylistManager.getInstance().addSongInPlaylist(playlistName, song);
    }

    // Connect the Audio device
    public void connectAudioDevice(DeviceType deviceType){
        MusicPlayerFacade.getInstance().connectDevice(deviceType);
    }

    // Select the strategy type
    public void selectStrategyType(PlayStrategyType strategyType){
        MusicPlayerFacade.getInstance().setPlayStrategy(strategyType);
    }

    // Load the playlist
    public void loadPlaylist(String playlistName){
        MusicPlayerFacade.getInstance().loadPlaylist(playlistName);
    }

    // play the song 
    public void playSong(String songTitle){
        Song song = findSongTitle(songTitle);
        if(song==null){
            throw new RuntimeException("Song \"" + songTitle + "\" not found in library.");
        }
        MusicPlayerFacade.getInstance().playSong(song);
    }

    // pause the song
    public void pauseCurrentSong(String songTitle){
        Song song = findSongTitle(songTitle);
        if (song == null) {
            throw new RuntimeException("Song \"" + songTitle + "\" not found.");
        }
        MusicPlayerFacade.getInstance().pause(song);
    }

    // Play all the songs in playlist
    public void playAllSongsInPlaylist(){
        MusicPlayerFacade.getInstance().playAllTrack();
    }

    // Play previous song in playlit
    public void playPreviousTrackPlaylist(){
        MusicPlayerFacade.getInstance().playPreviousTrack();
    }

    // Play a specific song 
    public void queueSongext(String songTitle){
        Song song = findSongTitle(songTitle);
        if (song == null) {
            throw new RuntimeException("Song \"" + songTitle + "\" not found.");
        }
        MusicPlayerFacade.getInstance().enqueueNext(song);
    }
}
