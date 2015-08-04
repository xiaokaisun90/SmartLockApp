package com.example.simsim.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.simsim.entities.EntityAdapter;
import com.example.simsim.entities.Property;
import com.example.simsim.interfaces.HostSpaceInterface;


public class HostSpaceSettingsActivity extends Activity implements UIConstantInterface{

    private HostSpaceInterface hostSpaceInterface;
    private boolean isNew;
    private Property property;

    private EditText editTextPropertyName;
    private EditText editTextPropertyAddress;
    private EditText editTextPropertyZipCode;
    private EditText editTextPropertyCity;
    private EditText editTextPropertyState;
    private EditText editTextPropertyCountry;
    private Button buttonSave;
    private Button buttonDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host_space_settings);

        hostSpaceInterface = new EntityAdapter();
        Intent intent = getIntent();
        isNew = intent.getStringExtra("operation").equals("insert") ? true : false;
        if(isNew) property = new Property();
        else property = (Property) intent.getSerializableExtra("property");

        editTextPropertyName = (EditText) findViewById(R.id.editTextPropertyName);
        editTextPropertyAddress = (EditText) findViewById(R.id.editTextPropertyAddress);
        editTextPropertyZipCode = (EditText) findViewById(R.id.editTextPropertyZipCode);
        editTextPropertyCity = (EditText) findViewById(R.id.editTextPropertyCity);
        editTextPropertyState = (EditText) findViewById(R.id.editTextPropertyState);
        editTextPropertyCountry = (EditText) findViewById(R.id.editTextPropertyCountry);
        buttonSave = (Button) findViewById(R.id.buttonPropertySave);
        buttonDelete = (Button) findViewById(R.id.buttonPropertyDelete);

        editTextPropertyName.setText(property.getDescription());
        editTextPropertyAddress.setText(property.getAddress());
        int zipCode = property.getZipCode();
        if(zipCode != 0) editTextPropertyZipCode.setText(Integer.toString(property.getZipCode()));
        else editTextPropertyZipCode.setText("");
        editTextPropertyCity.setText(property.getCity());
        editTextPropertyState.setText(property.getState());
        editTextPropertyCountry.setText(property.getCountry());

        if(isNew) {
            buttonDelete.setEnabled(false);
            buttonDelete.setVisibility(View.GONE);
        }

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isNew) insertProperty(property);
                else updateProperty(property);
                Toast.makeText(HostSpaceSettingsActivity.this, MESSAGE_UPDATE_SUCCESS,
                        Toast.LENGTH_LONG).show();
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteProperty(property);
                Toast.makeText(HostSpaceSettingsActivity.this, MESSAGE_DELETE_SUCCESS,
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    private void insertProperty(Property property){
        try{
            hostSpaceInterface.insertProperty(property);
        } catch (Exception e){
            Toast.makeText(HostSpaceSettingsActivity.this, MESSAGE_UPDATE_EXCEPTION,
                    Toast.LENGTH_LONG).show();
        }
    }

    private void updateProperty(Property property){
        try{
            hostSpaceInterface.updateProperty(property);
        } catch (Exception e){
            Toast.makeText(HostSpaceSettingsActivity.this, MESSAGE_UPDATE_EXCEPTION,
                    Toast.LENGTH_LONG).show();
        }
    }

    private void deleteProperty(Property property){
        try{
            hostSpaceInterface.deleteProperty(property);
        } catch (Exception e){
            Toast.makeText(HostSpaceSettingsActivity.this, MESSAGE_DELETE_EXCEPTION,
                    Toast.LENGTH_LONG).show();
        }
    }

}
