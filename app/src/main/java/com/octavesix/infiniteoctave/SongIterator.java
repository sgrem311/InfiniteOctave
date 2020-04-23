package com.octavesix.infiniteoctave;

import java.util.ArrayList;
import java.util.Iterator;

public class SongIterator implements Iterator<Song> {
    private Song[] songs;
    private int index = 0;
    public SongIterator(Song[] songs){
        this.songs = songs;
    }
    @Override
    public boolean hasNext(){
        if(index > songs.length || songs[index]== null){
            return false;
        }
        return true;
    }
    public Song next(){
        return songs[index++];
    }
    public void remove(){
        for(int i = index-1; i<songs.length-1; i++){
            songs[i]=songs[i+1];
        }
        songs[songs.length-1] = null;
    }


}
