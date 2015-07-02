package com.ryszarddzegan.pouwaterhop;

public interface GameStateRequiredListener {
    /**
     * Passes control to the image recognition module
     * which in turn asks a camera for an image
     * that represents the current game state.
     */
    void onGameStateRequired();
}
