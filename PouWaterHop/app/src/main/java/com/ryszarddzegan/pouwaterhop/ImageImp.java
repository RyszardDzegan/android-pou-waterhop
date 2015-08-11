package com.ryszarddzegan.pouwaterhop;

import android.graphics.Bitmap;
import android.graphics.Matrix;

public class ImageImp implements Image {
    private final Bitmap bitmap;

    public Bitmap getBitmap() {
        return bitmap;
    }

    public ImageImp(Bitmap bitmap) {
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

    @Override
    public void setPixel(int pixel, int x, int y) {
        bitmap.setPixel(x, y, pixel);
    }

    @Override
    public int[] getPixels() {
        return getPixels(0, 0, getWidth(), getHeight());
    }

    @Override
    public int[] getPixels(int x, int y, int width, int height) {
        final int[] pixels = new int[width * height];
        bitmap.getPixels(pixels, 0, width, x, y, width, height);
        return pixels;
    }

    @Override
    public void setPixels(int[] pixels) {
        setPixels(pixels, 0, 0, getWidth(), getHeight());
    }

    @Override
    public void setPixels(int[] pixels, int x, int y, int width, int height) {
        bitmap.setPixels(pixels, 0, width, x, y, width, height);
    }

    @Override
    public Image getArea(int x, int y, int width, int height) {
        Bitmap areaBitmap = Bitmap.createBitmap(bitmap, x, y, width, height);
        return new ImageImp(areaBitmap);
    }

    @Override
    public Image scale(int width, int height) {
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap, width, height, true);
        return new ImageImp(scaledBitmap);
    }

    @Override
    public Image rotate(float degrees) {
        Matrix matrix = new Matrix();
        matrix.postRotate(degrees);
        Bitmap rotatedBitmap =  Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        return new ImageImp(rotatedBitmap);
    }

    @SuppressWarnings("CloneDoesntCallSuperClone")
    @Override
    public Image clone() {
        Bitmap clonedBitmap = Bitmap.createBitmap(bitmap, 0, 0, getWidth(), getHeight());
        return new ImageImp(clonedBitmap);
    }
}
