package com.unae.hyeyahae;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.unae.hyeyahae.data.model.ToDo;
import com.unae.hyeyahae.data.repository.ToDoRepository;
import com.unae.hyeyahae.data.room.dao.ToDoDao;

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
        new InsertAsyncTask(repository).execute(todo);
    }

    public void delete(ToDo todo) {
        new DeleteAsyncTask(repository).execute(todo);
    }

    private static class InsertAsyncTask extends AsyncTask<ToDo, Void, Void> {
        private ToDoRepository repository;

        public InsertAsyncTask(ToDoRepository repository){
            this.repository = repository;
        }

        @Override
        protected Void doInBackground(ToDo... toDos) {
            repository.insert(toDos[0]);
            return null;
        }
    }

    private static class DeleteAsyncTask extends AsyncTask<ToDo, Void, Void> {
        private ToDoRepository repository;

        public DeleteAsyncTask(ToDoRepository repository){
            this.repository = repository;
        }

        @Override
        protected Void doInBackground(ToDo... toDos) {
            repository.delete(toDos[0]);
            return null;
        }
    }
}
