package com.example.myapplication.database;

import androidx.annotation.NonNull;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;


@Dao
public interface StatusDao {

    @Query("SELECT * FROM status")
    List<Status> getAll();

    @Query("SELECT * FROM status WHERE name = :name")
    Status find(String name);

    @Insert
    void insert(Status status);

    @Update
    void update(Status status);

    @Delete
    void delete(Status status);

}
