package com.example.yaroslav.cameragrabber;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Base64;
import java.net.*;

/**
 * Created by Yaroslav on 12.05.2016.
 */

class ReceiveImageTask extends AsyncTask<String, Void, Void> {
    private Exception exception;
    private String userAgent = "User-Agent";
    private String login = "admin";
    private String pass = "";
    private CamObj camObj;
    private Bitmap bitmap = null;

    public ReceiveImageTask(CamObj camObj) {
        this.camObj = camObj;
    }

    protected Void doInBackground(String... params) {
        try {
            URL urlObj = new URL(camObj.getUrl());
            HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", userAgent);
            connection.setRequestProperty("Authorization", "Basic " + Base64.encodeToString((login + ":" + pass).getBytes("UTF-8"), Base64.NO_WRAP));
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK)
                bitmap = BitmapFactory.decodeStream(connection.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
        camObj.DrawFromBitmap(bitmap);
    }
}