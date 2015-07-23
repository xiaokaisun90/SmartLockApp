package com.example.simsim.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.simsim.entities.Lock;
import com.example.simsim.entities.Property;
import com.example.simsim.interfaces.HostSpaceInterface;

public class HostLockSettingsActivity extends Activity {

    private HostFragmentCallBackInterface hostFragmentCallBackInterface;
    private HostSpaceInterface hostSpaceInterface;
    private boolean isNew;
    private Property property;

    private Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host_lock_settings);
        buttonSave = (Button)findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HostLockSettingsActivity.this, "Lock saved.", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_host_lock_settings, menu);
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

    public void insertLock(Property property, Lock lock){

    }

    public void updateLock(Property property, Lock lock){

    }

    public void deleteLock(Property property, Lock lock){

    }

}
