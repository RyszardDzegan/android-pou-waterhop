package com.ryszarddzegan.pouwaterhop;

import java.util.HashMap;

public class CoinRecognizer {
    private final ImageArea imageArea;
    private final ColorMapper colorMapper;

    public CoinRecognizer(ImageArea imageArea) {
        this.imageArea = imageArea;
        this.colorMapper = CoinColorMapper.getInstance();
    }

    public boolean isCoin(Image image) {
        image = imageArea.getArea(image);

        ColorsHelper.mapColors(image, colorMapper);
        HashMap<Integer, Integer> colorsCount = ColorsHelper.getColorCounts(image);

        Integer coins = colorsCount.get(StandardColors.red);
        Integer sky = colorsCount.get(StandardColors.blue);

        coins = (coins == null ? 0 : coins);
        sky = (sky == null ? 0 : sky);

        return coins > 15 && sky > coins;
    }
}
