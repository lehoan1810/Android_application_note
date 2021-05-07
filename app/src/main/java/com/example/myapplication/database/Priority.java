package com.example.myapplication.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "priority")
public class Priority {
    @PrimaryKey
    @NonNull
    public String name;

    public String created_date;
}
