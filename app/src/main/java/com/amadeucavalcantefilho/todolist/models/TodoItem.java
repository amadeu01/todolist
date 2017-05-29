package com.amadeucavalcantefilho.todolist.models;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by amadeucavalcantefilho on 5/20/17.
 */

@IgnoreExtraProperties
public class TodoItem {

    private String uid;
    private String title;
    private String detail;
    private boolean done = false;

    public TodoItem() {}

    public TodoItem(String title, String detail, String uid) {
        this.title = title;
        this.detail = detail;
        this.uid = uid;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("uid", uid);
        hashMap.put("title", title);
        hashMap.put("detail", detail);

        return hashMap;
    }
}
