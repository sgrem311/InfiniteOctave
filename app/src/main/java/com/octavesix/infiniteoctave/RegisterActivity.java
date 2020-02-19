package com.octavesix.infiniteoctave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;

public class RegisterActivity extends AppCompatActivity {
    Button createAccount;
    EditText username, password, firstName, lastName, email, phoneNumber, country, state, birthDate, city;
    File accountInfo= new File("accountInfo.txt");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        createAccount = findViewById(R.id.submit);
        findViewById(R.id.usernameInput);
        findViewById(R.id.passwordInput);
        createAccount.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent loginIntent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(loginIntent);
            }
        });
        username = findViewById(R.id.usernameInput);
        password = findViewById(R.id.password);
        firstName = findViewById(R.id.FirstName);
        lastName = findViewById(R.id.LastName);
        email = findViewById(R.id.email);
        phoneNumber = findViewById(R.id.Gender);
        country = findViewById(R.id.country);
        state = findViewById(R.id.state);
        birthDate = findViewById(R.id.BirthDate);
        city = findViewById(R.id.city);

    }
}
