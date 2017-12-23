package com.example.usmanahmed.handsfreebroadcast;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    Button activate,deactivate;
    handsfree obj= new handsfree();
    IntentFilter filter= new IntentFilter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        filter.addAction(Intent.ACTION_HEADSET_PLUG);
        filter.addAction(Intent.ACTION_TIME_TICK);
        registerReceiver(obj,filter);
        activate=findViewById(R.id.button2);
        deactivate=findViewById(R.id.button3);
        activate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerReceiver(obj,filter);
                Toast.makeText(MainActivity.this, "Activated", Toast.LENGTH_SHORT).show();
            }
        });
        deactivate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unregisterReceiver(obj);
                Toast.makeText(MainActivity.this, "Deactivated", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
