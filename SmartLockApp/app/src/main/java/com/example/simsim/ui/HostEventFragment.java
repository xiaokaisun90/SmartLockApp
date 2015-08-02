package com.example.simsim.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.simsim.entities.Lock;
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

    private class LockListAdapter extends ArrayAdapter<Lock> {
        public LockListAdapter(List<Lock> lockList) {
            super(getActivity(), R.layout.item_host_lock, lockList);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // if we weren't given a view, inflate one
            if (null == convertView) {
                convertView = getActivity().getLayoutInflater()
                        .inflate(R.layout.item_host_lock, null);
            }

            Lock lock = getItem(position);
            TextView textViewSidValue = (TextView)convertView.findViewById(R.id.textViewLockName);
            textViewSidValue.setText(lock.getDescription());
            return convertView;
        }
    }
}
