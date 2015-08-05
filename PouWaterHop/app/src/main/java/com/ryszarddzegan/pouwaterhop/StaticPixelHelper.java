package com.ryszarddzegan.pouwaterhop;

import android.graphics.Color;

public class StaticPixelHelper {
    public static int getRed(int pixel) {
        return Color.red(pixel);
    }

    public static int getGreen(int pixel) {
        return Color.green(pixel);
    }

    public static int getBlue(int pixel) {
        return Color.blue(pixel);
    }

    public static int rgb(int red, int green, int blue) {
        return Color.rgb(red, green, blue);
    }
}
