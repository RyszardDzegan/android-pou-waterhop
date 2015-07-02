package com.ryszarddzegan.pouwaterhop;

public interface GameActionRequiredListener {
    /**
     * Passes control to UI which notifies a user
     * that he should perform an action that is being indicated
     * as a parameter in this method.
     * After a user completes the action,
     * he confirms that fact by clicking a button so that
     * control can be returned to application flow controller.
     */
    void onGameActionRequired(GameAction gameAction);
}
