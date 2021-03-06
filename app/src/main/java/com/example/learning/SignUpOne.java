package com.example.learning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.hbb20.CountryCodePicker;

public class SignUpOne extends AppCompatActivity {
    TextInputLayout nameInputLayout,phoneInputLayout, gradeInputLayout , subjectInputLayout, feeInputLayout, menu;
    CountryCodePicker ccp;
    TextView tapLogin;
    Button btnNext;
    AutoCompleteTextView dropdown_menu;

    public String phone,location;

    String tag = "SignUpOne";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_one);

        nameInputLayout = findViewById(R.id.nameInputLayout);
        phoneInputLayout = findViewById(R.id.phoneInputLayout);
        gradeInputLayout = findViewById(R.id.gradeInputLayout);
        subjectInputLayout=findViewById(R.id.subjectInputLayout);
        feeInputLayout=findViewById(R.id.feeInputLayout);

        menu = findViewById(R.id.menu_location);
        dropdown_menu = findViewById(R.id.dropdown_menu);

        ccp = findViewById(R.id.ccp);
        ccp.registerCarrierNumberEditText(phoneInputLayout.getEditText());

        tapLogin = findViewById(R.id.tapLogin);

        btnNext = findViewById(R.id.btnNext);

        //drop down menu items
        String[] Location = {"Delhi", "Mumbai", "Kolkata", "Bengaluru", "Hyderabad", "Chennai", "Pune"};
        ArrayAdapter<String> LocationAdapter = new ArrayAdapter<>(SignUpOne.this, R.layout.drop_down_list,Location);
        dropdown_menu.setAdapter(LocationAdapter);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!checkName() ||!checkPhone() || !checkGrade() || !checkSubject() || !checkPrice()){
                    return;
                }

                String name = nameInputLayout.getEditText().getText().toString();
                String grade = gradeInputLayout.getEditText().getText().toString();
                String subject = subjectInputLayout.getEditText().getText().toString();
                String fee = feeInputLayout.getEditText().getText().toString();
                Intent intent = new Intent(getApplicationContext(), SignUpTwo.class);

                //send values to different Activity
                intent.putExtra("name", name);
                intent.putExtra("phone", ccp.getFullNumberWithPlus().replace(" ", ""));
                intent.putExtra("grade", grade);
                intent.putExtra("subject",subject);
                intent.putExtra("fee",fee);
                intent.putExtra("location", location);

                startActivity(intent);

            }
        });

        dropdown_menu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                location = LocationAdapter.getItem(i);
            }
        });


        tapLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginPhone.class);
                startActivity(intent);
                finish();
            }
        });


    }

    private boolean checkName() {
        String name = nameInputLayout.getEditText().getText().toString();

        if(name.isEmpty()){
            nameInputLayout.setError("Enter Your Name");
            return false;
        }else {
            nameInputLayout.setError(null);
            return true;
        }
    }

    private boolean checkPhone() {
        phone = phoneInputLayout.getEditText().getText().toString();

        if(phone.isEmpty()){
            phoneInputLayout.setError("Enter Your Phone Number");
            return false;
        }else {
            phoneInputLayout.setError(null);
            return true;
        }
    }

    private boolean checkSubject() {
        String gender = subjectInputLayout.getEditText().getText().toString();

        if(gender.isEmpty()){
            subjectInputLayout.setError("Enter Subject you Teach");
            return false;
        }else {
            subjectInputLayout.setError(null);
            return true;
        }
    }
    private boolean checkPrice() {
        String name = feeInputLayout.getEditText().getText().toString();

        if(name.isEmpty()){
            feeInputLayout.setError("Enter fees");
            return false;
        }else {
            feeInputLayout.setError(null);
            return true;
        }
    }

    private boolean checkGrade() {
        String age = gradeInputLayout.getEditText().getText().toString();

        if(age.isEmpty()){
            gradeInputLayout.setError("Enter The Grade You Teach");
            return false;
        }else {
            gradeInputLayout.setError(null);
            return true;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(tag, "onPause");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(tag, "onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(tag, "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(tag, "onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(tag, "onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(tag, "onDestroy");
    }
}