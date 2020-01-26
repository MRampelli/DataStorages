package com.android.datastorage.example;

import android.os.Bundle;
import android.util.Log;

import com.android.datastorage.example.room.User;
import com.android.datastorage.example.room.UserDao;
import com.android.datastorage.example.room.UserDatabase;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(new Runnable() {

            @Override
            public void run() {
                UserDao userDao = UserDatabase.getInstance(MainActivity.this).userDao();
                List<User> users = new ArrayList<>();

                User user = new User();
                user.uid = 1;
                user.firstName = "John";
                user.lastName = "Smith";
                users.add(user);

                User user2 = new User();
                user2.uid = 2;
                user2.firstName = "Mary";
                user2.lastName = "M";
                users.add(user2);

                userDao.insertAll(user, user2);

                Log.i("SRIB", "Data Size: " + userDao.getAllUsers().size());
            }
        }).start();
    }
}
