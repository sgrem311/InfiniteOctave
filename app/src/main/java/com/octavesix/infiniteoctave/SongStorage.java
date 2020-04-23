package com.octavesix.infiniteoctave;

import java.util.ArrayList;
import java.util.Iterator;

public class SongStorage implements Container{
    private Song[] songs = new Song[5];
    private int index = 0;
    @Override
    public Iterator getIterator() {
        return new SongIterator(songs);
    }
    public void add(Song song){
        songs[index]  = song;
        index++;
    }
    public Song[] getSongs(){
        return songs;
    }

}
