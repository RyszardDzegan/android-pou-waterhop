package com.ryszarddzegan.pouwaterhop;

public interface GameActionPerformedListener {
    /**
     * Passes control to business logic.
     * Business logic starts over the flow asking for an image to recognize with GameImageRequiredListener.onGameImageRequired event.
     */
    void onGameActionPerformed();
}
