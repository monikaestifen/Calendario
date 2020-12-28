package com.example.calendario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity5 extends Scheme {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        table_day = "thursday";  //FROM SCHEMAT

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