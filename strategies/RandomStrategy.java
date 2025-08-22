package Spotify.strategies;

import java.util.List;
import java.util.Random;
import java.util.Stack;

import Spotify.models.Playlist;
import Spotify.models.Song;

public class RandomStrategy implements PlayStrategy{
    private Playlist currentPlaylist;
    private List<Song> remainingSongs;
    private Stack <Song> history;
    private Random random;
    
    public RandomStrategy(){
        this.currentPlaylist = null;
        random = new Random();
    }

    @Override
    public void setPlaylist(Playlist playlist) {
        currentPlaylist = playlist;
       if(currentPlaylist == null || currentPlaylist.getSize()==0) return;

       remainingSongs = playlist.getSongs();
       history = new Stack<>();
    }

    @Override
    public Song nextSong() {
        if(currentPlaylist==null || currentPlaylist.getSize()==0) {
            throw new RuntimeException("No playlist loaded or playlist is empty.");
        }
        if(remainingSongs.isEmpty()) {
            throw new RuntimeException("No songs left to play");
        }

        // get the random song from the remaing song list
        int idx = random.nextInt(remainingSongs.size());
        Song selectedSong = remainingSongs.get(idx);

        // swap the selected Song from the list
        int lastIndex = remainingSongs.size() - 1;
        remainingSongs.set(lastIndex, remainingSongs.get(lastIndex));
        remainingSongs.remove(lastIndex);

        // store the previous song in stack
        history.add(selectedSong);
        return selectedSong;
    }

    @Override
    public Song previousSong() {
        if(history.isEmpty()){
            throw new RuntimeException("No previous song available.");
        }
        Song previousSong = history.pop();
        return previousSong;
    }

    @Override
    public boolean hasNext() {
       return currentPlaylist!=null && remainingSongs.isEmpty();
    }

    @Override
    public boolean hasPrevious() {
        return history.size() > 0;
    }
    
}
