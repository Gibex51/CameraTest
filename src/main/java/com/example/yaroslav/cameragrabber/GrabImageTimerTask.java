package com.example.yaroslav.cameragrabber;

import java.util.TimerTask;

/**
 * Created by Yaroslav on 12.05.2016.
 */
public class GrabImageTimerTask extends TimerTask {

    private CamObj camObj;

    public GrabImageTimerTask(CamObj camObj) {
        this.camObj = camObj;
    }

    @Override
    public void run() {
        new ReceiveImageTask(camObj).execute();
    }
}
