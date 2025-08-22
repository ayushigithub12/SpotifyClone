package Spotify;

import Spotify.enums.DeviceType;
import Spotify.enums.PlayStrategyType;

public class Main {
    public static void main(String[] args){
        try {
            MusicPlayerApplication application = MusicPlayerApplication.getInstance();

            // Populate library
            application.createSongInLibrary("Kesariya", "Arijit Singh", "/music/kesariya.mp3");
            application.createSongInLibrary("Chaiyya Chaiyya", "Sukhwinder Singh", "/music/chaiyya_chaiyya.mp3");
            application.createSongInLibrary("Tum Hi Ho", "Arijit Singh", "/music/tum_hi_ho.mp3");
            application.createSongInLibrary("Jai Ho", "A. R. Rahman", "/music/jai_ho.mp3");
            application.createSongInLibrary("Zinda", "Siddharth Mahadevan", "/music/zinda.mp3");

            // Create playlist and add songs
            application.createPlaylist("Bollywood Vibes");
            application.addSongToPlaylist("Kesariya", "Bollywood Vibes");
            application.addSongToPlaylist("Chaiyya Chaiyya", "Bollywood Vibes");
            application.addSongToPlaylist("Tum Hi Ho", "Bollywood Vibes");
            application.addSongToPlaylist("Jai Ho", "Bollywood Vibes");

            // Connect device
            application.connectAudioDevice(DeviceType.BLUETOOTH);

            //Play/pause a single song
            application.playSong("Zinda");
            application.pauseCurrentSong("Zinda");
            application.playSong("Zinda");  // resume

            System.out.println("\n-- Sequential Playback --\n");
            application.selectStrategyType(PlayStrategyType.SEQUENTIAL);
            application.loadPlaylist("Bollywood Vibes");
            application.playAllSongsInPlaylist();

            System.out.println("\n-- Random Playback --\n");
            application.selectStrategyType(PlayStrategyType.RANDOM);
            application.loadPlaylist("Bollywood Vibes");
            application.playAllSongsInPlaylist();

            System.out.println("\n-- Custom Queue Playback --\n");
            application.selectStrategyType(PlayStrategyType.CUSTOM_QUEUE);
            application.loadPlaylist("Bollywood Vibes");
            application.queueSongext("Kesariya");
            application.queueSongext("Tum Hi Ho");
            application.playAllSongsInPlaylist();

            System.out.println("\n-- Play Previous in Sequential --\n");
            application.selectStrategyType(PlayStrategyType.SEQUENTIAL);
            application.loadPlaylist("Bollywood Vibes");
            application.playAllSongsInPlaylist();

            application.playPreviousTrackPlaylist();
            application.playPreviousTrackPlaylist();

        } catch (Exception error) {
            System.err.println("Error: " + error.getMessage());
        }
    }
}
