package com.example.aravind.android_signin;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button subt,clr;
    EditText dob,name,colg;
    public static TextView err;
    Spinner D1;
    public static String name1,colg1,bday,dept1;
    ArrayAdapter<CharSequence> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dob=(EditText)findViewById(R.id.s5);
        name=(EditText)findViewById(R.id.s3);
        colg=(EditText)findViewById(R.id.s7);
        D1 = (Spinner) findViewById(R.id.dept);
      err=(TextView)findViewById(R.id.s15);
        adapter = ArrayAdapter.createFromResource(this, R.array.Department, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        D1.setAdapter(adapter);

        final Calendar myCalendar = Calendar.getInstance();

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                String myFormat = "MM/dd/yyyy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.ENGLISH);
                dob.setText(sdf.format(myCalendar.getTime()));
            }

        };
        dob.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(MainActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        subt=(Button)findViewById(R.id.BB);
        subt.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        name1 = name.getText().toString();
                        colg1 = colg.getText().toString();
                        bday = dob.getText().toString();
                        dept1 = D1.getSelectedItem().toString();
                        if(name1.isEmpty() || colg1.isEmpty() || bday.isEmpty() || dept1.isEmpty()){
                            err.setText("ERROR: Textfield should not be empty!");
                        }
                        else {
                            Intent intent = new Intent("com.example.aravind.android_signin.Login_details");
                            startActivity(intent);
                        }
                    }
                }
        );
        clr=(Button)findViewById(R.id.s14);
        clr.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        name.setText("");
                        dob.setText("");
                        colg.setText("");
                    }
                }
        );
    }
}
