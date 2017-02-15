package com.example.david.ejemplolistas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> items;
    private ArrayList<Todo> todoItems;
    private ArrayAdapter<String> itemsAdapter;
    private ArrayAdapter<Todo> todosAdapter;
    private ListView lvItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the list and add items
        lvItems = (ListView) findViewById(R.id.lvItems);

        // Configure normal list
        //configureStringList();

        // Configure custom list
        configureTodoList();

        setupListViewListener();
    }

    public void configureStringList(){
        items = new ArrayList<String>();
        itemsAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, items);
        lvItems.setAdapter(itemsAdapter);
        items.add("First Item");
        items.add("Second Item");

    }

    public void configureTodoList(){
        todoItems = new ArrayList<Todo>();
        todosAdapter = new TodoListAdapter(this,R.layout.item_lista_objeto,todoItems);
        lvItems.setAdapter(todosAdapter);
        todoItems.add(new Todo("Hacer mercado", "Carne, Tomates, Lechuga, Cebolla, Queso y Pan"));
        todoItems.add(new Todo("Preparpar Clase PER", "Montar el Taller de Listas"));
    }

    public void onAddItem(View v) {
        EditText etNewItem = (EditText) findViewById(R.id.etNewItem);
        String itemText = etNewItem.getText().toString();
        itemsAdapter.add(itemText);
        etNewItem.setText("");
    }

    // Attaches a long click listener to the listview
    private void setupListViewListener() {
        lvItems.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapter,
                                                   View item, int pos, long id) {
                        // Remove the item within array at position
                        items.remove(pos);
                        // Refresh the adapter
                        itemsAdapter.notifyDataSetChanged();
                        // Return true consumes the long click event (marks it handled)
                        return true;
                    }
                });
    }

}
