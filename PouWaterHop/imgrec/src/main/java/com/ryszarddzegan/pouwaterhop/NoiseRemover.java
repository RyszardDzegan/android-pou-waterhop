package com.ryszarddzegan.pouwaterhop;

import java.util.HashMap;

public class NoiseRemover {
    private NoiseRemover() {}

    public static void removeNoise(Image image) {
        Image newImage = image.clone();
        for (int x = 0; x < newImage.getWidth(); x++) {
            for (int y = 0; y < newImage.getHeight(); y++) {
                int[] ambientPixels = getAmbientPixels(newImage, x, y);
                HashMap<Integer, Integer> colorCountsHashMap = ColorsHelper.getColorCounts(ambientPixels);
                int prevalentPixel = ColorsHelper.getPrevalentPixel(colorCountsHashMap);
                image.setPixel(prevalentPixel, x, y);
            }
        }
    }

    private static int[] getAmbientPixels(Image image, int x, int y) {
        final int RADIUS = 1;
        final int SIZE = 2*RADIUS+1;

        if (image.getWidth() < SIZE)
            throw new IllegalArgumentException(String.format("Width must be greater than or equal %d.", SIZE));

        if (image.getHeight() < SIZE)
            throw new IllegalArgumentException(String.format("Height must be greater than or equal %d.", SIZE));

        int left;

        if (x - RADIUS <= 0) {
            left = 0;
        } else if (x >= image.getWidth() - SIZE) {
            left = image.getWidth() - SIZE;
        } else {
            left = x - RADIUS;
        }

        int top;

        if (y - RADIUS <= 0) {
            top = 0;
        } else if (y >= image.getHeight() - SIZE) {
            top = image.getHeight() - SIZE;
        } else {
            top = y - RADIUS;
        }

        return image.getPixels(left, top, SIZE, SIZE);
    }
}
