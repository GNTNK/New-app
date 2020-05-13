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

public class RegisterActivity extends AppCompatActivity {

    EditText editTextUsername, editTestEmail, editTestPassword, editTextCnfPassword;
    Button buttonRegister;
    private UserDAO userDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);
        setTitle("Registration");

        editTextUsername = findViewById(R.id.editTextUsername);
        editTestEmail = findViewById(R.id.editTextEmail);
        editTestPassword = findViewById(R.id.editTextPassword);
        editTextCnfPassword = findViewById(R.id.editTextCnfPassword);

        buttonRegister = findViewById(R.id.buttonRegister);

        userDAO = Room.databaseBuilder(this, UserDataBase.class, "User").allowMainThreadQueries().build().getUserDao();

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = editTextUsername.getText().toString().trim();
                String email = editTestEmail.getText().toString().trim();
                String password = editTestPassword.getText().toString().trim();
                String passwordConf = editTextCnfPassword.getText().toString().trim();

                if (password.equals(passwordConf)) {
                    User user = new User(userName, password, email);
                    userDAO.insert(user);
                    Intent moveToLogin = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(moveToLogin);
                } else {
                    Toast.makeText(RegisterActivity.this, "Password is not matching", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
