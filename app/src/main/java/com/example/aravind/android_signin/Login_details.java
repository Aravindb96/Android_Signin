package com.example.aravind.android_signin;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Login_details extends AppCompatActivity {
     StringBuffer str;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_details);
        MainActivity.err.setText("");
        StringBuilder str= new StringBuilder();
        str.append("\n").append("Name: ").append(MainActivity.name1).append("\n").append("\n").append("DOB: ").append(MainActivity.bday).append("\n").append("\n").append("College: ").append(MainActivity.colg1).append("\n").append("\n").append("Dept: ").append(MainActivity.dept1);
        tv=(TextView)findViewById(R.id.result);
        tv.setText(str.toString());

    }

}
