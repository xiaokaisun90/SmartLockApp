package com.example.simsim.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Steven on 15/7/18.
 */
public class GuestAddEventActivity extends Activity{

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
}
