package com.ryszarddzegan.pouwaterhop;

public interface GameImageProvidedListener {
    /**
     * Camera prepares and returns and image.
     * The image is forwarded to image recognition
     * for the purpose of being translated into game state.
     */
    void onGameImageProvided(Image image);
}
