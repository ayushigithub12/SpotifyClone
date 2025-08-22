package Spotify;

import Spotify.core.AudioEngine;
import Spotify.device.IAudioOutputDevice;
import Spotify.enums.DeviceType;
import Spotify.enums.PlayStrategyType;
import Spotify.managers.DeviceManager;
import Spotify.managers.PlaylistManager;
import Spotify.managers.StrategyManager;
import Spotify.models.Playlist;
import Spotify.models.Song;
import Spotify.strategies.PlayStrategy;


public class MusicPlayerFacade {
    private static MusicPlayerFacade instance = null;
    private AudioEngine audioEngine;
    private Playlist playlist;
    private PlayStrategy playStrategy;

    private MusicPlayerFacade(){
        audioEngine = new AudioEngine();
        playlist = null;
        playStrategy = null;
    }

    public static MusicPlayerFacade getInstance(){
        if(instance==null){
            instance = new MusicPlayerFacade();
        }
        return instance;
    }

    // 1. Connect the device by specifying the device type
    public void connectDevice(DeviceType deviceType){
        DeviceManager.getInstance().Connect(deviceType);
    } 

    // 2. Set the Play Strategy
    public void setPlayStrategy(PlayStrategyType strategyType){
        playStrategy = StrategyManager.getInstance().getStrategy(strategyType);
    }

    // 3. load the playlist to the strategy
    public void loadPlaylist(String name){
        playlist = PlaylistManager.getInstance().getPlaylist(name);
        if(playStrategy == null){
            throw new RuntimeException("Play strategy not set before loading.");
        }
        playStrategy.setPlaylist(playlist);
    }

    // 4. Play the song 
    //      - Validate whether device is connected
    //      - call the audioEngine.play() 
    public void playSong(Song song){
        if(!DeviceManager.getInstance().isConnected()){
            throw new RuntimeException("No audio device connected.");
        }
        IAudioOutputDevice device = DeviceManager.getInstance().getAudioDevice();
        audioEngine.play(device, song);

    }

    // 5. Pause the song
    public void pause(Song song){
        if(!audioEngine.getCurrSongTitle().equals(song.getName())){
            throw new RuntimeException("Cannot pause \"" + song.getName() + "\"; not currently playing.");
        }
        audioEngine.pause();
    }

    // 6. Play all songs
    public void playAllTrack(){
        if(playlist==null){
            throw new RuntimeException("No playlist loaded.");
        }
        while(playStrategy.hasNext()){
            Song song = playStrategy.nextSong();
            IAudioOutputDevice audioOutputDevice = DeviceManager.getInstance().getAudioDevice();
            audioEngine.play(audioOutputDevice, song);
        }

        System.out.println("Completed playlist: " + playlist.getPlaylistName());
    }

    // 7. Play next track
    public void playNextTrack(){
        if(playlist==null){
            throw new RuntimeException("No playlist loaded.");
        }
        if(playStrategy.hasNext()){
            Song song = playStrategy.nextSong();
            IAudioOutputDevice audioOutputDevice = DeviceManager.getInstance().getAudioDevice();
            audioEngine.play(audioOutputDevice, song);
        }else{
            System.out.println("Completed playlist: " + playlist.getPlaylistName());
        }
    }

    // 8. play the previous track
    public void playPreviousTrack(){
        if (playlist == null) {
            throw new RuntimeException("No playlist loaded.");
        }
        if (playStrategy.hasPrevious()) {
            Song prevSong = playStrategy.previousSong();
            IAudioOutputDevice device = DeviceManager.getInstance().getAudioDevice();
            audioEngine.play(device, prevSong);
        } else {
            System.out.println("Completed playlist: " + playlist.getPlaylistName());
        }

    }

    // 9. Play a specfic song
    public void enqueueNext(Song song) {
        playStrategy.addToNext(song);
    }

}
