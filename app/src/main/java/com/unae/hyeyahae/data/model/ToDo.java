package com.unae.hyeyahae.data.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "todo")
public class ToDo {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String content;
    private boolean done;

    public ToDo(String content){
        this.content = content;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getContent() {
        return content;
    }

    public boolean getDone(){
        return done;
    }

    public int getId() {
        return id;
    }
}
