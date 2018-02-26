package com.example.android.sritautomatedsystem;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registration extends AppCompatActivity {

    EditText Username, RegisterNumber, RoomNumber, Mail_id, password;

    Spinner Year, Department, Block, Floor;

    DatabaseReference data;

    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Username = (EditText) findViewById(R.id.username);

        RegisterNumber = (EditText) findViewById(R.id.Register);

        RoomNumber = (EditText) findViewById(R.id.RoomNumber);

        Mail_id = (EditText) findViewById(R.id.mailid);

        password = (EditText) findViewById(R.id.userPassword);

        Year = (Spinner) findViewById(R.id.fields);

        Department = (Spinner) findViewById(R.id.Departments);

        Block = (Spinner) findViewById(R.id.Blocks);

        Floor = (Spinner) findViewById(R.id.Floor);

        progressDialog = new ProgressDialog(this);


        data = FirebaseDatabase.getInstance().getReference().child("Users");


    }

    public void register(View view)
    {
        progressDialog.setMessage("Saving your details");

        progressDialog.show();

         String Usernames = Username.getText().toString();

        String Academic_Year = Year.getSelectedItem().toString();

        String StudentDepartment = Department.getSelectedItem().toString();

        final String Register = RegisterNumber.getText().toString();

        String StudentBlock = Block.getSelectedItem().toString();

        String StudentFloor = Floor.getSelectedItem().toString();

        String RoomNumbers = RoomNumber.getText().toString();

        String Mail = Mail_id.getText().toString();

        String passwords = password.getText().toString();

        User user = new User(Usernames, Academic_Year, StudentDepartment, Register, StudentBlock, RoomNumbers, StudentFloor, Mail, passwords);

        data.child(user.getRegisterNumber()).setValue(user, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if(databaseError == null)
                {
                    progressDialog.dismiss();
                    Toast.makeText(getApplicationContext(),"Registration is completed Successfully",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),FirstScreen.class);
                    startActivity(intent);

                }
                else
                {
                    progressDialog.dismiss();
                    Toast.makeText(getApplicationContext(),"Check your Internet Connection",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}