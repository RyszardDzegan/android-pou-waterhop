package com.ryszarddzegan.pouwaterhop;

public interface GameActionChangedListener {
    /**
     * Passes control to UI.
     * UI confirms performing the action by sending GameActionPerformedListener.onGameActionPerformed event.
     */
    void onGameActionChanged(GameAction gameAction);
}
