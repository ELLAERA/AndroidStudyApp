package com.example.androidstudyapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.androidstudyapp.recycler.RecyclerViewAdapter;
import com.example.androidstudyapp.recycler.RecyclerViewData;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    private ArrayList<RecyclerViewData> arrayList;
    private RecyclerViewAdapter adapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        recyclerView = (RecyclerView) findViewById(R.id.rv);
        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        arrayList = new ArrayList<>();
        adapter = new RecyclerViewAdapter(arrayList);
        recyclerView.setAdapter(adapter);

        Button btn_add = (Button) findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecyclerViewData data = new RecyclerViewData(R.mipmap.ic_launcher, "My Name", "recycler view content");
                arrayList.add(data);
                adapter.notifyDataSetChanged(); // 새로고침
            }
        });
    }
}