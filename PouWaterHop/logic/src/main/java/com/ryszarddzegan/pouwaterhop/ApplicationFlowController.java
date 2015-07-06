package com.ryszarddzegan.pouwaterhop;

public class ApplicationFlowController implements GameStateChangedListener, GameActionPerformedListener {
    private final GameActionRequiredListener gameActionRequiredListener;
    private final GameStateRequiredListener gameStateRequiredListener;

    public ApplicationFlowController(GameActionRequiredListener gameActionRequiredListener, GameStateRequiredListener gameStateRequiredListener) throws IllegalArgumentException {
        if (gameActionRequiredListener == null)
            throw new IllegalArgumentException("gameActionRequiredListener cannot be null");

        if (gameStateRequiredListener == null)
            throw new IllegalArgumentException("gameStateRequiredListener cannot be null");

        this.gameActionRequiredListener = gameActionRequiredListener;
        this.gameStateRequiredListener = gameStateRequiredListener;
    }

    @Override
    public void onGameStateChanged(GameState gameState) {
        if (gameState.getPosition2() == PositionState.HOLE) {
            gameActionRequiredListener.onGameActionRequired(GameAction.JUMP1);
            return;
        }

        if (gameState.getPosition1() == PositionState.HOLE) {
            gameActionRequiredListener.onGameActionRequired(GameAction.JUMP2);
            return;
        }

        if (gameState.getPosition2() == PositionState.CLOCK) {
            gameActionRequiredListener.onGameActionRequired(GameAction.JUMP2);
            return;
        }

        if (gameState.getPosition1() == PositionState.CLOCK) {
            gameActionRequiredListener.onGameActionRequired(GameAction.JUMP1);
            return;
        }

        gameActionRequiredListener.onGameActionRequired(GameAction.JUMP2);
    }

    @Override
    public void onGameActionPerformed() {
        gameStateRequiredListener.onGameStateRequired();
    }
}
