package Spotify.device;

import Spotify.external.BluetoothSpeakerApi;
import Spotify.models.Song;

public class BluetoothAdapter implements IAudioOutputDevice {
    private BluetoothSpeakerApi bluetoothSpeakerApi;

    public BluetoothAdapter(BluetoothSpeakerApi bluetoothApi){
        this.bluetoothSpeakerApi = bluetoothApi;
    }

    @Override
    public void playAudio(Song song) {
       String payload = song.getName() + " sung by: " + song.getArtist();
       bluetoothSpeakerApi.playViaBluetooth(payload);
    }
    
}
