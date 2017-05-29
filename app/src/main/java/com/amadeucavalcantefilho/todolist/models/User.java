package com.amadeucavalcantefilho.todolist.models;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by amadeucavalcantefilho on 5/20/17.
 */

@IgnoreExtraProperties
public class User {
    public String username;
    public String email;

    public User() {
    }

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }
}
