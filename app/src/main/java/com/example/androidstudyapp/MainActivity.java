package com.example.androidstudyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    static final String[] sMenu = {
            "1. Intent - Explicit",
            "2. Intent - Implicit",
            "3. Toolbar",
            "4. ViewHolder",
            "5. MVVM",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvw = (ListView) findViewById(R.id.lvw1);
        ArrayAdapter adt = new ArrayAdapter(this, android.R.layout.simple_list_item_1, sMenu);
        lvw.setAdapter(adt);

        lvw.setOnItemClickListener((av, vw, i, l) -> {    // AdapterView, View, position, id
            lvw.getItemAtPosition(i);
            System.out.println(String.format("List item %d(%s) is clicked !!!", i, sMenu[i]));

            if (i == 0) {
                Intent it = new Intent(this, IntentExplicitActivity.class);
                startActivity(it);
            } else if (i == 1) {
                Intent it = new Intent("android.intent.action.IMPLICIT");
                it.putExtra("val", "Implicit Intent Test");
                it.addCategory(Intent.CATEGORY_DEFAULT);
                startActivity(it);
            } else if (i == 2) {
                Intent it = new Intent(this, ToolbarActivity.class);
                startActivity(it);
            } else if (i == 3) {
                Intent it = new Intent(this, ViewHolderActivity.class);
                startActivity(it);
            } else if (i == 4) {
                Intent it = new Intent(this, MvvmActivity.class);
                startActivity(it);
            }
        });
    }
}