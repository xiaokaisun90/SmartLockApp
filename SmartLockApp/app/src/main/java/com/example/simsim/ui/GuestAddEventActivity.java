package com.example.simsim.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.simsim.interfaces.GuestEventInterface;

/**
 * Created by Steven on 15/7/18.
 */
public class GuestAddEventActivity extends Activity{

    private GuestEventInterface guestEventInterface;

    private TextView repeatTV;
    private TextView endRepeatTV;
    private TextView alertTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_add_event);

        repeatTV=(TextView)findViewById(R.id.repeatTV);
        endRepeatTV=(TextView)findViewById(R.id.endRepeatTV);
        alertTV=(TextView)findViewById(R.id.alertTV);

        repeatTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GuestAddEventActivity.this, GuestRepeatActivity.class);
                startActivity(intent);
            }
        });

        endRepeatTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GuestAddEventActivity.this, GuestEndRepeatActivity.class);
                startActivity(intent);
            }
        });
        alertTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GuestAddEventActivity.this, GuestAlertActivity.class);
                startActivity(intent);
            }
        });

    }

    public void setNewLockActivityAccessStartTime(String accessStartTime){

    }
    public void setNewLockActivityAccessEndTime(String accessEndTime){

    }
    public void setNewLockActivityRequestAccessTimestamp(String requestAccessTimestamp){

    }
    public void setNewLockActivityRequestStatus(boolean requestStatus){

    }
    public void setNewLockActivityAlert(int alert){

    }
    // Insert new lockActivity to DB, set lockActivityId to LockActivity object in Information.
    public void insertNewLockActivity(){

    }
}
