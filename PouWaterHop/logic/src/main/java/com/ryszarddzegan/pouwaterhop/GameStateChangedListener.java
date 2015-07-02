package com.ryszarddzegan.pouwaterhop;

public interface GameStateChangedListener {
    /**
     * Image recognition module invokes this method
     * after parsing the image representing the current game state.
     * Control is being returned to the application flow controller.
     */
    void onGameStateChanged(GameState gameState);
}
