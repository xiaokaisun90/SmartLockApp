package com.example.simsim.ui;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * Created by Steven on 15/7/18.
 */
public class CreateProfileActivity extends Activity {

    private EditText birthdayET;
    private DatePicker datePicker;
    private Spinner genderSpinner;
    private EditText emailET;
    private EditText zipCodeET;
    private Spinner roleSpnnier;
    private Button confirmButton;

    private int year;
    private int month;
    private int day;

    private static final String gender[]={"Female","Male"};
    private static final String role[]={"Host","Guest"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_create_profile);

        birthdayET=(EditText)findViewById(R.id.birthdayET);
        datePicker=(DatePicker)findViewById(R.id.datePicker);
        genderSpinner=(Spinner)findViewById(R.id.selectGender);
        emailET=(EditText)findViewById(R.id.emailET);
        zipCodeET=(EditText)findViewById(R.id.zipCodeET);
        roleSpnnier=(Spinner)findViewById(R.id.selectRole);
        confirmButton=(Button)findViewById(R.id.confirmButton);

        birthdayET.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    datePicker.setVisibility(View.VISIBLE);
                }else{
                    datePicker.setVisibility(View.GONE);
                }
            }
        });

        datePicker.init(this.year,this.month,this.day, new DatePicker.OnDateChangedListener(

        ) {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                CreateProfileActivity.this.year=year;
                CreateProfileActivity.this.month=monthOfYear+1;
                CreateProfileActivity.this.day=dayOfMonth;
                CreateProfileActivity.this.birthdayET.setText(month+","+day+","+year);
                CreateProfileActivity.this.birthdayET.setTextColor(Color.RED);
            }
        });



    }
}
