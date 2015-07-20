package com.example.simsim.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * Created by Steven on 15/7/18.
 */
public class GuestMainEventsFragment extends Fragment {

    private InterfaceFragmentCallBackGuest interfaceFragmentCallBackGuest;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_guestmain_events,container,false);

        Button addEvent=(Button)view.findViewById(R.id.addEventButton);
        addEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(interfaceFragmentCallBackGuest.getGuestMainActivity(), GuestAddEventActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(interfaceFragmentCallBackGuest == null){
            interfaceFragmentCallBackGuest =(InterfaceFragmentCallBackGuest)activity;
        }
    }
}
