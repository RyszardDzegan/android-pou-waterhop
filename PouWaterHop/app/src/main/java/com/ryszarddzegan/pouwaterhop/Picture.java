package com.ryszarddzegan.pouwaterhop;

import android.graphics.Bitmap;

public class Picture implements Image {
    private final Bitmap bitmap;

    public Picture(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    @Override
    public int getHeight() {
        return bitmap.getHeight();
    }

    @Override
    public int getWidth() {
        return bitmap.getWidth();
    }

    @Override
    public int getPixel(int x, int y) {
        return bitmap.getPixel(x, y);
    }
}
