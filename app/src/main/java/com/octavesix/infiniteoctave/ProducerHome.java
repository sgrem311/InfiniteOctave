package com.octavesix.infiniteoctave;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;

public class ProducerHome extends AppCompatActivity {
    Button upload;
    private MediaPlayer mediaPlayer;
    SongStorage songStorage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_producer);
        songStorage = new SongStorage();
    }
    public void playList(){
        SongIterator iterator = new SongIterator(songStorage.getSongs());
        while(iterator.hasNext()){
            Song s = iterator.next();
        }
    }
}
