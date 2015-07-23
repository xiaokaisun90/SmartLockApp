package com.example.simsim.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.simsim.interfaces.GuestLockInterface;


/**
 * Created by Steven on 15/7/18.
 */
public class GuestMainStep1RAFragment extends Fragment {

    private GuestFragmentCallBackInterface guestFragmentCallBackInterface;
    //use the guestLockInterface to call its loadHostIdFromDB(String primaryPhoneNumber) method
    //to get the  host id from database and assign the value to the static hostId in Information.
    private GuestLockInterface guestLockInterface;

    @Override
    //send phone number to GuestMainActivity.
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_guest_step1_request_access,container,false);
        Button search=(Button)view.findViewById(R.id.searchHostPhoneButton);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guestFragmentCallBackInterface.getGuestMainActivity().setChoiceItem(5);
            }
        });

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(guestFragmentCallBackInterface ==null){

            guestFragmentCallBackInterface =(GuestFragmentCallBackInterface)activity;

        }
    }
}
