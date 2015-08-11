package com.ryszarddzegan.pouwaterhop;

public interface ImageRecognizer {
    Image prepareImageForRecognitionPreview1(Image image);
    Image prepareImageForRecognitionPreview2(Image image);
    Image prepareImageForRecognition(Image image);
    Image prepareImageForDisplay(Image image);
    boolean isPosition1Hole(Image image);
    boolean isPosition2Hole(Image image);
    boolean isPosition1Coin(Image image);
    boolean isPosition2Coin(Image image);
    boolean isPosition1Watch(Image image);
    boolean isPosition2Watch(Image image);
}
