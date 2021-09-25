package com.unae.hyeyahae.data.room.database;

import android.content.Context;
import android.content.Entity;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.unae.hyeyahae.data.model.ToDo;
import com.unae.hyeyahae.data.room.dao.ToDoDao;

@Database(entities = {ToDo.class}, version = 1, exportSchema = false)
public abstract class ToDoDB extends RoomDatabase {

    private static ToDoDB instance = null;
    public abstract ToDoDao toDoDao();

    public static ToDoDB getInstance(final Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    ToDoDB.class, "todo.db").build();
        }
        return instance;
    }

}
