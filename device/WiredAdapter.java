package Spotify.device;


import Spotify.external.WiredSpeakerApi;
import Spotify.models.Song;

public class WiredAdapter implements IAudioOutputDevice{
    private WiredSpeakerApi wiredSpeakerApi;

    public WiredAdapter(WiredSpeakerApi wiredapi){
        this.wiredSpeakerApi = wiredapi;
    }

    @Override
    public void playAudio(Song song) {
       String payload = song.getName() + " sung by: " + song.getArtist();
       wiredSpeakerApi.playViaWired(payload);
    }
}
