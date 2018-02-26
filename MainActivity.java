package com.example.android.sritautomatedsystem;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

public class MainActivity extends AppCompatActivity {
    MaterialEditText registerNUmber;
    MaterialEditText password;
    DatabaseReference databaseReference;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerNUmber = (MaterialEditText) findViewById(R.id.userNo);

        password = (MaterialEditText) findViewById(R.id.userPassword);

        View view = (View) findViewById(R.id.view);


        progressDialog = new ProgressDialog(this);

        databaseReference = FirebaseDatabase.getInstance().getReference("Users");

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(this.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            Snackbar.make(view, "Connected with Internet", 2000).show();
        } else {
            Snackbar.make(view, "Check your Internet Connection", 10000).show();

        }
    }

    public void newuser(View view) {

        Intent intent = new Intent(this, Registration.class);
        startActivity(intent);
    }

    public void request(View view) {

     final   String email = registerNUmber.getText().toString();

        final String passwords =    password.getText().toString();

        progressDialog.setMessage("Logging in the User");

        progressDialog.show();

        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(passwords)) {
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if (dataSnapshot.child(email).exists()) {

                        /// From database getting the  information of the User.

                        User user = dataSnapshot.child(email).getValue(User.class);

                        if (user.getPassword().equals(passwords) )
                        {
                            progressDialog.dismiss();
                            Toast.makeText(getApplicationContext(), "Logged  in  Successful", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(MainActivity.this, FirstScreen.class);
                            intent.putExtra("UserRegistrationNumber",email);
                            startActivity(intent);
                            finish();
                        } else if (!(user.getPassword().equals(password.getText().toString()))) {
                            progressDialog.dismiss();
                            Toast.makeText(getApplicationContext(), "Enter the Password Correctly", Toast.LENGTH_SHORT).show();
                        }

                    } else
                        {
                            progressDialog.dismiss();

                            Toast.makeText(getApplicationContext(), "Please Register your I.D ", Toast.LENGTH_SHORT).show();
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

    public void TutorScreen(View view) {
        Intent intent = new Intent(this, TutorSignIn.class);
        startActivity(intent);

    }

    public void WardenScreen(View view) {
        Intent intent = new Intent(this, WardenSignIn.class);
        startActivity(intent);

    }

}






