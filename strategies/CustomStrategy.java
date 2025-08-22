package Spotify.strategies;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import Spotify.models.Playlist;
import Spotify.models.Song;

public class CustomStrategy implements PlayStrategy{
    private Playlist currPlaylist;
    private int idx;
    Queue<Song> nextQueue;
    Stack<Song> history;

    public CustomStrategy(){
        currPlaylist = null;
        idx = -1;
        nextQueue = new LinkedList<>();
        history = new Stack<>();
    }


    @Override
    public void setPlaylist(Playlist playlist) {
        currPlaylist = playlist;
        idx = -1;
        nextQueue.clear();
        history.clear();
    }

    @Override
    public Song nextSong() {
        if(currPlaylist==null || currPlaylist.getSize()==0) {
            throw new RuntimeException("No playlist loaded or playlist is empty.");
        }
        
        if(!nextQueue.isEmpty()){
            Song s = nextQueue.poll();
            history.add(s);

            for(int i=0;i<currPlaylist.getSongs().size();i++){
                if(s==currPlaylist.getSongs().get(i)){
                    idx = i;
                    break;
                }
            }
            return s;
        }
        return nextSequential();
    }

    @Override
    public Song previousSong() {
        if(currPlaylist==null || currPlaylist.getSize()==0) {
            throw new RuntimeException("No playlist loaded or playlist is empty.");
        }
        if(!history.isEmpty()){
           Song s = history.pop();

           for(int i=0;i<currPlaylist.getSongs().size();i++){
                if(s==currPlaylist.getSongs().get(i)){
                    idx = i;
                    break;
                }
            }
            return s;
        }
        return previousSequential();
    }

    @Override
    public boolean hasNext() {
       return (idx+1) < currPlaylist.getSize();
    }

    @Override
    public boolean hasPrevious() {
        return (idx-1)>0;
    }

    // function to add a custom song by the user in the nextqueue
    @Override
    public void addToNext(Song song){
        if(song==null){
            throw new RuntimeException("Cannot enqueue null song.");
        }
        nextQueue.add(song);
    }

    public Song nextSequential(){
        if (currPlaylist.getSize() == 0) {
            throw new RuntimeException("Playlist is empty.");
        }
        idx = idx + 1;
        return currPlaylist.getSongs().get(idx);
    }

    public Song previousSequential(){
        if (currPlaylist.getSize() == 0) {
            throw new RuntimeException("Playlist is empty.");
        }
        idx = idx - 1;
        return currPlaylist.getSongs().get(idx);
    }
    
}
