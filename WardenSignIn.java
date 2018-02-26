package com.example.android.sritautomatedsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class WardenSignIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warden_sign_in);
    }
    public void requests(View view)
    {
        Intent intent = new Intent (this,RequestActivity.class);
        finish();
        startActivity(intent);
    }
}
