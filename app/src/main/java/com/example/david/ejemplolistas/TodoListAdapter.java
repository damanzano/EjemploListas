package com.example.david.ejemplolistas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by David on 15/02/2017.
 */
public class TodoListAdapter extends ArrayAdapter<Todo> {


    public TodoListAdapter(Context context, int resource, List<Todo> objects) {
        super(context, resource, objects);
    }

    public View getView(int position, View view, ViewGroup parent) {
        TextView title = (TextView) view.findViewById(R.id.todoTitle);
        TextView description = (TextView) view.findViewById(R.id.todoDescription);
        CheckBox completed = (CheckBox) view.findViewById(R.id.todoCompleted);

        title.setText(getItem(position).getTitle());
        description.setText(getItem(position).getDescription());
        completed.setChecked(getItem(position).isCompleted());

        return view;
    }
}
