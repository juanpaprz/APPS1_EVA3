package com.example.eva3_11_load_image_post;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    ImageView imgVwLoad;
    Thread thread;
    Bitmap bitmap;
    Handler handler = new Handler();

    Runnable background = new Runnable() {
        @Override
        public void run() {
            bitmap = descargarImagen("https://n9e5v4d8.ssl.hwcdn.net/uploads/5ae0ef444564894f6771d724984a50f3.jpg");
            handler.post(foreground);
        }
    };

    Runnable foreground = new Runnable() {
        @Override
        public void run() {
            imgVwLoad.setImageBitmap(bitmap);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgVwLoad = findViewById(R.id.imgVwLoad);
        thread = new Thread(background);
        thread.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        thread.interrupt();
    }

    private Bitmap descargarImagen(String url) {
        try {
            InputStream inputStream = (InputStream) new URL(url).getContent();
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            return bitmap;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}