package com.example.simsim.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HostLockFragment extends Fragment {

    private Button buttonAddLock;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_host_lock,container,false);
        buttonAddLock = (Button)view.findViewById(R.id.buttonAddLock);
        buttonAddLock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("fragment", "event");
                intent.setClass(getActivity(), HostLockSettingsActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

}
