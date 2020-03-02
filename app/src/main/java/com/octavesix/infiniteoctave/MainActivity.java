package com.octavesix.infiniteoctave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button signIn;
    EditText username, password;
    TextView signUp, forgotPassword;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseHelper(this);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        signUp = findViewById(R.id.signUp);
        signUp.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent registerIntent = new Intent(MainActivity.this, Register_Activity.class);
                startActivity(registerIntent);
            }

        });
        signIn = findViewById(R.id.signIn);
        signIn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String Username = username.getText().toString();
                String Password = password.getText().toString();
                if(Username.equals("")||Password.equals("")){
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean checkUsernamePassword = db.usernamePassword(Username, Password);
                    if(checkUsernamePassword){
                        Intent loginIntent = new Intent(MainActivity.this, Home_Activity.class);
                        startActivity(loginIntent);
                    }
                    else
                        Toast.makeText(MainActivity.this, "Wrong username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
