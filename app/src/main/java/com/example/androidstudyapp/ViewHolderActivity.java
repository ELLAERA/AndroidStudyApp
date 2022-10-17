package com.example.androidstudyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewHolderActivity extends AppCompatActivity {

    ArrayList<ViewHolderAdapter.ViewHolderModel> data = new ArrayList<ViewHolderAdapter.ViewHolderModel>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_holder);

        for (int i=10; i<=100; i++) {
            data.add(new ViewHolderAdapter.ViewHolderModel("LeeAera"+i, "ella"+i+"@gmail.com", "0101111222"+i));
        }

        ListView lvw = (ListView) findViewById(R.id.my_lvw);
        ViewHolderAdapter adt = new ViewHolderAdapter(this,data);
        lvw.setAdapter(adt);
    }
}