package com.example.simsim.ui;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.simsim.interfaces.ProfileInterface;

public class HostEditProfileFragment extends Fragment {

    private ProfileInterface profileInterface;
    private HostFragmentCallBackInterface hostFragmentCallBackInterface;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_profile, container, false);
        return view;
    }

    public void updateProfile(String userState, String dataOfBirth,
                              String gender, String emailAddress, int zipCode, String icon){

    }

    //show the profile info that is already in db.
    public void showProfile(){

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(hostFragmentCallBackInterface == null){
            hostFragmentCallBackInterface =(HostFragmentCallBackInterface)activity;
        }
    }
}
