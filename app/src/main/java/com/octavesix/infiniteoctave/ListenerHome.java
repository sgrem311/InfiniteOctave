package com.octavesix.infiniteoctave;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.firestore.ListenerRegistration;

import java.util.ArrayList;

public class ListenerHome extends AppCompatActivity {
    boolean clicked1 = false;
    boolean clicked2 = false;
    boolean clicked3 = false;
    boolean clicked4 = false;
    ArrayList<TextView> songName=new ArrayList<TextView>();
    ArrayList<TextView> bandName=new ArrayList<TextView>();
    SongStorage songStorage;
    ImageButton starButton1, starButton2, starButton3, starButton4;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.row_layout);
        songStorage = new SongStorage();
        starButton1 = findViewById(R.id.star1);
        starButton2 = findViewById(R.id.star2);
        starButton3 = findViewById(R.id.star3);
        starButton4 = findViewById(R.id.star4);
        songName.add((TextView)findViewById(R.id.songName));
        songName.add((TextView)findViewById(R.id.songName2));
        songName.add((TextView)findViewById(R.id.songName3));
        songName.add((TextView)findViewById(R.id.songName4));
        bandName.add((TextView)findViewById(R.id.bandName));
        bandName.add((TextView)findViewById(R.id.bandName2));
        bandName.add((TextView)findViewById(R.id.bandName3));
        bandName.add((TextView)findViewById(R.id.bandName4));
        goldStar();
        songStorage.add(new Song("song", "artist"));
        songStorage.add(new Song("song3", "artist1"));
        songStorage.add(new Song("song7", "artist6"));
        songStorage.add(new Song("song2", "artist2"));
        SongIterator iterator = new SongIterator(songStorage.getSongs());
        int i = 0;
        while(iterator.hasNext() && i >=  0 && i<songName.size()){
            Song s = iterator.next();
            songName.get(i).setText(s.getName());
            bandName.get(i).setText(s.getArtist());
            i++;
        }
    }
    public void goldStar(){
        starButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!clicked1) {
                    starButton1.setImageResource(R.drawable.goldstar1);
                    clicked1 = true;
                }
                else {
                    starButton1.setImageResource(R.drawable.star);
                    clicked1 = false;
                }
            }
        });

        starButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!clicked2) {
                    starButton2.setImageResource(R.drawable.goldstar1);
                    clicked2 = true;
                }
                else {
                    starButton2.setImageResource(R.drawable.star);
                    clicked2 = false;
                }
            }
        });
        starButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!clicked3) {
                    starButton3.setImageResource(R.drawable.goldstar1);
                    clicked3 = true;
                }
                else {
                    starButton3.setImageResource(R.drawable.star);
                    clicked3 = false;
                }
            }
        });
        starButton4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!clicked4) {
                    starButton4.setImageResource(R.drawable.goldstar1);
                    clicked4 = true;
                }
                else {
                    starButton4.setImageResource(R.drawable.star);
                    clicked4 = false;
                }
            }
        });

    }

}
