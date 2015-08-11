package com.ryszarddzegan.pouwaterhop;

public interface GameImageProvidedListener {
    /**
     * Passes control to business logic.
     * Image recognition engine is being invoked in order to recognize game state
     * and then it calls GameStateChangedListener.onGameStateChanged event.
     */
    void onGameImageProvided(Image image);
}
