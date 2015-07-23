package com.example.simsim.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class RegisterActivity extends Activity {

    Button bRegister;
    EditText etUsername, etPassword, etCountry, etPhoneNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etUsername = (EditText) findViewById(R.id.username);
        etPassword = (EditText) findViewById(R.id.password);
        etCountry = (EditText) findViewById(R.id.country);
        etPhoneNumber = (EditText) findViewById(R.id.phoneNumber);
        bRegister = (Button) findViewById(R.id.btnRegister);
        bRegister.setOnClickListener(listener);
    }

    private View.OnClickListener listener = new View.OnClickListener()
    {
        @Override
        public void onClick(View v) {
            Button btn = (Button)v;
            switch (btn.getId())
            {
                case R.id.btnRegister:
                    buttonClickHandlerRegister();
                    break;
                default:
                    break;
            }
        }
    };

    private void buttonClickHandlerRegister(){
        Intent intent = new Intent();
        intent.setClass(RegisterActivity.this, VerificationActivity.class);
        startActivity(intent);
    }


    // Request server send an SMS message
    public void getVerificationCode(String primaryPhoneNumber){

    }



//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.btnRegister:
//                break;
//        }
//    }
}
