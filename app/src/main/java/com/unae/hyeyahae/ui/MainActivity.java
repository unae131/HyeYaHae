package com.unae.hyeyahae.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.unae.hyeyahae.R;
import com.unae.hyeyahae.ToDoViewModel;
import com.unae.hyeyahae.data.model.ToDo;
import com.unae.hyeyahae.data.room.database.ToDoDB;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ToDoDB toDoDB;
    private EditText addEt;
    private Button addBtn;
    private RecyclerView rcv;

    private ToDoAdapter toDoAdapter;
    private ToDoViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addEt = findViewById(R.id.main_et_add);
        addBtn = findViewById(R.id.main_btn_add);
        rcv = findViewById(R.id.main_rcv);

        toDoDB = ToDoDB.getInstance(this);
        vm = new ViewModelProvider(this, new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                return (T) new ToDoViewModel(getApplication());
            }
        }).get(ToDoViewModel.class);

        toDoAdapter = new ToDoAdapter(vm);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        rcv.setAdapter(toDoAdapter);
        rcv.setLayoutManager(linearLayoutManager);

        vm.getAllToDos().observe(this, new Observer<List<ToDo>>() {
            @Override
            public void onChanged(List<ToDo> toDos) {
                toDoAdapter.submitList(toDos);
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vm.insert(new ToDo(addEt.getText().toString()));
                addEt.setText("");
            }
        });

    }
}