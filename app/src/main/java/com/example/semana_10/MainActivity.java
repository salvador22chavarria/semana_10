package com.example.semana_10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    VideoView vidello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vidello=findViewById(R.id.motomami);

        vidello.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.tecnology));
        vidello.start();

        TimerTask tiempo=new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,pedidos_ya.class);
                startActivity(intent);
                finish();
            }

        };


        Timer clock = new Timer();
        clock.schedule(tiempo,5000);


    }
}