package com.example.simsim.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * Created by Steven on 15/7/18.
 */
public class GuestMainStep1RAFragment extends Fragment {

    private InterfaceFragmentCallBackGuest interfaceFragmentCallBackGuest;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_guest_step1_request_access,container,false);
        Button search=(Button)view.findViewById(R.id.searchHostPhoneButton);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaceFragmentCallBackGuest.getGuestMainActivity().setChoiceItem(5);
            }
        });

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(interfaceFragmentCallBackGuest ==null){

            interfaceFragmentCallBackGuest =(InterfaceFragmentCallBackGuest)activity;

        }
    }
}
