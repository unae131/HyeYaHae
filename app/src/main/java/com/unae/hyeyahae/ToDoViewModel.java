package com.unae.hyeyahae;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.unae.hyeyahae.data.model.ToDo;
import com.unae.hyeyahae.data.repository.ToDoRepository;

import java.util.List;

public class ToDoViewModel extends AndroidViewModel {
    private ToDoRepository repository;
    LiveData<List<ToDo>> todos;

    public ToDoViewModel(Application application){
        super(application);
        repository = new ToDoRepository(application);
        todos = repository.getAllToDos();
    }

    public LiveData<List<ToDo>> getAllToDos() {
        return todos;
    }

    public void insert(ToDo todo){
        repository.insert(todo);
    }

    public void delete(ToDo todo) { repository.delete(todo);}
}
