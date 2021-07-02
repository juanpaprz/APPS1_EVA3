package com.example.eva3_10_banner_post;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    ImageView imgVwBanner;
    SeekBar skBrSpeed;
    Thread thread;
    int iImg = 0, iSpeed = 1000;
    Handler handler = new Handler();

    Runnable background = new Runnable() {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(iSpeed);
                    handler.post(foreground);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
    };

    Runnable foreground = new Runnable() {
        @Override
        public void run() {
            switch (iImg) {
                case 0:
                    imgVwBanner.setImageResource(R.drawable.f1);
                    iImg++;
                    break;
                case 1:
                    imgVwBanner.setImageResource(R.drawable.f2);
                    iImg++;
                    break;
                case 2:
                    imgVwBanner.setImageResource(R.drawable.f3);
                    iImg = 0;
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgVwBanner = findViewById(R.id.imgVwBanner);
        skBrSpeed = findViewById(R.id.skBrSpeed);
        thread = new Thread(background);
        thread.start();

        skBrSpeed.setMax(900);

        skBrSpeed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                iSpeed = 1000 - progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        thread.interrupt();
    }
}