package com.example.androidstudyapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.androidstudyapp.databinding.ActivityMvvmBinding;

public class MvvmActivity extends AppCompatActivity {

    private MvvmViewModel model = new MvvmViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMvvmBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm);
        binding.setModel(model);
        model.onCreate();
    }
    @Override
    protected void onResume() {
        super.onResume();
        model.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        model.onPause();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        model.onDestroy();
    }
}