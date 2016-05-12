package com.example.yaroslav.cameragrabber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    Timer timer;
    GrabImageTimerTask  timerTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onStart() {
        timer = new Timer();
        timerTask = new GrabImageTimerTask(new CamObj((ImageView) findViewById(R.id.imageView)));
        timer.schedule(timerTask, 0, 1000);
        super.onStart();
    }

    @Override
    public void onStop() {
        timer.cancel();
        super.onStop();
    }
}
