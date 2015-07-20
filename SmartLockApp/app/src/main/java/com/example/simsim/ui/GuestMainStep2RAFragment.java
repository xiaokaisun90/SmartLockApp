package com.example.simsim.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Steven on 15/7/18.
 */
public class GuestMainStep2RAFragment extends Fragment {

    private InterfaceFragmentCallBackGuest interfaceFragmentCallBackGuest;

    //examples of spaces images
    int images[]={R.drawable.example1, R.drawable.example2};
    String names[]={"Park's Home","Project Olympus"};
    ArrayList<Map<String, Object>> spaces;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_guest_step2_request_access,container,false);

        GridView gridOfSpaces=(GridView)view.findViewById(R.id.gridOfSpaces);
        spaces=new ArrayList<Map<String, Object>>();

        for(int i=0;i<images.length;i++){

            Map<String,Object> map=new HashMap<String, Object>();
            map.put("images", images[i]);
            map.put("text", names[i]);
            spaces.add(map);

        }

        SimpleAdapter adapter=new SimpleAdapter(interfaceFragmentCallBackGuest.getGuestMainActivity()
                ,spaces,R.layout.item_guest_spaces,new String[]{"images","text"}, new int[]{R.id.showSpaceIV,R.id.showSpaceTV});
        gridOfSpaces.setAdapter(adapter);
        gridOfSpaces.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                interfaceFragmentCallBackGuest.getGuestMainActivity().sendSpaceID(position);
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
