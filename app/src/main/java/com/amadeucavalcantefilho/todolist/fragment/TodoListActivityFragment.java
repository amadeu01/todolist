package com.amadeucavalcantefilho.todolist.fragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;


public class TodoListActivityFragment extends TodoListFragment {

    private static final String TAG = "TodoListActivityFragment";


    public TodoListActivityFragment() {}

    @Override
    public Query getQuery(DatabaseReference databaseReference) {
        Query recentTodoItemsQuery = databaseReference.child("todo_items")
                .limitToFirst(100);
        return recentTodoItemsQuery;
    }

}
