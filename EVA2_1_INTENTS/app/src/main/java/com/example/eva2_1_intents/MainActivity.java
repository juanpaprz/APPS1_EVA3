package com.example.eva2_1_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String TEL = "tel: 6141215952";

    Intent inTel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClickDial(View v){
        inTel = new Intent(Intent.ACTION_DIAL, Uri.parse(TEL));
        startActivity(inTel);
    }

    public void onClickCall(View v){
        inTel = new Intent(Intent.ACTION_CALL, Uri.parse(TEL));
        startActivity(inTel);
    }

    public void onClickCont(View v){
        String sData = "content://contacts/people/";
        inTel = new Intent(Intent.ACTION_VIEW, Uri.parse(sData));
        startActivity(inTel);
    }

    public void onClickNav(View v){
        String sUrl = "http://www.youtube.com";
        inTel = new Intent(Intent.ACTION_VIEW, Uri.parse(sUrl));
        startActivity(inTel);
    }

}