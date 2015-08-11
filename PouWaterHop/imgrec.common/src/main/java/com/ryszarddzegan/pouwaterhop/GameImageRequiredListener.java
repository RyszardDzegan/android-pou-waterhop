package com.ryszarddzegan.pouwaterhop;

public interface GameImageRequiredListener {
    /**
     * Passes control to UI.
     * UI invokes camera object to get an image.
     * Then it invokes GameImageProvidedListener.onGameImageProvided event
     */
    void onGameImageRequired();
}
