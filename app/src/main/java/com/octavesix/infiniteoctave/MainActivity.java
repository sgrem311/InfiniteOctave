package com.octavesix.infiniteoctave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.spotify.android.appremote.api.ConnectionParams;
import com.spotify.android.appremote.api.Connector;
import com.spotify.android.appremote.api.SpotifyAppRemote;

import com.spotify.protocol.client.Subscription;
import com.spotify.protocol.types.PlayerState;
import com.spotify.protocol.types.Track;
import com.google.android.gms.common.internal.AccountType;

public class MainActivity extends AppCompatActivity {
    Button signIn;
    EditText username, password;
    TextView signUp, forgotPassword;
    DatabaseHelper database;
    RadioButton listener;
    RadioButton producer;
    String accountType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = new DatabaseHelper(this);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        signUp = findViewById(R.id.signUp);
        signUp();
        signIn();
        listener = findViewById(R.id.listener);
        producer = findViewById(R.id.producer);
        signIn = findViewById(R.id.signIn);

    }
    public void signUp(){
        signUp.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent registerIntent = new Intent(MainActivity.this, Register_Activity.class);
                startActivity(registerIntent);
            }
        });
    }
    public void signIn(){
        signIn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String Username = username.getText().toString();
                String Password = password.getText().toString();
                if(Username.equals("")||Password.equals("")){
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean checkUsernamePassword = database.usernamePassword(Username, Password);
                    Cursor cursor = database.allData();
                    while(!cursor.isAfterLast()) {
                        cursor.moveToNext();
                        if (cursor.getString(2).equals(Username)) {
                            accountType = cursor.getString(11);
                            break;
                        }
                    }
                    if(checkUsernamePassword ){
                        if(accountType.equals("Listener")) {
                            Intent loginIntent = new Intent(MainActivity.this, ListenerHome.class);
                            startActivity(loginIntent);
                        }
                        else if(accountType.equals("Producer")){
                            Intent loginIntent = new Intent(MainActivity.this, ProducerHome.class);
                            startActivity(loginIntent);
                        }
                    }
                    else
                        Toast.makeText(MainActivity.this, "Wrong username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void forgotPassword(){

    }

}
