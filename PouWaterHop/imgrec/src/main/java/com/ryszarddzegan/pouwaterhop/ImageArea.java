package com.ryszarddzegan.pouwaterhop;

public class ImageArea {
    private final PixelHelperFactory pixelHelperFactory;
    private final float xFactor;
    private final float yFactor;
    private final float widthFactor;
    private final float heightFactor;
    private final float redFactor;
    private final float greenFactor;
    private final float blueFactor;

    public float getXFactor() {
        return xFactor;
    }

    public float getYFactor() {
        return yFactor;
    }

    public float getWidthFactor() {
        return widthFactor;
    }

    public float getHeightFactor() {
        return heightFactor;
    }

    public float getRedFactor() {
        return redFactor;
    }

    public float getGreenFactor() {
        return greenFactor;
    }

    public float getBlueFactor() {
        return blueFactor;
    }

    public ImageArea(PixelHelperFactory pixelHelperFactory, float xFactor, float yFactor, float widthFactor, float heightFactor, float redFactor, float greenFactor, float blueFactor) {
        this.pixelHelperFactory = pixelHelperFactory;
        this.xFactor = xFactor;
        this.yFactor = yFactor;
        this.heightFactor = heightFactor;
        this.widthFactor = widthFactor;
        this.redFactor = redFactor;
        this.greenFactor = greenFactor;
        this.blueFactor = blueFactor;
    }

    public Image getArea(Image image) {
        final int x = (int) (image.getWidth()*getXFactor());
        final int y = (int) (image.getHeight()*getYFactor());

        final int width = (int) (image.getWidth()*getWidthFactor());
        final int height = (int) (image.getHeight()*getHeightFactor());

        return image.getArea(x, y, width, height);
    }

    public void markArea(Image image) {
        final int x = (int) (image.getWidth()*getXFactor());
        final int y = (int) (image.getHeight()*getYFactor());

        final int width = (int) (image.getWidth()*getWidthFactor());
        final int height = (int) (image.getHeight()*getHeightFactor());

        final int pixelsCount = width * height;
        final int[] pixels = image.getPixels(x, y, width, height);

        for (int i = 0; i < pixelsCount; i++) {
            int pixel = pixels[i];
            PixelHelper pixelHelper = pixelHelperFactory.fromPixel(pixel);
            int newPixel = pixelHelper.multiply(getRedFactor(), getGreenFactor(), getBlueFactor());
            pixels[i] = newPixel;
        }

        image.setPixels(pixels, x, y, width, height);
    }
}
