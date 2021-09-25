package com.unae.hyeyahae.data.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.unae.hyeyahae.data.model.ToDo;

import java.util.List;

@Dao
public interface ToDoDao {
    @Query("SELECT * FROM todo")
    LiveData<List<ToDo>> getAllToDos();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(ToDo todo);

    @Delete
    void delete(ToDo todo);
}
