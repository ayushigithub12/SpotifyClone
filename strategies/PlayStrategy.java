package Spotify.strategies;

import Spotify.models.Playlist;
import Spotify.models.Song;

public interface PlayStrategy {
    void setPlaylist(Playlist playlist);
    Song nextSong();
    Song previousSong();
    boolean hasNext();
    boolean hasPrevious();
    // this function is for custom Strategy
    default void addToNext(Song song){}
}
