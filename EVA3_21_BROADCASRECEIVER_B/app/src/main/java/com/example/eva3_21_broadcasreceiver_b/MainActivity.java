package com.example.eva3_21_broadcasreceiver_b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtVwDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtVwDatos = findViewById(R.id.txtVwDatos);
        BroadcastReceiver broadcastReceiver = new MiBroadCast();
        IntentFilter intentFilter = new IntentFilter("MI_MENSAJE");
        registerReceiver(broadcastReceiver, intentFilter);
    }

    class MiBroadCast extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            txtVwDatos.append(intent.getStringExtra("MENSAJE") + "\n");
        }
    }
}