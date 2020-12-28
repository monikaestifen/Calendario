package com.example.calendario;

import androidx.annotation.Nullable;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity3 extends Scheme {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        table_day = "tuesday";  //FROM SCHEMAT

        databaseHelper = new DatabaseHelper(this, table_day);
        addButton = findViewById(R.id.id_button);

        setListView();

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addItem(v);

            }
        });

        setUpListViewListener();


    }




}