package com.example.androidstudyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class IntentImplicitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_implicit);

        Intent it = getIntent();
        String s = it.getExtras().getString("val");

        TextView txv1 = (TextView)findViewById(R.id.txv1);
        txv1.setText(s);
    }
}