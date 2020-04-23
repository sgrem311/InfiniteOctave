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
import com.google.android.gms.common.internal.AccountType;

public class MainActivity extends AppCompatActivity {
    Button signIn;
    EditText username, password;
    TextView signUp, forgotPassword;
    DatabaseHelper db;
    RadioButton listener;
    RadioButton producer;
    String accountType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = DatabaseHelper.getInstance(this);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        signUp = findViewById(R.id.signUp);


        listener = findViewById(R.id.listener);
        producer = findViewById(R.id.producer);
        signIn = findViewById(R.id.signIn);
        signUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent registerIntent = new Intent(MainActivity.this, Register_Activity.class);
                startActivity(registerIntent);
            }
        });
        signIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String Username = username.getText().toString();
                String Password = password.getText().toString();
                if (Username.equals("") || Password.equals("")) {
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean checkUsernamePassword = db.usernamePassword(Username, Password);
                    Cursor cursor = db.allData();
                    while (!cursor.isAfterLast()) {
                        cursor.moveToNext();
                        if (cursor.getString(2).equals(Username)) {
                            accountType = cursor.getString(11);
                            break;
                        }
                    }
                    if (checkUsernamePassword) {
                        if (accountType.equals("Listener")) {
                            Intent loginIntent = new Intent(MainActivity.this, ListenerHome.class);
                            startActivity(loginIntent);
                        } else if (accountType.equals("Producer")) {
                            Intent loginIntent = new Intent(MainActivity.this, ProducerHome.class);
                            startActivity(loginIntent);
                        }
                    } else
                        Toast.makeText(MainActivity.this, "Wrong username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}