package com.example.myapplication.database;

import androidx.annotation.NonNull;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;


@Dao
public interface PriorityDao {

    @Query("SELECT * FROM priority")
    List<Priority> getAll();

    @Query("SELECT * FROM priority WHERE name = :name")
    Priority find(String name);

    @Insert
    void insert(Priority priority);

    @Update
    void update(Priority priority);

    @Delete
    void delete(Priority priority);

}
