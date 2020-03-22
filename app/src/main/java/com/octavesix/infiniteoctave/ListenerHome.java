package com.octavesix.infiniteoctave;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ListenerHome extends AppCompatActivity {
    boolean clicked1 = false;
    boolean clicked2 = false;
    boolean clicked3 = false;
    boolean clicked4 = false;
    ImageButton starButton1, starButton2, starButton3, starButton4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);
        starButton1 = findViewById(R.id.star1);
        starButton2 = findViewById(R.id.star2);
        starButton3 = findViewById(R.id.star3);
        starButton4 = findViewById(R.id.star4);
        goldStar();
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
