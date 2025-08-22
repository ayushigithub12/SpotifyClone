package Spotify.core;
// It handles the play and pause feature of the song through IAudioDevice
import Spotify.device.IAudioOutputDevice;
import Spotify.models.Song;

public class AudioEngine {
    private Song currSong;
    private boolean isPause;

    public AudioEngine(){
        this.currSong = null;
        this.isPause = false;
    }

    public String getCurrSongTitle(){
        if(currSong!=null){
            System.out.println(currSong.getName());
            return currSong.getName();
        }
        return "";
    }

    public boolean isPaused(){
        return isPause;
    }

    public void play(IAudioOutputDevice aod, Song song){
        if(song==null){
            throw new RuntimeException("Cannot play a song");
        }
    
        if(isPause && song==currSong){
            isPause = false;
            System.out.println("Resuming song: " + song.getName());
            aod.playAudio(song);
            return;
        }

        currSong = song;
        isPause = false;
        System.out.println("Playing song: " + song.getName());
        aod.playAudio(song);

    }

    public void pause(){
        if(isPause){
            System.out.println("Song is alreadly paused!!");
        }
        if(currSong==null){
            throw new RuntimeException("No song is currently playing to pause.");
        }
        isPause=true;
        System.out.println("Pausing song: " + currSong.getName());
    }
}
