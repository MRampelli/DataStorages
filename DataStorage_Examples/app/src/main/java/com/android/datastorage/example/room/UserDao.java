package com.android.datastorage.example.room;

import android.database.Cursor;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user")
    List<User> getAllUsers();

    @Query("SELECT * FROM user WHERE uid=:id")
    User getUser(int id);

    @Query("SELECT * FROM user")
    Cursor getUserCursor();



    @Insert
    void insert(User user);

    @Insert
    void insert(User... users);

    @Insert
    void insert(List<User> repoList);


    @Update
    void update(User user);

    @Delete
    void delete(User user);






    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " + "last_name LIKE :last LIMIT 1")
    User findByName(String first, String last);

    @Insert
    void insertAll(User... users);


}
