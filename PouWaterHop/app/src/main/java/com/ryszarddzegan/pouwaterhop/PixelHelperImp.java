package com.ryszarddzegan.pouwaterhop;

import android.graphics.Color;

public class PixelHelperImp implements PixelHelper {
    private int pixel;

    public PixelHelperImp(int pixel) {
        this.pixel = pixel;
    }

    @Override
    public int getPixel() {
        return pixel;
    }

    @Override
    public int getRed() {
        return Color.red(pixel);
    }

    @Override
    public int getGreen() {
        return Color.green(pixel);
    }

    @Override
    public int getBlue() {
        return Color.blue(pixel);
    }

    @Override
    public int multiply(float rFactor, float gFactor, float bFactor) {
        // Get pixel's ingredients
        int r = Color.red(pixel);
        int g = Color.green(pixel);
        int b = Color.blue(pixel);

        // Mark pixels
        r *= rFactor;
        g *= gFactor;
        b *= bFactor;

        if (r > 255) r = 255;
        else if (r < 0) r = 0;

        if (g > 255) g = 255;
        else if (g < 0) g = 0;

        if (b > 255) b = 255;
        else if (b < 0) b = 0;

        return android.graphics.Color.rgb(r, g, b);
    }

    @Override
    public int reduce(int count) {
        final int divider = 256 / count;

        // Get pixel's ingredients
        int r = Color.red(pixel);
        int g = Color.green(pixel);
        int b = Color.blue(pixel);

        // Reduce colors
        r = (r/divider)*divider;
        g = (g/divider)*divider;
        b = (b/divider)*divider;

        return Color.rgb(r, g, b);
    }
}
