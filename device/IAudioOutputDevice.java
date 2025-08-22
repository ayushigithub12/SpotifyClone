package Spotify.device;

import Spotify.models.Song;

public interface IAudioOutputDevice {
    void playAudio(Song song);
}
