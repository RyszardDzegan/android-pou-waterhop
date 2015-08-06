package com.ryszarddzegan.pouwaterhop;

public class GameStateRecognizer {
    private final ImageRecognizer imageRecognizer;

    public GameStateRecognizer(ImageRecognizer imageRecognizer) {
        this.imageRecognizer = imageRecognizer;
    }

    public GameState recognizeState(Image image){
        image = imageRecognizer.prepareImageForRecognition(image);

        if (imageRecognizer.isPosition1Hole(image)) {
            if (imageRecognizer.isPosition2Hole(image)) {
                throw new IllegalArgumentException("Recognized a hole on both positions, which is an error.");
            }
            else if (imageRecognizer.isPosition2Coin(image)) {
                return GameState.HOLE_COIN;
            }
            else if (imageRecognizer.isPosition2Watch(image)) {
                return GameState.HOLE_CLOCK;
            }
            else {
                return GameState.HOLE_EMPTY;
            }
        }
        else if (imageRecognizer.isPosition1Coin(image)) {
            if (imageRecognizer.isPosition2Hole(image)) {
                return GameState.COIN_HOLE;
            }
            else if (imageRecognizer.isPosition2Coin(image)) {
                return GameState.COIN_COIN;
            }
            else if (imageRecognizer.isPosition2Watch(image)) {
                return GameState.COIN_CLOCK;
            }
            else {
                return GameState.COIN_EMPTY;
            }
        }
        else if (imageRecognizer.isPosition1Watch(image)) {
            if (imageRecognizer.isPosition2Hole(image)) {
                return GameState.CLOCK_HOLE;
            }
            else if (imageRecognizer.isPosition2Coin(image)) {
                return GameState.CLOCK_COIN;
            }
            else if (imageRecognizer.isPosition2Watch(image)) {
                return GameState.CLOCK_CLOCK;
            }
            else {
                return GameState.CLOCK_EMPTY;
            }
        }
        else {
            if (imageRecognizer.isPosition2Hole(image)) {
                return GameState.EMPTY_HOLE;
            }
            else if (imageRecognizer.isPosition2Coin(image)) {
                return GameState.EMPTY_COIN;
            }
            else if (imageRecognizer.isPosition2Watch(image)) {
                return GameState.EMPTY_CLOCK;
            }
            else {
                return GameState.EMPTY_EMPTY;
            }
        }
    }
}
