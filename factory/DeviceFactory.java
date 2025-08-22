package Spotify.factory;
// It handles the creation of the Device types
import Spotify.device.BluetoothAdapter;
import Spotify.device.HeadphoneAdapter;
import Spotify.device.IAudioOutputDevice;
import Spotify.device.WiredAdapter;
import Spotify.enums.DeviceType;
import Spotify.external.BluetoothSpeakerApi;
import Spotify.external.HeadphoneSpeakerApi;
import Spotify.external.WiredSpeakerApi;

public class DeviceFactory {
    
    public static IAudioOutputDevice createDevice(DeviceType dt){
        switch (dt) {
            case BLUETOOTH:
                return new BluetoothAdapter(new BluetoothSpeakerApi());
            case WIRED:
                return new WiredAdapter(new WiredSpeakerApi());
            case HEADPHONE:
            default:
                return new HeadphoneAdapter(new HeadphoneSpeakerApi());
        }
    }
}
