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

public class SignUpOneStudent extends AppCompatActivity {
    TextInputLayout nameInputLayout, phoneInputLayout, GradeInputLayout,menu;
    CountryCodePicker ccp;
    TextView tapLogin;
    Button btnSignUpStudent;
    AutoCompleteTextView dropdown_menu;

    public String phone,selectedLocation;

    String tag = "SignUpOneStudent";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_one_student);

        nameInputLayout = findViewById(R.id.nameInputLayoutstudent);
        phoneInputLayout = findViewById(R.id.phoneInputLayoutstudent);
        GradeInputLayout = findViewById(R.id.GradeInputLayoutStudent);

        menu = findViewById(R.id.menu_locationstudent);
        dropdown_menu = findViewById(R.id.dropdown_menustudent);

        ccp = findViewById(R.id.ccp);
        ccp.registerCarrierNumberEditText(phoneInputLayout.getEditText());

        tapLogin = findViewById(R.id.tapLogin);
        btnSignUpStudent = findViewById(R.id.btnNext);
        //drop down menu items
        String[] Location = {"Delhi", "Mumbai", "Kolkata", "Bengaluru", "Hyderabad", "Chennai", "Pune"};
        ArrayAdapter<String> LocationAdapter = new ArrayAdapter<>(SignUpOneStudent.this, R.layout.drop_down_list,Location);
        dropdown_menu.setAdapter(LocationAdapter);

        btnSignUpStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!checkName() || !checkPhone() || !checkGrade()) {
                    return;
                }

                String name = nameInputLayout.getEditText().getText().toString();
                String Grade = GradeInputLayout.getEditText().getText().toString();
                Intent intent = new Intent(getApplicationContext(), SignUpOTPStudent.class);

                //send values to different Activity
                intent.putExtra("name", name);
                intent.putExtra("phone", ccp.getFullNumberWithPlus().replace(" ", ""));
                intent.putExtra("Grade", Grade);
                intent.putExtra("selectedLocation", selectedLocation);

                startActivity(intent);

            }
        });

        dropdown_menu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedLocation = LocationAdapter.getItem(i);
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

        if (name.isEmpty()) {
            nameInputLayout.setError("Enter Your Name");
            return false;
        } else {
            nameInputLayout.setError(null);
            return true;
        }
    }

    private boolean checkPhone() {
        phone = phoneInputLayout.getEditText().getText().toString();

        if (phone.isEmpty()) {
            phoneInputLayout.setError("Enter Your Phone Number");
            return false;
        } else {
            phoneInputLayout.setError(null);
            return true;
        }
    }


    private boolean checkGrade() {
        String age = GradeInputLayout.getEditText().getText().toString();

        if (age.isEmpty()) {
            GradeInputLayout.setError("Enter Your Phone Number");
            return false;
        } else {
            GradeInputLayout.setError(null);
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