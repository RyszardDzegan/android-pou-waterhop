package com.ryszarddzegan.pouwaterhop;

public interface PixelHelper {
    int getPixel();
    int getRed();
    int getGreen();
    int getBlue();
    int multiply(float rFactor, float gFactor, float bFactor);
    int reduce(int count);
}
