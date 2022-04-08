package com.example.learning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseCategory extends AppCompatActivity {

    Button bt_student,bt_teacher_coaching;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_category);

        bt_student = findViewById(R.id.btStudent);
        bt_teacher_coaching = findViewById(R.id.btteacher);

        bt_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ChooseCategory.this,SignUpOneStudent.class);
                startActivity(intent);
                finish();
            }
        });

        bt_teacher_coaching.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChooseCategory.this,SignUpOne.class);
                startActivity(intent);
                finish();
            }
        });
    }
}