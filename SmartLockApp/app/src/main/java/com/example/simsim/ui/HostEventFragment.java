package com.example.simsim.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.simsim.entities.LockActivity;
import com.example.simsim.interfaces.HostEventInterface;

import java.util.List;


public class HostEventFragment extends Fragment {

    private HostFragmentCallBackInterface hostFragmentCallBackInterface;
    private HostEventInterface hostEventInterface;
    private ListView listViewEvent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_host_event, container, false);
        return view;
    }

    private List<LockActivity> getFutureLockActivity() {
        return null;
    }

    private void acceptEventRequest(LockActivity lockActivity){

    }
}
