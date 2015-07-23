package com.example.simsim.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.simsim.entities.Lock;
import com.example.simsim.interfaces.HostLockInterface;

import java.util.List;

public class HostLockFragment extends Fragment {

    private HostFragmentCallBackInterface hostFragmentCallBackInterface;
    private HostLockInterface hostLockInterface;
    private ListView listViewLock;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_host_lock,container,false);
        return view;
    }

    private List<Lock> getLockList(){
        return null;
    }

}
