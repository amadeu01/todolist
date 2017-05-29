package com.amadeucavalcantefilho.todolist.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.amadeucavalcantefilho.todolist.R;
import com.amadeucavalcantefilho.todolist.models.TodoItem;

/**
 * Created by amadeucavalcantefilho on 5/20/17.
 */

public class TodoItemViewHolder extends RecyclerView.ViewHolder {

    public TextView todoItemTitleTextView;
    public CheckBox todoItemCheckBox;

    public TodoItemViewHolder(View itemView) {
        super(itemView);
        this.todoItemTitleTextView = (TextView) itemView.findViewById(R.id.item_title);
        this.todoItemCheckBox = (CheckBox) itemView.findViewById(R.id.item_checkbox);
    }

    public void bindToItem(TodoItem todoItem, CheckBox.OnClickListener checkBoxclickListener) {
        todoItemTitleTextView.setText(todoItem.getTitle());
        todoItemCheckBox.setOnClickListener(checkBoxclickListener);
    }

}
