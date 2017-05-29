package com.amadeucavalcantefilho.todolist.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amadeucavalcantefilho.todolist.R;
import com.amadeucavalcantefilho.todolist.models.TodoItem;
import com.amadeucavalcantefilho.todolist.viewholder.TodoItemViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

/**
 * Created by amadeucavalcantefilho on 5/29/17.
 */

public abstract class TodoListFragment extends Fragment {
    private static final String TAG = "TodoListFragment";
    private DatabaseReference mDatabase;

    private FirebaseRecyclerAdapter<TodoItem, TodoItemViewHolder> mAdapter;
    private RecyclerView mRecycler;
    private LinearLayoutManager mManager;

    public TodoListFragment() {}

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_todo_list_items, container, false);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        mRecycler = (RecyclerView) rootView.findViewById(R.id.todo_items_list);
        mRecycler.setHasFixedSize(true);

        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mManager = new LinearLayoutManager(getActivity());
        mManager.setReverseLayout(true);
        mManager.setStackFromEnd(true);
        mRecycler.setLayoutManager(mManager);

        Query postsQuery = getQuery(mDatabase);
        mAdapter = new FirebaseRecyclerAdapter<TodoItem, TodoItemViewHolder>(TodoItem.class, R.layout.todo_list_item,
                TodoItemViewHolder.class, postsQuery) {
            @Override
            protected void populateViewHolder(final TodoItemViewHolder viewHolder, final TodoItem model, final int position) {
                final DatabaseReference postRef = getRef(position);

                final String postKey = postRef.getKey();

                viewHolder.bindToItem(model, new View.OnClickListener() {
                    @Override
                    public void onClick(View starView) {
                        DatabaseReference globalPostRef = mDatabase.child("todo_items").child(postRef.getKey());


                    }
                });
            }
        };
        mRecycler.setAdapter(mAdapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mAdapter != null) {
            mAdapter.cleanup();
        }
    }

    public String getUid() {
        return FirebaseAuth.getInstance().getCurrentUser().getUid();
    }

    public abstract Query getQuery(DatabaseReference databaseReference);
}
