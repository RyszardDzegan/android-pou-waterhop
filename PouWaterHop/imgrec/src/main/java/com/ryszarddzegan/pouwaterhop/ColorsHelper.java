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
}
