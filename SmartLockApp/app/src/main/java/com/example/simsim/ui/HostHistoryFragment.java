package com.example.simsim.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.simsim.entities.LockActivity;
import com.example.simsim.interfaces.HistoryInterface;

import java.util.List;

public class HostHistoryFragment extends Fragment {

    private HostFragmentCallBackInterface hostFragmentCallBackInterface;
    private HistoryInterface historyInterface;
    private ListView listViewHistory;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_host_history, container, false);
        return view;
    }

    private List<LockActivity> getHistoryLockActivity() {
        return null;
    }
}
