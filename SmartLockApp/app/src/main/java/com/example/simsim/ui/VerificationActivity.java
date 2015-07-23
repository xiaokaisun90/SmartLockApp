package com.example.simsim.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.simsim.interfaces.RegistrationInterface;


public class VerificationActivity extends Activity {

    private RegistrationInterface registrationInterface;

    private Button btnConfirm;

    //Verify code, insert User to DB, set userId to User object in Information.
    // If successful, return true.
    public boolean sendVerificationCode(String verificationCode){

        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);

        btnConfirm = (Button) findViewById(R.id.confirm);
        btnConfirm.setOnClickListener(listener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my_space, menu);
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

    private View.OnClickListener listener = new View.OnClickListener()
    {
        @Override
        public void onClick(View v) {
            Button btn = (Button)v;
            switch (btn.getId())
            {
                case R.id.confirm:
                    buttonClickHandlerConfirm();
                    break;
                default:
                    break;
            }
        }
    };

    private void buttonClickHandlerConfirm(){
        Intent intent = new Intent();
        intent.setClass(VerificationActivity.this, GuestMainActivity.class);
        startActivity(intent);
    }
}
