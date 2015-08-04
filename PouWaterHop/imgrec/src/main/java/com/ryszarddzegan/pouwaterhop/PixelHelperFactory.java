package com.ryszarddzegan.pouwaterhop;

public interface PixelHelperFactory {
    PixelHelper fromPixel(int pixel);
    PixelHelper red();
    PixelHelper blue();
}
