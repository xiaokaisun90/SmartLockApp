package com.example.simsim.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.simsim.entities.Lock;

import java.util.List;


/**
 * Created by Steven on 15/7/18.
 */
public class GuestMainLockFragment extends Fragment {

    private GuestFragmentCallBackInterface guestFragmentCallBackInterface;
    private Lock lock;//the lock that the user clicked and wanted open or lock.

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_guestmain_lock,container,false);


        return view;
    }


    public void onAttach(Activity activity){

    }

    // get all of the available locks for the guest, which are permitted by the host and confirmed by this guest.
    public List<Lock> getLockList(){

        return null;
    }

    public  boolean openLock(Lock lock){

        return false;
    }

    public boolean closeLock(Lock lock){
        return false;
    }
}
