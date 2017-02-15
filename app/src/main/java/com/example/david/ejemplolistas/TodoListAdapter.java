package com.example.david.ejemplolistas;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

/**
 * Created by David on 15/02/2017.
 */
public class TodoListAdapter extends ArrayAdapter<Todo> {
    private int layoutid;

    public TodoListAdapter(Context context, int resource, List<Todo> objects) {
        super(context, resource, objects);
        layoutid = resource;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        LayoutInflater inflater = ((Activity)this.getContext()).getLayoutInflater();
        view = inflater.inflate(this.layoutid, null, true);

        TextView title = (TextView) view.findViewById(R.id.todoTitle);
        TextView description = (TextView) view.findViewById(R.id.todoDescription);
        final CheckBox completed = (CheckBox) view.findViewById(R.id.todoCompleted);

        title.setText(getItem(position).getTitle());
        description.setText(getItem(position).getDescription());
        completed.setChecked(getItem(position).isCompleted());

        completed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(completed.isChecked()){
                    getItem(position).setCompleted(true);
                }else{
                    getItem(position).setCompleted(true);
                }
            }
        });

        return view;
    }
}
