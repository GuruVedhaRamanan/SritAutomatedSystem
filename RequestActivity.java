package com.example.android.sritautomatedsystem;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class RequestActivity extends AppCompatActivity {
    ListView lists;

    TextView alert;

    ArrayList<OutPass> arrayList;

    ProgressDialog progressDialog;

    DatabaseReference data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        data = FirebaseDatabase.getInstance().getReference().child("Requests");

        lists = (ListView)findViewById(R.id.Requests);

        progressDialog = new ProgressDialog(this);

        alert  = (TextView)findViewById(R.id.nodonors);
        arrayList = new ArrayList<>();

        progressDialog.setMessage("Receiving the data");
        progressDialog.show();
        if(arrayList.isEmpty())
        {
            progressDialog.dismiss();
            alert.setVisibility(View.VISIBLE);
        }


    }
    public void onStart() {
        super.onStart();

        data.addValueEventListener(new ValueEventListener() {


            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                arrayList.clear();
                for (DataSnapshot usersnapshot : dataSnapshot.getChildren()) {
                    OutPass user = usersnapshot.getValue(OutPass.class);

                        progressDialog.dismiss();
                        alert.setVisibility(View.INVISIBLE);

                        arrayList.add(user);

                }

                RequestAdapter adapter = new RequestAdapter(RequestActivity.this, arrayList);
                lists.setAdapter(adapter);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        lists.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                OutPass  userInformation = arrayList.get(position);
                userInformation.setAcceptance("Accepted by tutor");
            }
        });


    }



}
