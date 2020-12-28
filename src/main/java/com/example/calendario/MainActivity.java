package com.example.calendario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.calendario.MainActivity2;
import com.example.calendario.R;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    Calendar cal = Calendar.getInstance();

    public void setDate (Button btn, int i, String day){

//        Date today = Calendar.getInstance().getTime();//getting date
//        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM");
//        String date = formatter.format(today);
//        view.setText("MON " + date);
        switch (i){
            case 1:
                cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
                break;
            case 2:
                cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
                break;
            case 3:
                cal.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
                break;
            case 4:
                cal.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
                break;
            case 5:
                cal.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
                break;
            case 6:
                cal.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
                break;
            case 7:
                cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
                break;
        }
        cal.set(Calendar.DAY_OF_WEEK, i);
        Date today = cal.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM");
        String date = formatter.format(today);
        btn.setText(day + "   " + date);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //click on the days and open new window
        Button monActivityButton = (Button) findViewById(R.id.monButton);
        setDate(monActivityButton, 2, " MON");

        monActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent monIntent = new Intent(getApplicationContext(), MainActivity2.class);
                //passing the info to another activity
                startActivity(monIntent);

            }
        });

        Button tueActivityButton = (Button) findViewById(R.id.tueButton);
        setDate(tueActivityButton, 3, " TUE");
        tueActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tueIntent = new Intent(getApplicationContext(), MainActivity3.class);
                //passing the info to another activity
                startActivity(tueIntent);
            }
        });

        Button wedActivityButton = (Button) findViewById(R.id.wedButton);
        setDate(wedActivityButton, 4, " WED");
        wedActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent wedIntent = new Intent(getApplicationContext(), MainActivity4.class);
                //
                startActivity(wedIntent);
            }
        });

        Button thuActivityButton = (Button) findViewById(R.id.thuButton);
        setDate(thuActivityButton, 5, " THU");
        thuActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent thuIntent = new Intent(getApplicationContext(), MainActivity5.class);
                //
                startActivity(thuIntent);
            }
        });

        Button friActivityButton = (Button) findViewById(R.id.friButton);
        setDate(friActivityButton, 6, " FRI");
        friActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent friIntent = new Intent(getApplicationContext(), MainActivity6.class);
                //
                startActivity(friIntent);
            }
        });

        Button satActivityButton = (Button) findViewById(R.id.satButton);
        setDate(satActivityButton, 7, " SAT");
        satActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent satIntent = new Intent(getApplicationContext(), MainActivity7.class);
                //
                startActivity(satIntent);
            }
        });

        Button sunActivityButton = (Button) findViewById(R.id.sunButton);
        setDate(sunActivityButton, 1, "SUN");
        sunActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sunIntent = new Intent(getApplicationContext(), MainActivity8.class);
                //
                startActivity(sunIntent);
            }
        });


    }
}