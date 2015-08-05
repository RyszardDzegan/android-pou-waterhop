package com.ryszarddzegan.pouwaterhop;

public class PixelHelperImp implements PixelHelper {
    private static PixelHelper instance = null;

    public static PixelHelper getInstance() {
        if (instance == null) {
            instance = new PixelHelperImp();
        }

        return instance;
    }

    private PixelHelperImp() {}

    @Override
    public int red(int pixel) {
        return StaticPixelHelper.getRed(pixel);
    }

    @Override
    public int green(int pixel) {
        return StaticPixelHelper.getGreen(pixel);
    }

    @Override
    public int blue(int pixel) {
        return StaticPixelHelper.getBlue(pixel);
    }

    @Override
    public int rgb(int red, int green, int blue) {
        return StaticPixelHelper.rgb(red, green, blue);
    }
}
