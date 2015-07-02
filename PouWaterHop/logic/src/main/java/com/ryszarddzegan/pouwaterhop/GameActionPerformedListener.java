package com.ryszarddzegan.pouwaterhop;

public interface GameActionPerformedListener {
    /**
     * UI confirms that the requested action has been performed
     * which means that game transits itself to a new state.
     * Control is being returned to the application flow controller.
     */
    void onGameActionPerformed();
}
