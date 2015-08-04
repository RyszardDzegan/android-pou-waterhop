package com.ryszarddzegan.pouwaterhop;

/**
 * Provides methods that can be implemented
 * without referencing native bitmap methods,
 * i.e. by using only Image interface methods
 */
public class ImageHelper {
    private ImageHelper() {}

    public static boolean isPortrait(Image image) {
        return image.getHeight() > image.getWidth();
    }

    public static Image getBottomHalf(Image image) {
        return image.getArea(0, image.getHeight() >> 1, image.getWidth(), image.getHeight() >> 1);
    }
}
