package com.amadeucavalcantefilho.todolist;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.amadeucavalcantefilho.todolist.fragment.NewTodoListItemActivityFragment;

public class NewTodoListItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_todo_list_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNewTodoItem();
            }
        });
    }

    void createNewTodoItem() {

        NewTodoListItemActivityFragment newTodoListItemActivityFragment =
                (NewTodoListItemActivityFragment)
                        getSupportFragmentManager().findFragmentById(R.id.new_todo_item_fragment);
        newTodoListItemActivityFragment.saveTodoListItem();
    }

}
