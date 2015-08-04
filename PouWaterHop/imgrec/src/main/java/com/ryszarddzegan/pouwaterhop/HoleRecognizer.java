package com.ryszarddzegan.pouwaterhop;

import java.util.HashMap;

public class HoleRecognizer {
    private static final int SCALE_WIDTH = 32;
    private static final int SCALE_HEIGHT = 12;
    private final PixelHelperFactory pixelHelperFactory;
    private final ImageArea imageArea;
    private final int skyColor;
    private final int pontoonColor;

    public HoleRecognizer(PixelHelperFactory pixelHelperFactory, ImageArea imageArea) {
        this.pixelHelperFactory = pixelHelperFactory;
        this.imageArea = imageArea;
        skyColor = pixelHelperFactory.blue().getPixel();
        pontoonColor = pixelHelperFactory.red().getPixel();
    }

    public boolean isHole(Image image) {
        image = imageArea.getArea(image);
        image = image.scale(SCALE_WIDTH, SCALE_HEIGHT);
        reduceColors(image);
        image = removeRareColors(image);

        int[] pixels = image.getPixels();
        HashMap<Integer, Integer> colorsCount = getColorCounts(pixels);

        return getPrevalentPixel(colorsCount) == skyColor;
    }

    private void reduceColors(Image image) {
        final int colorsCount = 4;
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                int pixel = image.getPixel(x, y);
                PixelHelper pixelHelper = pixelHelperFactory.fromPixel(pixel);
                pixelHelper.reduce(colorsCount);
                int newPixel = pixelHelper.getPixel();
                image.setPixel(newPixel, x, y);
            }
        }
    }

    private Image removeRareColors(Image image) {
        Image newImage = image.clone();
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                int[] ambientPixels = getAmbientPixels(image, x, y);
                HashMap<Integer, Integer> colorCountsHashMap = getColorCounts(ambientPixels);
                int prevalentPixel = getPrevalentPixel(colorCountsHashMap);
                int standardColor = mapColorToPredefinedColor(prevalentPixel);
                newImage.setPixel(standardColor, x, y);
            }
        }
        return newImage;
    }

    private int[] getAmbientPixels(Image image, int x, int y) {
        final int SIZE = 4;

        if (image.getWidth() < SIZE)
            throw new IllegalArgumentException("Width must be greater than or equal 4.");

        if (image.getHeight() < SIZE)
            throw new IllegalArgumentException("Height must be greater than or equal 4.");

        int left = x - 2 > 0 ? x - 2 : 0;
        int top = y - 2 > 0 ? y - 2 : 0;

        if (left + SIZE > image.getWidth())
            left = image.getWidth() - SIZE;

        if (top + SIZE > image.getHeight())
            top = image.getHeight() - SIZE;

        int[] pixels = image.getPixels(left, top, SIZE, SIZE);
        return pixels;
    }

    private HashMap<Integer, Integer> getColorCounts(int[] ambientPixels) {
        HashMap<Integer, Integer> colorCountsHashMap = new HashMap<>();
        for (int pixel : ambientPixels) {
            if (!colorCountsHashMap.containsKey(pixel)) {
                colorCountsHashMap.put(pixel, 0);
                continue;
            }
            int count = colorCountsHashMap.get(pixel);
            colorCountsHashMap.put(pixel, count + 1);
        }
        return colorCountsHashMap;
    }

    private int getPrevalentPixel(HashMap<Integer, Integer> colorCountsHashMap) {
        int maxKey = -1;
        int maxValue = -1;
        for (Integer key : colorCountsHashMap.keySet()) {
            Integer value = colorCountsHashMap.get(key);
            if (value > maxValue) {
                maxKey = key;
                maxValue = value;
            }
        }
        return maxKey;
    }

    private int mapColorToPredefinedColor(int pixel) {
        PixelHelper pixelHelper = pixelHelperFactory.fromPixel(pixel);
        int r = pixelHelper.getRed();
        int b = pixelHelper.getBlue();

        if (r < 128 && b >= 128)
            return skyColor;

        return pontoonColor;
    }
}
