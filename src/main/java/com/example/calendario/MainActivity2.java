package com.example.calendario;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class MainActivity2 extends AppCompatActivity {

    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;
    private ListView listView;
    private Button addButton;

    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

//
        listView = findViewById(R.id.id_list_view);
        addButton = findViewById(R.id.id_button);

        databaseHelper = new DatabaseHelper(this, "monday");

        items = new ArrayList<>();

        itemsAdapter = new ArrayAdapter<>(this, R.layout.list_view_layout, items);
        listView.setAdapter(itemsAdapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem(v);
            }
        });

        if (itemsAdapter.getCount() == 0){
            viewData();
        }

        setUpListViewListener();

    }

    //remove task
    private void setUpListViewListener() {

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                //position	int: The position of the view in the list

                Context context = getApplicationContext();
                Toast.makeText(context, "Item removed", Toast.LENGTH_LONG).show();
                databaseHelper.removeItem(items.get(position), "monday");

                Log.d("mes", items.get(position));

                items.remove(position);
                itemsAdapter.notifyDataSetChanged();

                return true;
            }
        });
    }

    public static boolean isStringAllWhiteSpace(String str) {
        // Remove the leading whitespaces using trim()
        // and then check if this string is empty
        if (str.trim().isEmpty())
            return true;
        else
            return false;
    }

    private void addItem(View v) {

        EditText input = findViewById(R.id.id_edit_text);
        String itemText = input.getText().toString();

        if(!(isStringAllWhiteSpace(itemText))){

            itemsAdapter.add(itemText);
            AddData(itemText);
            input.setText("");

        }else{
            Toast.makeText(getApplicationContext(), "Enter something", Toast.LENGTH_LONG).show();
        }
    }

    //adds item to database
    public void AddData(String newEntry) {

        boolean insertData = databaseHelper.addData(newEntry, "monday");

        if (insertData) {
            toastMessage("Data Successfully Inserted!");
        } else {
            toastMessage("Something went wrong");
        }
    }

    private void viewData(){

        Cursor cursor = databaseHelper.getData("monday");

        if(cursor.getCount() == 0){
            toastMessage("No data to show");
        }else{
            while (cursor.moveToNext()){
                items.add(cursor.getString(1));
            }
        }
    }

    //customized toast message
    public void toastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}