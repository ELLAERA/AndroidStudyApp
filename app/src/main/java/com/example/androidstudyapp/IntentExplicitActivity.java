package com.example.androidstudyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class IntentExplicitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_explicit);

        Button btn1 = (Button)findViewById(R.id.btn1);
        btn1.setOnClickListener((e)->{
            Intent it = new Intent(this, MainActivity.class);
            startActivity(it);

            // MainActivity를 종료 (메모리에서 제거)
            finish();
        });
    }

}