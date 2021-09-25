package com.unae.hyeyahae.data.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.unae.hyeyahae.data.model.ToDo;
import com.unae.hyeyahae.data.room.dao.ToDoDao;
import com.unae.hyeyahae.data.room.database.ToDoDB;

import java.util.List;

public class ToDoRepository {
    private ToDoDao toDoDao;
    private LiveData<List<ToDo>> allToDos;

    public ToDoRepository(Application application) {
        ToDoDB db = ToDoDB.getInstance(application);
        toDoDao = db.toDoDao();
        allToDos = toDoDao.getAllToDos();
    }

    public LiveData<List<ToDo>> getAllToDos() { return allToDos; }
    public void insert(ToDo toDo){ toDoDao.insert(toDo); }
    public void delete(ToDo toDo){ toDoDao.delete(toDo); }
}
