package com.example.learning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ChooseCategory extends AppCompatActivity {

    TextView tv_student,tv_teacher_coaching;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_category);

        tv_student = findViewById(R.id.Student);
        tv_teacher_coaching = findViewById(R.id.TeacherOrCoaching);

        tv_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ChooseCategory.this,SignUpOneStudent.class);
                startActivity(intent);
                finish();
            }
        });

        tv_teacher_coaching.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChooseCategory.this,SignUpOne.class);
                startActivity(intent);
                finish();
            }
        });
    }
}