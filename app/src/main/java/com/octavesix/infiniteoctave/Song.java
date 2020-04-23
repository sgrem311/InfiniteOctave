package com.octavesix.infiniteoctave;

public class Song {
    private String name;
    private String bandName;
    public Song(String songName, String bandName){
        this.name = songName;
        this.bandName = bandName;
    }
    public String getName(){
        return name;
    }
    public String getArtist(){
        return bandName;
    }
}
