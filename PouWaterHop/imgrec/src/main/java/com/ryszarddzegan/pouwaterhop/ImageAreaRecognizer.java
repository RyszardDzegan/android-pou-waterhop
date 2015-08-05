package com.ryszarddzegan.pouwaterhop;

public class ImageAreaRecognizer {
    private final HoleRecognizer holeRecognizer;
    private final CoinRecognizer coinRecognizer;
    private final WatchRecognizer watchRecognizer;

    public ImageAreaRecognizer(ImageArea positionImageArea, ImageArea itemImageArea){
        holeRecognizer = new HoleRecognizer(positionImageArea);
        coinRecognizer = new CoinRecognizer(itemImageArea);
        watchRecognizer = new WatchRecognizer(itemImageArea);
    }

    public boolean isHole(Image image) {
        return holeRecognizer.isHole(image);
    }

    public boolean isCoin(Image image) {
        return coinRecognizer.isCoin(image);
    }

    public boolean isWatch(Image image) {
        return watchRecognizer.isWatch(image);
    }
}
