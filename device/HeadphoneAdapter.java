package Spotify.device;

import Spotify.external.HeadphoneSpeakerApi;
import Spotify.models.Song;

public class HeadphoneAdapter implements IAudioOutputDevice{
    private HeadphoneSpeakerApi headphoneSpeakerApi;

    public HeadphoneAdapter(HeadphoneSpeakerApi headphoneapi){
        this.headphoneSpeakerApi=headphoneapi;
    }

    @Override
    public void playAudio(Song song) {
        String payload = song.getName() + " sung by: " + song.getArtist();
        headphoneSpeakerApi.playViaHeadphone(payload);
    }
    
}
