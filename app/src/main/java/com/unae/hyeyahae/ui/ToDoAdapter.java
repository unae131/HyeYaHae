package com.unae.hyeyahae.ui;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.unae.hyeyahae.R;
import com.unae.hyeyahae.ToDoViewModel;
import com.unae.hyeyahae.data.model.ToDo;

import java.util.Collections;
import java.util.List;

class ToDoAdapter extends RecyclerView.Adapter<ToDoViewHolder> {
    private List<ToDo> itemList = Collections.emptyList();
    private ToDoViewModel vm;

    public ToDoAdapter(ToDoViewModel vm){
        this.vm = vm;
    }

    public void submitList(List<ToDo> list) {
        itemList = list;
        notifyDataSetChanged();
        Log.d("submitList", list.toString());
    }

    @NonNull
    @Override
    public ToDoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.item_todo, parent, false);
        ToDoViewHolder viewHolder = new ToDoViewHolder(view, vm);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ToDoViewHolder holder, int position) {
        holder.onBind(itemList.get(position));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
