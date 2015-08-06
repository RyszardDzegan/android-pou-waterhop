package com.ryszarddzegan.pouwaterhop;

public interface Image {
    int getHeight();
    int getWidth();
    int getPixel(int x, int y);
    void setPixel(int pixel, int x, int y);
    int[] getPixels();
    int[] getPixels(int x, int y, int width, int height);
    void setPixels(int[] pixels);
    void setPixels(int[] pixels, int x, int y, int width, int height);
    Image getArea(int x, int y, int width, int height);
    Image scale(int width, int height);
    Image rotate(float degrees);
    Image clone();
}
