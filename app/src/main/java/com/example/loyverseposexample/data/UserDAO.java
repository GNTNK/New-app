package com.example.loyverseposexample.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.loyverseposexample.model.User;


@Dao
public interface UserDAO {

    @Query("SELECT * FROM User WHERE email = :email and password = :password")
    User getUser(String email, String password);


    @Insert
    void insert(User user);
}