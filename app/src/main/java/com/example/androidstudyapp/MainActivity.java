package com.example.androidstudyapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
            "6. Bluetooth",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvw = (ListView) findViewById(R.id.lvw1);
        ArrayAdapter<String> adt = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sMenu);
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
            } else if (i == 5) {
                Intent it = new Intent(this, BluetoothActivity.class);
                startActivity(it);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mif = getMenuInflater();
        mif.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.ic_notification:
                NotificationCompat.Builder nb = new NotificationCompat.Builder(this, "default");
                nb.setSmallIcon(R.mipmap.ic_launcher);
                nb.setContentTitle("[Alert]");
                nb.setContentText("Notification sent successfully.");
                nb.setColor(Color.RED);
                nb.setAutoCancel(true); // 사용자가 탭을 클릭하면 자동 제거
                // 알림 표시
                NotificationManager notificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {	// O : Oreo 버전 이 후...
                    notificationManager.createNotificationChannel(
                            new NotificationChannel("default", "기본 채널", NotificationManager.IMPORTANCE_DEFAULT));
                }
                // 정의해야하는 각 알림의 고유한 int값
                notificationManager.notify(1, nb.build());
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}