package com.example.androidstudyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_explicit =(Button) findViewById(R.id.btn_Intent1);
        Button btn_implicit =(Button) findViewById(R.id.btn_Intent2);
        Button btn_toolbar =(Button) findViewById(R.id.btn_toolbar);
        Button btn_view_holder =(Button) findViewById(R.id.btn_view_holder);

        btn_explicit.setOnClickListener((e)-> {
            Intent it = new Intent(this, IntentExplicitActivity.class);
            startActivity(it);
        });

        btn_implicit.setOnClickListener((e)-> {
            Intent it = new Intent("android.intent.action.IMPLICIT");
            it.putExtra("val", "Implicit Intent Test");
            it.addCategory(Intent.CATEGORY_DEFAULT);
            startActivity(it);
        });

        btn_toolbar.setOnClickListener((e)-> {
            Intent it = new Intent(this, ToolbarActivity.class);
            startActivity(it);
        });

        btn_view_holder.setOnClickListener((e)-> {
            Intent it = new Intent(this, ViewHolderActivity.class);
            startActivity(it);
        });
    }
}