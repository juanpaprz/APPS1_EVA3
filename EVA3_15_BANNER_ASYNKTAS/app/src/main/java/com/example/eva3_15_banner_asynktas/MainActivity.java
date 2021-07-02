package com.example.eva3_15_banner_asynktas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    ImageView imgVwBanner;
    SeekBar skBrSpeed;
    int iImg = 0, iSpeed = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgVwBanner = findViewById(R.id.imgVwBanner);
        skBrSpeed = findViewById(R.id.skBrSpeed);
        MiClaseAsincrona miClaseAsincrona = new MiClaseAsincrona();
        miClaseAsincrona.execute();
    }

    class MiClaseAsincrona extends AsyncTask<Integer, String, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            switch (iImg) {
                case 0:
                    imgVwBanner.setImageResource(R.drawable.f1);
                    break;
                case 1:
                    imgVwBanner.setImageResource(R.drawable.f2);
                    break;
                case 2:
                    imgVwBanner.setImageResource(R.drawable.f3);
                    break;
            }
        }

        @Override
        protected Void doInBackground(Integer... integers) {
            while(true){
                try {
                    publishProgress("" + iImg);
                    if(iImg == 2){
                        iImg = 0;
                    }else{
                        iImg++;
                    }
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }

}