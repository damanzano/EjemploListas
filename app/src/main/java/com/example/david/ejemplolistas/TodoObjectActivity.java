package com.example.david.ejemplolistas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class TodoObjectActivity extends AppCompatActivity {
    private ArrayList<Todo> todoItems;
    private ArrayAdapter<Todo> todosAdapter;
    private ListView lvItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_object);

        // Get the list
        lvItems = (ListView) findViewById(R.id.lvItems);

        // Configure custom list
        configureTodoList();

        // Configure list listener
        setupListViewListener();
    }

    public void onAddTodo(View v) {
        EditText title = (EditText) findViewById(R.id.title);
        EditText description = (EditText) findViewById(R.id.description);

        String todoTitle = title.getText().toString();
        String todoDescription = description.getText().toString();
        Todo todo = new Todo(todoTitle,todoDescription);

        todosAdapter.add(todo);
        title.setText("");
        description.setText("");
    }

    public void configureTodoList(){
        todoItems = new ArrayList<Todo>();
        todosAdapter = new TodoListAdapter(this,R.layout.item_lista_objeto,todoItems);
        lvItems.setAdapter(todosAdapter);
        todoItems.add(new Todo("Hacer mercado", "Carne, Tomates, Lechuga, Cebolla, Queso y Pan"));
        todoItems.add(new Todo("Preparpar Clase PER", "Montar el Taller de Listas"));
    }

    // Attaches a long click listener to the listview
    private void setupListViewListener() {
        lvItems.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapter,
                                                   View item, int pos, long id) {
                        // Remove the item within array at position
                        todoItems.remove(pos);
                        // Refresh the adapter
                        todosAdapter.notifyDataSetChanged();
                        // Return true consumes the long click event (marks it handled)
                        return true;
                    }
                });
    }
}
