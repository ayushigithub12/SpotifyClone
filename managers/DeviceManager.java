package Spotify.managers;

import Spotify.device.HeadphoneAdapter;
import Spotify.device.IAudioOutputDevice;
import Spotify.device.WiredAdapter;
import Spotify.enums.DeviceType;
import Spotify.external.HeadphoneSpeakerApi;
import Spotify.external.WiredSpeakerApi;
import Spotify.factory.DeviceFactory;

public class DeviceManager {
    private static DeviceManager instance=null;
        private IAudioOutputDevice currAudioOutputDevice;
    
        private DeviceManager(){
            currAudioOutputDevice = null;
        }
    
        public static DeviceManager getInstance(){
            if(instance == null){
                instance = new DeviceManager();
            }
            return instance;
        }

    // Function which handles the device connection part
    public void Connect(DeviceType dt){
        if(currAudioOutputDevice!=null){
            // handled by garbage collector
        }
        // creates the device
        currAudioOutputDevice = DeviceFactory.createDevice(dt);
        switch (dt) {
            case BLUETOOTH:
                System.out.println("Bluetooth device is connected.");
                break;
            case WIRED:
                System.out.println("Wired device is connected.");
                break;
            case HEADPHONE:
                System.out.println("Headphone device is connected.");
                break;
        }
    }

    public IAudioOutputDevice getAudioDevice(){
        if(currAudioOutputDevice==null){
            throw new RuntimeException("No output device is connected.");
        }
        return currAudioOutputDevice;
    }

    public boolean isConnected(){
        return currAudioOutputDevice!=null;
    }

}
