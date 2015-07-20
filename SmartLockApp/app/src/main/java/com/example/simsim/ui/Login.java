package com.example.simsim.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.*;


public class Login extends Activity {

    private final int COLOR_ORANGE = 0xFFFF9900;
    private final int COLOR_BLACK = 0xFF000000;
    private Button bLogin;
    private TextView bRegister;
    private Button buttonGuest;
    private Button buttonHost;

    private boolean isHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        isHost = true;

        buttonHost = (Button)findViewById(R.id.host);
        buttonGuest = (Button)findViewById(R.id.guest);
        bLogin = (Button) findViewById(R.id.btnLogin);
        bRegister = (TextView) findViewById(R.id.link_to_register);
        buttonHost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isHost = true;
                buttonHost.setTextColor(COLOR_ORANGE);
                buttonGuest.setTextColor(COLOR_BLACK);
            }
        });
        buttonGuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isHost = false;
                buttonGuest.setTextColor(COLOR_ORANGE);
                buttonHost.setTextColor(COLOR_BLACK);
            }
        });
        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                if(isHost == true){
                    intent.setClass(Login.this, HostMainActivityInterface.class);
                }
                else{
                    intent.setClass(Login.this, GuestMainActivity.class);
                }
                startActivity(intent);
            }
        });
        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Login.this, Register.class);
                startActivity(intent);
            }
        });
    }
    private View.OnClickListener listener = new View.OnClickListener()
    {
        @Override
        public void onClick(View v) {
            Button btn = (Button)v;
            switch (btn.getId())
            {
                case R.id.btnLogin:
                    buttonClickHandlerLogin();
                    break;
                case R.id.link_to_register:
                    buttonClickHandlerRegister();
                    break;
                default:
                    break;
            }
        }
    };

    private void buttonClickHandlerLogin(){

    }

    private void buttonClickHandlerRegister(){

    }

}
