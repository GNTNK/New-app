package com.example.loyverseposexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loyverseposexample.data.UserDAO;
import com.example.loyverseposexample.data.UserDataBase;
import com.example.loyverseposexample.model.User;

public class SignInActivity extends AppCompatActivity {

    EditText editEmail, editPassword;
    Button buttonLogin;
    TextView textViewRegister;
    UserDAO db;
    UserDataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        editEmail = findViewById(R.id.editTextEmail);
        editPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);



        dataBase = Room.databaseBuilder(this, UserDataBase.class,"User")
                .allowMainThreadQueries()
                .build();
        db = dataBase.getUserDao();

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editEmail.getText().toString().trim();
                String password = editPassword.getText().toString().trim();

                User user = db.getUser(email,password);
                if (user != null) {
                    Intent i = new Intent(SignInActivity.this, HomePageActivity.class);
                    i.putExtra("User", user);
                    startActivity(i);
                    finish();
                } else {
                    Toast.makeText(SignInActivity.this, "Unregister User, or incorrect username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}