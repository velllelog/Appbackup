package com.example.learning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    Handler handler = new Handler();
    String tag = "MainActivity";

    FirebaseAuth auth;
    DatabaseReference databaseReference;
    public String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();

        databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://fire-connection-dc9f0-default-rtdb.firebaseio.com/");

        if(auth.getCurrentUser() != null){
            phone = auth.getCurrentUser().getPhoneNumber();

        }

        //logs in if there is a logged in account
        if (auth.getCurrentUser() != null){
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(MainActivity.this, Home.class);
                    intent.putExtra("phone", phone);
                    startActivity(intent);
                    finish();
                    //Toast.makeText(MainActivity.this, phone, Toast.LENGTH_SHORT).show();
                }
            }, 3000);
        }else {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(MainActivity.this, LoginOrSignUp.class);
                    startActivity(intent);
                    finish();
                    //Toast.makeText(MainActivity.this, "Nil", Toast.LENGTH_SHORT).show();
                }
            }, 3000);
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