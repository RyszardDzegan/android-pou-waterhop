package com.ryszarddzegan.pouwaterhop;

public interface GameStateChangedListener {
    /**
     * Passes control to UI.
     * Allows to update UI view and show recognized game state.
     * Then UI asks for game action by raising GameActionRequiredListener.onGameActionRequired event.
     */
    void onGameStateChanged(GameState gameState);
}
