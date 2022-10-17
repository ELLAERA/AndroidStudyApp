package com.example.androidstudyapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class ToolbarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);

        Toolbar tbar = (Toolbar)findViewById(R.id.my_toolbar);
        setSupportActionBar(tbar);
        ActionBar abar = getSupportActionBar();

        abar.setDisplayHomeAsUpEnabled(false);  							// 왼쪽 버튼 사용 여부
        //abar.setHomeAsUpIndicator(R.drawable.ic_launcher_foreground);  	// 왼쪽 버튼 이미지 설정
        //abar.setDisplayShowTitleEnabled(false);   						// 타이틀 안보이게 하기
        abar.setTitle("Toolbar");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mif = getMenuInflater();
        mif.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        TextView txv = (TextView)findViewById(R.id.tbar_txv);
        switch (item.getItemId()) {
            case R.id.menu_page1:
                txv.setText("Page 1");
                break;
            case R.id.menu_page2:
                txv.setText("Page 2");
                break;
            case R.id.menu_page3:
                txv.setText("Page 3");
                break;
            case R.id.menu_page4:
                txv.setText("Page 4");
                break;
            case R.id.menu_page5:
                txv.setText("Page 5");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}