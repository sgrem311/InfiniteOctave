package com.octavesix.infiniteoctave;

import java.util.Iterator;

public class SongStorage implements Container{
    private Song[] songs;
    private int index = 0;
    @Override
    public Iterator createIterator() {
        return new SongIterator(songs);
    }
    public void add(Song song){
        songs[index] = song;
        index++;
    }
    public Song[] getSongs(){
        return songs;
    }
    public Song getSong(){
        return songs[index];
    }
}
