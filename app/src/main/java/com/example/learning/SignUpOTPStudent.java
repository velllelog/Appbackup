package com.example.learning;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mukesh.OnOtpCompletionListener;
import com.mukesh.OtpView;

import java.util.concurrent.TimeUnit;

public class SignUpOTPStudent extends AppCompatActivity {
    Button btnNext;
    OtpView otpView;
    TextView resendOTP;

    FirebaseAuth auth;
    FirebaseDatabase rootNode;
    DatabaseReference databaseReference;

    public String name, phone, grade, selectedLocation, verificationID;

    String tag = "SignUpOTP";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_otp);

        btnNext = findViewById(R.id.btnNextStudent);
        otpView = findViewById(R.id.otp_view_Student);
        resendOTP = findViewById(R.id.resendOTPStudent);

        //firebase
        auth = FirebaseAuth.getInstance();
        rootNode = FirebaseDatabase.getInstance();


        //get values from last intent
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        phone = intent.getStringExtra("phone");
        grade = intent.getStringExtra("age");
        selectedLocation = intent.getStringExtra("selectedItem");



        //get OTP
        PhoneAuthOptions options = PhoneAuthOptions.newBuilder(auth)
                .setPhoneNumber(phone)
                .setTimeout(60L, TimeUnit.SECONDS)
                .setActivity(SignUpOTPStudent.this)
                .setCallbacks(new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    @Override
                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                    }

                    @Override
                    public void onVerificationFailed(@NonNull FirebaseException e) {

                    }

                    @Override
                    public void onCodeSent(@NonNull String verifyID, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                        super.onCodeSent(verifyID, forceResendingToken);

                        verificationID = verifyID;
                    }
                }).build();

        PhoneAuthProvider.verifyPhoneNumber(options);

        otpView.setOtpCompletionListener(new OnOtpCompletionListener() {
            @Override
            public void onOtpCompleted(String otp) {
                PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationID, otp);

                auth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            sendData();

                            Intent intent = new Intent(SignUpOTPStudent.this, Home.class);
                            // intent.putExtra("name", name);
                            intent.putExtra("phone", phone);
                            startActivity(intent);
                            finishAffinity();
                        }else {
                            Toast.makeText(SignUpOTPStudent.this, "Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                otpView.setOtpCompletionListener(new OnOtpCompletionListener() {
                    @Override
                    public void onOtpCompleted(String otp) {
                        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationID, otp);

                        auth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    sendData();
                                    Intent intent = new Intent(SignUpOTPStudent.this, Home.class);
                                    //intent.putExtra("name", name);
                                    intent.putExtra("phone", phone);
                                    startActivity(intent);
                                    finishAffinity();
                                }else {
                                    Toast.makeText(SignUpOTPStudent.this, "Failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                });
            }
        });

        //resend OTP
        resendOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PhoneAuthOptions options = PhoneAuthOptions.newBuilder(auth)
                        .setPhoneNumber(phone)
                        .setTimeout(60L, TimeUnit.SECONDS)
                        .setActivity(SignUpOTPStudent.this)
                        .setCallbacks(new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {

                            }

                            @Override
                            public void onCodeSent(@NonNull String newOTP, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                super.onCodeSent(newOTP, forceResendingToken);
                                verificationID = newOTP;
                                Toast.makeText(SignUpOTPStudent.this, "Resent", Toast.LENGTH_SHORT).show();
                            }
                        }).build();

                PhoneAuthProvider.verifyPhoneNumber(options);
            }
        });
    }

    private void sendData() {
        databaseReference = rootNode.getReference("Student");

        ConstructorStudent constructorStudent = new ConstructorStudent(name, selectedLocation,  phone, grade);
        databaseReference.child(phone).setValue(constructorStudent);

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