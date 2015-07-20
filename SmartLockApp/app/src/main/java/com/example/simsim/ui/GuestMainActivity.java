package com.example.simsim.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;


public class GuestMainActivity extends FragmentActivity implements InterfaceFragmentCallBackGuest {

    public static ArrayList lockList=new ArrayList();
    //fragments
    private Fragment emptyLockListFM;
    private Fragment lockListFM;
    private Fragment eventsListFM;
    private Fragment historyListFM;
    private Fragment step1RequestAccessFM;
    private Fragment step2RequestAccessFM;

    //image view in navigation bar
    private ImageView lock_image;
    private ImageView events_image;
    private ImageView history_image;
    private ImageView personal_image;

    //fragment manager;
    private FragmentManager fmanager;
    //title bar
    private TextView titleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_main);

        fmanager=getSupportFragmentManager();
        initView();
    }

    private void initView() {
        lock_image=(ImageView)findViewById(R.id.lock_image);
        events_image=(ImageView)findViewById(R.id.events_image);
        history_image=(ImageView)findViewById(R.id.history_image);
        personal_image=(ImageView)findViewById(R.id.personal_image);
        titleBar=(TextView)findViewById(R.id.titleBar);

        //initial state of fragment
        if (GuestMainActivity.lockList.size() == 0) {
            setChoiceItem(0);
        } else {
            setChoiceItem(1);
        }

        lock_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lock_image.setImageResource(R.drawable.lock_clicked);
                if (GuestMainActivity.lockList.size() == 0) {
                    setChoiceItem(0);
                } else {
                    setChoiceItem(1);
                }
            }
        });
        events_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                events_image.setImageResource(R.drawable.events_clicked);
                setChoiceItem(2);
            }
        });
        history_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setChoiceItem(3);
            }
        });
        personal_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void setChoiceItem(int choice) {
        FragmentTransaction transaction=fmanager.beginTransaction();
        //clear choice
        clearChoice();
        //hide the fragments
        hideFragments(transaction);

        switch (choice){
            case 0:
                lock_image.setImageResource(R.drawable.lock_clicked);
                titleBar.setText("Locks");
                if(emptyLockListFM == null){
                    emptyLockListFM=new GuestMainEmptyLockFragment();
                    transaction.add(R.id.content,emptyLockListFM);
                }else{
                    transaction.show(emptyLockListFM);
                }
                break;
            case 1:
                lock_image.setImageResource(R.drawable.lock_clicked);
                titleBar.setText("Locks");
                if(lockListFM==null){
                    lockListFM=new GuestMainLockFragment();
                    transaction.add(R.id.content,lockListFM);
                }else{
                    transaction.show(lockListFM);
                }
                break;
            case 2:
                events_image.setImageResource(R.drawable.events_clicked);
                titleBar.setText("Future Events");
                if(eventsListFM==null){
                    eventsListFM=new GuestMainEventsFragment();
                    transaction.add(R.id.content, eventsListFM);
                }else{
                    transaction.show(eventsListFM);
                }
                break;
            case 3:
                history_image.setImageResource(R.drawable.history_clicked);
                titleBar.setText("History");
                if(historyListFM==null){
                    historyListFM=new GuestMainHistoryFragment();
                    transaction.add(R.id.content, historyListFM);
                }else{
                    transaction.show(historyListFM);
                }
                break;
            case 4:
                lock_image.setImageResource(R.drawable.lock_clicked);
                titleBar.setText("Request Access");
                if(step1RequestAccessFM == null){
                    step1RequestAccessFM=new GuestMainStep1RAFragment();
                    transaction.add(R.id.content, step1RequestAccessFM);
                }else{
                    transaction.show(step1RequestAccessFM);
                }
                break;
            case 5:
                lock_image.setImageResource(R.drawable.lock_clicked);
                titleBar.setText("Request Access");
                if(step2RequestAccessFM==null){
                    step2RequestAccessFM=new GuestMainStep2RAFragment();
                    transaction.add(R.id.content, step2RequestAccessFM);
                }else{
                    transaction.show(step2RequestAccessFM);
                }
                break;

        }
        transaction.commit();
    }

    //change the images in navigation bar to normal ones
    private void clearChoice() {
        lock_image.setImageResource(R.drawable.lock_normal);
        events_image.setImageResource(R.drawable.events_normal);
        history_image.setImageResource(R.drawable.history_normal);
    }

    //hide all the fragments
    private void hideFragments(FragmentTransaction transaction){
        if(lockListFM != null){
            transaction.hide(lockListFM);
        }
        if(emptyLockListFM != null){
            transaction.hide(emptyLockListFM);
        }
        if(eventsListFM != null){
            transaction.hide(eventsListFM);
        }
        if(historyListFM != null){
            transaction.hide(historyListFM);
        }
        if(step1RequestAccessFM != null){
            transaction.hide(step1RequestAccessFM);
        }
        if(step2RequestAccessFM != null){
            transaction.hide(step2RequestAccessFM);
        }
    }

    public GuestMainActivity getGuestMainActivity() {
        return this;
    }

    @Override
    public void sendSpaceID(int spaceID) {
        //start a create profile activity
        Intent intent=new Intent(GuestMainActivity.this, CreateProfileActivity.class);
        intent.putExtra("spaceid", spaceID);
        startActivity(intent);
    }
}
