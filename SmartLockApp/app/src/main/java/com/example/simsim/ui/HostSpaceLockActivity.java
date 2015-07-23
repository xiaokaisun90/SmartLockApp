package com.example.simsim.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.simsim.entities.Lock;
import com.example.simsim.entities.Property;
import com.example.simsim.interfaces.HostSpaceInterface;

import java.util.List;

public class HostSpaceLockActivity extends Activity {

    private HostFragmentCallBackInterface hostFragmentCallBackInterface;
    private HostSpaceInterface hostSpaceInterface;
    private ListView listViewSpaceLock;
    private Property property;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host_space_lock);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_host_space_lock, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private List<Lock> getLockList(Property property){
        return null;
    }
}
