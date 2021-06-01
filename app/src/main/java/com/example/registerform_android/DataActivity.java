package com.example.registerform_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.TextView;

public class DataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        ////TextView
        TextView tvname=(TextView)findViewById(R.id.tvname);
        TextView tvemail=(TextView)findViewById(R.id.tvemail);
        TextView tvmobile=(TextView)findViewById(R.id.tvmobile);
        TextView tvgender=(TextView)findViewById(R.id.tvgender);
        TextView tvhobbie=(TextView)findViewById(R.id.tvhobbie);
        TextView tvpsw=(TextView)findViewById(R.id.tvpsw);

        ///method
        Intent intent=getIntent();
        String strname = intent.getStringExtra("Name");
        String stremail = intent.getStringExtra("Email");
        int strNumber = intent.getIntExtra("Number",0);
        String strGander = intent.getStringExtra("Gender");
        String strSpinner = intent.getStringExtra("spineer");
        int strPassword = intent.getIntExtra("Password",0);

        //tvname.setText((strname));
        tvname.setText(strname);
        tvemail.setText(stremail);
        tvmobile.setText(Integer.toString(strNumber));
        tvgender.setText(strGander);
        tvhobbie.setText(strSpinner);
        tvpsw.setText(Integer.toString(strPassword));
    }
}