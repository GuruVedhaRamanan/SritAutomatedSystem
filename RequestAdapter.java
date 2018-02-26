package com.example.android.sritautomatedsystem;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


public class RequestAdapter extends ArrayAdapter<OutPass> implements View.OnClickListener
{
    private Activity context;

    private List<OutPass> userList;

    TextView approval;



    public RequestAdapter(Activity context, List<OutPass> userList) {
        super(context, R.layout.userrequests, userList);
        this.context = context;
        this.userList = userList;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();

        View view = inflater.inflate(R.layout.userrequests, null, true);



        OutPass user   = getItem(position);

        TextView Name = (TextView)view.findViewById(R.id.UserName);



        Name.setText(user.getId());

        TextView Register = (TextView)view.findViewById(R.id.Register);

        Register.setText(user.getRegister());

        TextView fromtime = (TextView)view.findViewById(R.id.Fromtime);

        fromtime.setText(user.getFromDate());

        TextView totime = (TextView)view.findViewById(R.id.ToTime);

        totime.setText(user.getToDate());

        TextView Reasons = (TextView) view.findViewById(R.id.Reason);

        Reasons.setText(user.getReason());

           approval = (TextView)view.findViewById(R.id.Approval);




        return view;

    }


    @Override
    public void onClick(View v) {
        if( v == approval)
        {
            approval.setText("The outpass is approved");
        }

    }
}







