package com.amadeucavalcantefilho.todolist.fragment;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.amadeucavalcantefilho.todolist.R;
import com.amadeucavalcantefilho.todolist.models.TodoItem;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;


public class NewTodoListItemActivityFragment extends Fragment {

    private DatabaseReference todoListRef;

    EditText newTodoItemTitle;
    EditText newTodoItemDetail;


    public NewTodoListItemActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_new_todo_list_item, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        newTodoItemTitle = (EditText) getActivity().findViewById(R.id.new_task_title_edit_text);
        newTodoItemDetail = (EditText) getActivity().findViewById(R.id.new_task_detail_edit_text);
        todoListRef = FirebaseDatabase.getInstance().getReference("todo_items");

    }

    public void saveTodoListItem() {
        String key = todoListRef.push().getKey();
        String title = newTodoItemTitle.getText().toString();
        String detail = newTodoItemDetail.getText().toString();
        TodoItem todoItem = new TodoItem(title, detail, "1");
        Map<String, Object> newTodoItem = new HashMap<>();
        newTodoItem.put(key, todoItem);
        todoListRef.updateChildren(newTodoItem, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError != null)
                    Log.d("DatabaseError", databaseError.toString());
            }
        });

    }
}
