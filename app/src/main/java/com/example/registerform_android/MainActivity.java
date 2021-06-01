package com.example.registerform_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton selectedtradioButton;
    Spinner spinner;
    ArrayAdapter<String> arrayAdapter;
    String[] hobbies = {"Music","Cricket","Badmanton"};
    String strSp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ////find ids
        EditText name =(EditText)findViewById(R.id.edt_name);
        EditText email =(EditText)findViewById(R.id.edt_email);
        EditText number =(EditText)findViewById(R.id.edt_number);
        EditText pws =(EditText)findViewById(R.id.edt_pws);
        /////spiner
         spinner = (Spinner)findViewById(R.id.selecte_spinner);
        ///btn
        Button btn_submit=(Button)findViewById(R.id.btn_submit);
        ///radio
        radioGroup = findViewById(R.id.radio_group);

       /////////////////method////////////////////////////
        ////////radio button

        ///Spinner
        arrayAdapter =new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item,hobbies);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                 strSp = adapterView.getItemAtPosition(i).toString();
                //Toast.makeText(MainActivity.this, "Selected : "+adapterView.getItemAtPosition(i), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strName= name.getText().toString();
                String strEmail= email.getText().toString();
                String strNumber=number.getText().toString();
                int mobnum = Integer.parseInt(strNumber);
                String strpws=pws.getText().toString();
                int psw = Integer.parseInt(strpws);

                selectedtradioButton = radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
                //Toast.makeText(MainActivity.this, selectedtradioButton.getText(), Toast.LENGTH_SHORT).show();


                Intent intent=new Intent(getApplicationContext(),DataActivity.class);
                intent.putExtra("Name",strName);
                intent.putExtra("Email",strEmail);
                intent.putExtra("Number",mobnum);
                intent.putExtra("Gender", selectedtradioButton.getText());
                intent.putExtra("spineer", strSp);
                intent.putExtra("Password", psw);

                startActivity(intent);

            }
        });

    }


}