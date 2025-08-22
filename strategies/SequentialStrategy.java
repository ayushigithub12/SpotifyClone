package Spotify.strategies;

import Spotify.models.Playlist;
import Spotify.models.Song;

public class SequentialStrategy implements PlayStrategy {

    private Playlist currPlaylist;
    private int idx;

    public SequentialStrategy(){
        this.currPlaylist = null;
        this.idx = -1;
    }

    @Override
    public void setPlaylist(Playlist playlist) {
        this.currPlaylist = playlist;
        idx = -1;

    }

    @Override
    public Song nextSong() {
        if(currPlaylist==null || currPlaylist.getSize()==0){
            throw new RuntimeException("No playlist loaded or playlist is empty.");
        }
        idx=idx+1;
        return currPlaylist.getSongs().get(idx);
    }

    @Override
    public Song previousSong() {
        if(currPlaylist.getSize()==0 || currPlaylist==null){
            throw new RuntimeException("No playlist loaded or playlist is empty.");
        }
        idx=idx-1;
        return currPlaylist.getSongs().get(idx);
    }

    @Override
    public boolean hasNext() {
        return (idx+1) < currPlaylist.getSize();
    }

    @Override
    public boolean hasPrevious() {
        return (idx-1) > 0;
    }
    
}
