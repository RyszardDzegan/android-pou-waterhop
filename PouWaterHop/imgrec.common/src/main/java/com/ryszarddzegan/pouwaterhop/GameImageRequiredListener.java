package com.ryszarddzegan.pouwaterhop;

public interface GameImageRequiredListener {
    /**
     * That method should call device's camera
     * in order to get the actual picture of game state.
     */
    void onGameImageRequired();
}
