package com.octavesix.infiniteoctave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Register_Activity extends AppCompatActivity {
    Button createAccount;
    EditText username, password, first, last, email, phoneNumber, country, state, birthDate, city, gender;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        db = new DatabaseHelper(this);
        createAccount = findViewById(R.id.submit);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        first = findViewById(R.id.firstName);
        last = findViewById(R.id.lastName);
        email = findViewById(R.id.email);
        phoneNumber = findViewById(R.id.phoneNumber);
        gender = findViewById(R.id.gender);
        country = findViewById(R.id.country);
        state = findViewById(R.id.state);
        birthDate = findViewById(R.id.BirthDate);
        city = findViewById(R.id.city);
        addData();
    }
    public void addData(){
        createAccount.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String Username = username.getText().toString();
                String Password = password.getText().toString();
                String First = first.getText().toString();
                String Last = last.getText().toString();
                String Country = country.getText().toString();
                String City = city.getText().toString();
                String State = state.getText().toString();
                String Gender = gender.getText().toString();
                String Phone = phoneNumber.getText().toString();
                String Email = email.getText().toString();
                String BirthDay = birthDate.getText().toString();
                if(Username.equals("")||Password.equals("")||First.equals("")||Last.equals("")||Email.equals("")||Phone.equals("")){
                    Toast.makeText(Register_Activity.this, "Fields are empty", Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean checkUsername = db.checkUsername(Username);
                    if (checkUsername) {
                        boolean isInserted = db.insertData(First, Last, Username, Password, Email, Country, City, State, Gender, Phone, BirthDay);
                        if (isInserted) {
                            Toast.makeText(Register_Activity.this, "Account created successfully", Toast.LENGTH_SHORT).show();
                            Intent loginIntent = new Intent(Register_Activity.this, MainActivity.class);
                            startActivity(loginIntent);
                        } else
                            Toast.makeText(Register_Activity.this, "Account not created", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

}
