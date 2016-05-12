package com.example.yaroslav.cameragrabber;

import android.graphics.Bitmap;
import android.widget.ImageView;

/**
 * Created by Yaroslav on 12.05.2016.
 */
public class CamObj {
    private String url = "http://demo.devline.ru:1818/cameras/0/image?keep_aspect_ratio=1&resolution=640x480";
    private ImageView imageView;

    public CamObj(ImageView imageView) {
        this.imageView = imageView;
    }

    public String getUrl() {
        return url;
    }

    public void DrawFromBitmap(Bitmap bitmap) {
        imageView.setImageBitmap(bitmap);
    }
}
