package com.ryszarddzegan.pouwaterhop;

import android.graphics.Color;

public class PixelHelperFactoryImp implements PixelHelperFactory {
    private static PixelHelperFactory instance = null;

    public static PixelHelperFactory getInstance() {
        if (instance == null) {
            instance = new PixelHelperFactoryImp();
        }

        return instance;
    }

    private PixelHelperFactoryImp() {}

    @Override
    public PixelHelper fromPixel(int pixel) {
        return new PixelHelperImp(pixel);
    }

    @Override
    public PixelHelper red() {
        int pixel = Color.rgb(255, 0, 0);
        return fromPixel(pixel);
    }

    @Override
    public PixelHelper blue() {
        int pixel = Color.rgb(0, 0, 255);
        return fromPixel(pixel);
    }
}
