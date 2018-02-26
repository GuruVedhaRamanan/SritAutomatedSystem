package com.example.android.sritautomatedsystem;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class TutorSignIn extends AppCompatActivity {

    EditText UserId;

    EditText UserPassword;

    ProgressDialog progressDialog;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_sign_in);

        UserId = (EditText)findViewById(R.id.TutorId);

        UserPassword = (EditText)findViewById(R.id.TutorPassword);

        progressDialog = new ProgressDialog(this);
        databaseReference = FirebaseDatabase.getInstance().getReference("Tutor");

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(this.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
           Toast.makeText(this,"Connected with Internet",Toast.LENGTH_SHORT ).show();
        } else {

            Toast.makeText(this,"Please Check your Internet Connection",Toast.LENGTH_SHORT ).show();
        }
    }

    public void requests(View view)
    {
        final   String email = UserId.getText().toString();

        final String passwords = UserPassword.getText().toString();

        progressDialog.setMessage("Logging in the User");

        progressDialog.show();

        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(passwords)) {
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if (dataSnapshot.child(email).exists()) {

                        /// From database getting the  information of the User.

                        Tutor tutor = dataSnapshot.child(email).getValue(Tutor.class);

                        if (tutor.getPassword().equals(passwords) )
                        {
                            progressDialog.dismiss();
                            Toast.makeText(getApplicationContext(), "Logged  in  Successful", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(TutorSignIn.this, RequestActivity.class);
                            startActivity(intent);
                            finish();
                        } else if (!(tutor.getPassword().equals(UserPassword.getText().toString()))) {
                            progressDialog.dismiss();
                            Toast.makeText(getApplicationContext(), "Enter the Password Correctly", Toast.LENGTH_SHORT).show();
                        }

                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        } else {
            Toast.makeText(this, "Fill up all the Fields", Toast.LENGTH_LONG).show();
        }


    }

    }

