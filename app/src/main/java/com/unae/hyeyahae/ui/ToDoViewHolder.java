package com.unae.hyeyahae.ui;

import android.view.View;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.unae.hyeyahae.R;
import com.unae.hyeyahae.ToDoViewModel;
import com.unae.hyeyahae.data.model.ToDo;

class ToDoViewHolder extends RecyclerView.ViewHolder {
    private CheckBox checkBox;
    private ToDoViewModel vm;

    public ToDoViewHolder(@NonNull View itemView, ToDoViewModel vm) {
        super(itemView);

        checkBox = itemView.findViewById(R.id.item_checkbox);
        this.vm = vm;
    }

    public void onBind(ToDo todo){
        checkBox.setChecked(todo.getDone());
        checkBox.setText(todo.getContent());

        checkBox.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if (checkBox.isChecked()){
                    vm.delete(todo);
                }
            }
        });
    }
}
