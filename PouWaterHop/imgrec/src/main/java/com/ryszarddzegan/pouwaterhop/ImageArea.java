package com.ryszarddzegan.pouwaterhop;

public class ImageArea {
    private final float xFactor;
    private final float yFactor;
    private final float widthFactor;
    private final float heightFactor;

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

    public ImageArea(float xFactor, float yFactor, float widthFactor, float heightFactor) {
        this.xFactor = xFactor;
        this.yFactor = yFactor;
        this.heightFactor = heightFactor;
        this.widthFactor = widthFactor;
    }

    public int getX(Image image) {
        return (int) (image.getWidth()*getXFactor());
    }

    public int getY(Image image) {
        return (int) (image.getHeight()*getYFactor());
    }

    public int getWidth(Image image) {
        return (int) (image.getWidth()*getWidthFactor());
    }

    public int getHeight(Image image) {
        return (int) (image.getHeight()*getHeightFactor());
    }

    public Image getArea(Image image) {
        final int x = getX(image);
        final int y = getY(image);
        final int width = getWidth(image);
        final int height = getHeight(image);

        return image.getArea(x, y, width, height);
    }

    public void markArea(Image image, int color) {
        final int left = getX(image);
        final int top = getY(image);
        final int width = getWidth(image);
        final int height = getHeight(image);

        // Mark left
        for (int y = 0; y < height; y++) {
            image.setPixel(color, left, top + y);
        }

        // Mark right
        for (int y = 0; y < height; y++) {
            image.setPixel(color, left + width - 1, top + y);
        }

        // Mark top
        for (int x = 0; x < width; x++) {
            image.setPixel(color, left + x, top);
        }

        // Mark bottom
        for (int x = 0; x < width; x++) {
            image.setPixel(color, left + x, top + height - 1);
        }
    }
}
