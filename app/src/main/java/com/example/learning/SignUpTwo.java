package com.example.learning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpTwo extends AppCompatActivity {

    TextInputLayout descriptionInputLayout;
    TextView tapLogin;
    Button btnNext;

    FirebaseAuth auth;
    FirebaseDatabase rootNode;
    DatabaseReference databaseReference;

    public String phone,name,grade,location,subject,fee,description;

    String tag = "SignUp Two";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_two);

        descriptionInputLayout = findViewById(R.id.descriptionInputLayout);
        tapLogin = findViewById(R.id.tapLogin);

        btnNext = findViewById(R.id.btnNext);

        //firebase
        auth = FirebaseAuth.getInstance();
        rootNode = FirebaseDatabase.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://fire-connection-dc9f0-default-rtdb.firebaseio.com/");

        //getValues
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        phone = intent.getStringExtra("phone");
        grade = intent.getStringExtra("grade");
        fee = intent.getStringExtra("fee");
        subject = intent.getStringExtra("subject");
        location = intent.getStringExtra("location");



        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //input validations
                if(!checkdesription()){
                    return;
                }


                //get Values from EditTexts
                description = descriptionInputLayout.getEditText().getText().toString();

                Intent intent = new Intent(SignUpTwo.this, SignUpOTP.class);
                intent.putExtra("name", name);
                intent.putExtra("phone", phone);
                intent.putExtra("grade", grade);
                intent.putExtra("subject",subject);
                intent.putExtra("fee",fee);
                intent.putExtra("location", location);
                intent.putExtra("description",description);
                startActivity(intent);


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


    //input validations
    private boolean checkdesription(){
        String name = descriptionInputLayout.getEditText().getText().toString();

        if(name.isEmpty()){
            descriptionInputLayout.setError("Enter Your Description");
            return false;
        }else {
            descriptionInputLayout.setError(null);
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