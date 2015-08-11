package com.ryszarddzegan.pouwaterhop;

public interface GameActionRequiredListener {
    /**
     * Passes control to business logic.
     * Game action is computed based on provided game state.
     * Next, BL raises GameActionChangedListener.onGameActionChanged event.
     */
    void onGameActionRequired(GameState gameState);
}
