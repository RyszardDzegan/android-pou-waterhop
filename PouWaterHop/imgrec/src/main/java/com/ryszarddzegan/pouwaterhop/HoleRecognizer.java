package com.ryszarddzegan.pouwaterhop;

public class HoleRecognizer {
    private final ImageArea imageArea;
    private final ColorMapper colorMapper;

    public HoleRecognizer(ImageArea imageArea) {
        this.imageArea = imageArea;
        this.colorMapper = HoleColorMapper.getInstance();
    }

    public boolean isHole(Image image) {
        image = imageArea.getArea(image);
        ColorsHelper.mapColors(image, colorMapper);
        return ColorsHelper.getPrevalentPixel(image) == StandardColors.blue;
    }
}
