package com.ryszarddzegan.pouwaterhop;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;

public class BitmapHelper {
    public Bitmap prepareBitmapForDisplay(Bitmap bitmap) {
        bitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() << 3, bitmap.getHeight() << 3, true);
        if (bitmap.getHeight() > bitmap.getWidth())
            bitmap = rotateBitmap(bitmap);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight() >> 1);
    }

    public Bitmap prepareBitmapForRecognition(Bitmap bitmap) {
        if (bitmap.getHeight() > bitmap.getWidth())
            bitmap = rotateBitmap(bitmap);
        bitmap = Bitmap.createScaledBitmap(bitmap, 64, 48, true);
        bitmap = Bitmap.createBitmap(bitmap, 0, 0, 64, 24);
        bitmap = reduceColors(bitmap);
        return bitmap;
    }

    private Bitmap rotateBitmap(Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.postRotate(90);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    private Bitmap reduceColors(Bitmap bitmap) {
        for (int x = 0; x < bitmap.getWidth(); x++) {
            for (int y = 0; y < bitmap.getHeight(); y++) {
                int pixel = bitmap.getPixel(x, y);

                // Get pixel's ingredients
                int r = Color.red(pixel);
                int g = Color.green(pixel);
                int b = Color.blue(pixel);

                // Reduce to 4 colors
                r /= 64;
                g /= 64;
                b /= 64;

                int newPixel = Color.rgb(r, g, b);
                bitmap.setPixel(x, y, newPixel);
            }
        }
        return bitmap;
    }
}
