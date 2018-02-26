package com.example.android.sritautomatedsystem;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.Random;

public class FirstScreen extends AppCompatActivity  {
    EditText FromTime;

    EditText ToTime;

    EditText  Reason;

    Calendar calendar;

    Calendar calendars;

    DatabaseReference data;

    ProgressDialog progressDialog;

    OutPass outpass;


    Random myRandom = new Random();
    // this is for User's Ouptass Id

    String UserRegistrationNumber;
//This is for storing each and every users RegisterNumber.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);

        data = FirebaseDatabase.getInstance().getReference().child("Requests");

       progressDialog = new ProgressDialog(this);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                UserRegistrationNumber= null;
            } else {
                UserRegistrationNumber= extras.getString("UserRegistrationNumber");
            }
        } else {
            UserRegistrationNumber= (String) savedInstanceState.getSerializable("UserRegistrationNumber");
        }


        FromTime = (EditText)findViewById(R.id.Fromtime);

        ToTime = (EditText)findViewById(R.id.ToTime);

        Reason = (EditText)findViewById(R.id.Reason);


        ToTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calendars = Calendar.getInstance();
                int year = calendars.get(Calendar.YEAR);
                int month =  calendars.get(Calendar.MONTH);
                final int day = calendars.get(Calendar.DAY_OF_WEEK);

                DatePickerDialog datePickerDialog = new DatePickerDialog(FirstScreen.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        ToTime.setText(dayOfMonth+"--"+month+"--"+year);


                        calendars.set(year,month,dayOfMonth);

                    }
                }, year, month, day);

                datePickerDialog.show();



            }
        });

        FromTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month =  calendar.get(Calendar.MONTH);
                final int day = calendar.get(Calendar.DAY_OF_WEEK);

                DatePickerDialog datePickerDialog = new DatePickerDialog(FirstScreen.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        FromTime.setText(dayOfMonth+"--"+month+"--"+year);


                        calendar.set(year,month,dayOfMonth);

                    }
                }, year, month, day);

                datePickerDialog.show();



            }
        });
    }
 public void requests (View view)
 {
     progressDialog.setMessage("Submitting your Request");

     progressDialog.show();

     String Id = String.valueOf(myRandom.nextInt());

     String UserRegistration = UserRegistrationNumber;

     String From = FromTime.getText().toString();

     String To = ToTime.getText().toString();

     String Reasons = Reason.getText().toString();
     if(!TextUtils.isEmpty(From)&&!TextUtils.isEmpty(To)&&!TextUtils.isEmpty(Reasons)) {

         outpass = new OutPass(Id, UserRegistration, From, To, Reasons,"Pending");

         data.child(outpass.getId()).setValue(outpass);

          progressDialog.dismiss();
         Toast.makeText(this,"Request is uploaded Successsfully",Toast.LENGTH_SHORT).show();

     }
     else {
         progressDialog.dismiss();
         Toast.makeText(this, "Enter all the fields", Toast.LENGTH_SHORT).show();

     }



 }

    }

