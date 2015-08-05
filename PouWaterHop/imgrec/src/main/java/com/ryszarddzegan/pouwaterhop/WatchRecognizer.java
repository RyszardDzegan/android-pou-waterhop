package com.ryszarddzegan.pouwaterhop;

import java.util.HashMap;

public class WatchRecognizer {
    private final ImageArea imageArea;
    private final ColorMapper colorMapper;

    public WatchRecognizer(ImageArea imageArea) {
        this.imageArea = imageArea;
        this.colorMapper = WatchColorMapper.getInstance();
    }

    public boolean isWatch(Image image) {
        image = imageArea.getArea(image);

        ColorsHelper.mapColors(image, colorMapper);
        HashMap<Integer, Integer> colorsCount = ColorsHelper.getColorCounts(image);

        Integer watches = colorsCount.get(StandardColors.red);
        Integer sky = colorsCount.get(StandardColors.blue);

        watches = (watches == null ? 0 : watches);
        sky = (sky == null ? 0 : sky);

        return watches > 15 && sky > watches;
    }
}
