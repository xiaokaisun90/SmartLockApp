package com.example.simsim.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

import com.example.simsim.entities.EntityAdapter;
import com.example.simsim.interfaces.AuthenticationInterface;


public class LoginActivity extends Activity {

    private final String LOGIN_FAILED_MESSAGE =
            "Login failed. Please check your number and password";

    private AuthenticationInterface authenticationInterface;

    private EditText editTextPhoneNumber;
    private EditText editTextPassword;
    private Button buttonLogin;
    private TextView buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        authenticationInterface = new EntityAdapter();

        editTextPhoneNumber = (EditText) findViewById(R.id.editTextPhoneNumber);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        buttonLogin = (Button) findViewById(R.id.btnLogin);
        buttonRegister = (TextView) findViewById(R.id.link_to_register);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String primaryPhoneNumber = editTextPhoneNumber.getText().toString();
                String password = editTextPassword.getText().toString();
                if(authenticate(primaryPhoneNumber, password) == true){
                    authenticationInterface.loadDataFromDB(primaryPhoneNumber);
                    Intent intent = new Intent();
                    if(authenticationInterface.getUserState().equals("host")){
                        intent.setClass(LoginActivity.this, HostMainActivity.class);
                    }
                    else{
                        intent.setClass(LoginActivity.this, GuestMainActivity.class);
                    }
                    startActivity(intent);
                }
                else{
                    Toast.makeText(LoginActivity.this, LOGIN_FAILED_MESSAGE,
                            Toast.LENGTH_LONG).show();
                }
            }
        });
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    //authenticate the username and password
    private boolean authenticate(String primaryPhoneNumber, String password){
        return authenticationInterface.authenticate(primaryPhoneNumber, password);
    }

}
