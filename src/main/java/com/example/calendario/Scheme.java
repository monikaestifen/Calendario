package com.example.calendario;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Calendar;

import javax.crypto.Cipher;


public class Scheme extends AppCompatActivity{

    public ArrayList<String> items;
    public ArrayAdapter<String> itemsAdapter;
    public ListView listView;
    public Button addButton;
    public String table_day;
    public EditText input;


    DatabaseHelper databaseHelper;
//    DeleteMessage del = new DeleteMessage();

    //remove task
    public void setUpListViewListener() {

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                //position	int: The position of the view in the list
//                del.show()


                Context context = getApplicationContext();

//                openDialog(context);



                Toast.makeText(context, "Item removed", Toast.LENGTH_LONG).show();
                //databaseHelper.removeItem(items.get(position));

                Log.d("mes", items.get(position));

                items.remove(position);
                itemsAdapter.notifyDataSetChanged();

                return true;
            }
        });
    }

    private void openDialog(Context context) {
//        Dialog dialog = new Dialog();
//        dialog.show(getSupportFragmentManager(), "Delete");
        AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
        builder1.setMessage("Do you want to delete task?");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        builder1.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();

    }

    public static boolean isStringAllWhiteSpace(String str) {
        // Remove the leading whitespaces using trim()
        // and then check if this string is empty
        if (str.trim().isEmpty())
            return true;
        else
            return false;
    }


    public void addItem(View v) {

        String itemText = input.getText().toString();

        if(!(isStringAllWhiteSpace(itemText))){

            itemsAdapter.add(itemText);
            itemsAdapter.notifyDataSetChanged();
            AddData(itemText);
            input.setText("");

        }else{
            Toast.makeText(getApplicationContext(), "Enter something", Toast.LENGTH_LONG).show();
        }

        if (itemsAdapter.getCount() == 0){ //pojawia mi sie zawartosc bazy danych po wroceniu do danego dnia
            viewData();
        }

    }


    public void setListView() {

        listView = findViewById(R.id.id_list_view);
        input = findViewById(R.id.id_edit_text);
        items = new ArrayList<>();
        itemsAdapter = new ArrayAdapter<>(this, R.layout.list_view_layout, items);
        listView.setAdapter(itemsAdapter);

        if (itemsAdapter.getCount() == 0){ //pojawia mi sie zawartosc bazy danych po wroceniu do danego dnia
            viewData();
        }
    }


    //adds item to database
    public void AddData(String newEntry) {

        boolean insertData = databaseHelper.addData(newEntry, table_day);

        if (insertData) {
            toastMessage("Data Successfully Inserted!");
        } else {
            toastMessage("Something went wrong");
        }
    }

    public void viewData(){

        Cursor cursor = databaseHelper.getData(table_day);

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
