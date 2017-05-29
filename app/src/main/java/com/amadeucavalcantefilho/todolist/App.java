package com.amadeucavalcantefilho.todolist;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by amadeucavalcantefilho on 5/20/17.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}
