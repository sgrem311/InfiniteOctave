package com.octavesix.infiniteoctave;

public class Song {
    private String name;
    private String bandName;
    private int image;
    public Song(String songName, int image){
        this.name = songName;
        this.image = image;
    }
    public String getName(){
        return name;
    }
    public int getImage(){
        return image;
    }
}
