//package com.example.calendario;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.database.Cursor;
//import android.os.Bundle;
//import android.util.Log;
//import android.widget.ArrayAdapter;
//import android.widget.ListAdapter;
//import android.widget.ListView;
//import android.widget.Toast;
//
//import java.util.ArrayList;
//
//public class ListDataActivity extends AppCompatActivity {
//
//    private static final String TAG = "ListDataActivity";
//    DatabaseHelper databaseHelper;
//    private ListView listView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_list_data);
//
//        populateListView();
//    }
//
//    private void populateListView() {
//
//        Log.d(TAG, "PopulateListView: displaying data in the ListView");
//
//        //get data and open to a list
//        Cursor data = databaseHelper.getData();
//        ArrayList<String> listData = new ArrayList<>();
//        while (data.moveToNext()){
//            //gets value from col1 and adds it to arrayList, col0 is id
//            listData.add(data.getString(1));
//        }
//        //create the list adapter
//        ListAdapter adapter = new ArrayAdapter<>(this, R.layout.list_view_layout, listData);
//        listView.setAdapter(adapter);
//
//    }
//    //customized toast message
//    public void toastMessage(String message){
//        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
//    }
//
//}