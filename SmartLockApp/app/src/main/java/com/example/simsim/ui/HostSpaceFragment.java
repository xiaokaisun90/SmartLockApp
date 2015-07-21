package com.example.simsim.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class HostSpaceFragment extends Fragment {

    private Button buttonAddSpace;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_host_space,container,false);
        buttonAddSpace = (Button)view.findViewById(R.id.buttonAddSpace);
        buttonAddSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(),HostSpaceDetailActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}