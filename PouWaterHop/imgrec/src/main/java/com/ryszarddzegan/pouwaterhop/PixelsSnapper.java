package com.ryszarddzegan.pouwaterhop;

public class PixelsSnapper {
    private final PixelHelper pixelHelper;

    public PixelsSnapper(PixelHelper pixelHelper) {
        this.pixelHelper = pixelHelper;
    }

    public void snap(Image image) {
        final int[] pixels = image.getPixels();

        for (int i = 0; i < pixels.length; i++) {
            int pixel = pixels[i];
            int snappedPixel = snap(pixel);
            pixels[i] = snappedPixel;
        }

        image.setPixels(pixels);
    }

    private int snap(int pixel) {
        int r = pixelHelper.red(pixel);
        int g = pixelHelper.green(pixel);
        int b = pixelHelper.blue(pixel);

        r = snapIngredient(r);
        g = snapIngredient(g);
        b = snapIngredient(b);

        return pixelHelper.rgb(r, g, b);
    }

    private int snapIngredient(int value) {
        final int DIVIDER = 128;
        final int factor = value/DIVIDER;
        final int floor = DIVIDER*factor;
        final int ceil = floor + DIVIDER < 256 ? floor + DIVIDER : 255;
        return value - floor >= ceil - value ? floor : ceil;
    }
}
