package com.ryszarddzegan.pouwaterhop;

import java.util.HashMap;

public class ColorsHelper {
    private ColorsHelper() {}

    public static HashMap<Integer, Integer> getColorCounts(Image image) {
        int[] pixels = image.getPixels();
        return getColorCounts(pixels);
    }

    public static HashMap<Integer, Integer> getColorCounts(int[] ambientPixels) {
        HashMap<Integer, Integer> colorCountsHashMap = new HashMap<>();
        for (int pixel : ambientPixels) {
            if (!colorCountsHashMap.containsKey(pixel)) {
                colorCountsHashMap.put(pixel, 1);
                continue;
            }
            int count = colorCountsHashMap.get(pixel);
            colorCountsHashMap.put(pixel, count + 1);
        }
        return colorCountsHashMap;
    }

    public static int getPrevalentPixel(Image image) {
        HashMap<Integer, Integer> colorCountsHashMap = getColorCounts(image);
        return getPrevalentPixel(colorCountsHashMap);
    }

    public static int getPrevalentPixel(HashMap<Integer, Integer> colorCountsHashMap) {
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

    public static void mapColors(Image image, ColorMapper colorMapper) {
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                int pixel = image.getPixel(x, y);
                int mappedPixel = colorMapper.mapColor(pixel);
                image.setPixel(mappedPixel, x, y);
            }
        }
    }

    public static String getPixelsInfo(Image image, PixelHelper pixelHelper) {
        StringBuilder infoBuilder = new StringBuilder();
        HashMap<Integer, Integer> colorCountsHashMap = ColorsHelper.getColorCounts(image);
        for (Integer key : colorCountsHashMap.keySet()) {
            String pixelDescription = getPixelInfo(key, pixelHelper);
            String info = String.format("%s : %d\n", pixelDescription, colorCountsHashMap.get(key));
            infoBuilder.append(info);
        }
        return infoBuilder.toString();
    }

    public static String getPixelInfo(int pixel, PixelHelper pixelHelper) {
        final int r = pixelHelper.red(pixel);
        final int g = pixelHelper.green(pixel);
        final int b = pixelHelper.blue(pixel);
        return String.format("%d = {%d, %d, %d}", pixel, r, g, b);
    }
}
