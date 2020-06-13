package com.example.pickers;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;

import android.app.TimePickerDialog;
import android.content.DialogInterface;

import android.icu.util.TimeZone;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.app.DatePickerDialog;
import android.widget.TimePicker;

import java.time.Year;
import java.util.Calendar;
import java.util.Timer;
import java.util.concurrent.Callable;

public class MainActivity extends AppCompatActivity {

    int y, m, d;
    int h,min;
    TextView tv;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv=findViewById(R.id.tv);
        tv1=findViewById(R.id.tv1);

    }

    public void getalert(View view) {

        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setTitle("Alert");
        b.setMessage("DO U WANT CLIOSE THE APP");
        b.setIcon(R.drawable.alert);
        b.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                finish();

            }
        });
        b.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        b.show();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)

    public <y> void getdate(View view) {

        Calendar c = Calendar.getInstance();
        y = c.get(Calendar.YEAR);
        m = c.get(Calendar.MONTH);
        d = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog a = new DatePickerDialog(MainActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int i, int i1, int i2) {
                        tv.setText("" + i2 + "-" + (i1 + 1) + "-" + i);
                    }
                }, y, m, d);
        a.show();
    }


    public void gettime(View view)
    {
        Calendar c=Calendar.getInstance();
        h=c.get(Calendar.HOUR);
        min=c.get(Calendar.MINUTE);

        TimePickerDialog tp=new TimePickerDialog(MainActivity.this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        tv1.setText(hourOfDay+":"+minute);
                    }
                },h,min,false);
        tp.show();

    }
}
