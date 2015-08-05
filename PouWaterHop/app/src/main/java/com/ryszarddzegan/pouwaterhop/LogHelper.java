package com.ryszarddzegan.pouwaterhop;

import java.util.HashMap;

public class LogHelper {
    private LogHelper() {}

    public static String getPixelInfo(int pixel) {
        final int r = StaticPixelHelper.getRed(pixel);
        final int g = StaticPixelHelper.getGreen(pixel);
        final int b = StaticPixelHelper.getBlue(pixel);
        return String.format("%d = {%d, %d, %d}", pixel, r, g, b);
    }

    public static String getPixelsInfo(Image image) {
        StringBuilder infoBuilder = new StringBuilder();
        HashMap<Integer, Integer> colorCountsHashMap = ColorsHelper.getColorCounts(image);
        for (Integer key : colorCountsHashMap.keySet()) {
            String pixelDescription = getPixelInfo(key);
            String info = String.format("%s : %d\n", pixelDescription, colorCountsHashMap.get(key));
            infoBuilder.append(info);
        }
        return infoBuilder.toString();
    }
}
