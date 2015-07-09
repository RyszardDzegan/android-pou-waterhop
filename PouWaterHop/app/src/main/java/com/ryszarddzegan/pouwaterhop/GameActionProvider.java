package com.ryszarddzegan.pouwaterhop;

import android.app.Activity;

public class GameActionProvider implements GameActionRequiredListener {
    private final Activity activity;
    private final GameActionPerformedListener gameActionPerformedListener;

    public GameActionProvider(Activity activity, GameActionPerformedListener gameActionPerformedListener) {
        this.activity = activity;
        this.gameActionPerformedListener = gameActionPerformedListener;
    }

    @Override
    public void onGameActionRequired(GameAction gameAction) {
        // TODO: Perform an action on activity
        gameActionPerformedListener.onGameActionPerformed();
    }
}
