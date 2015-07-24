package com.ryszarddzegan.pouwaterhop;

public class ApplicationFlow implements GameActionPerformedListener, GameStateRequiredListener, GameImageProvidedListener, GameStateChangedListener {
    private final GameActionRequiredListener gameActionRequiredListener;
    private final GameImageRequiredListener gameImageRequiredListener;

    public ApplicationFlow(GameActionRequiredListener gameActionRequiredListener, GameImageRequiredListener gameImageRequiredListener) throws IllegalArgumentException {
        if (gameActionRequiredListener == null)
            throw new IllegalArgumentException("gameActionRequiredListener cannot be null");

        if (gameImageRequiredListener == null)
            throw new IllegalArgumentException("gameImageRequiredListener cannot be null");

        this.gameActionRequiredListener = gameActionRequiredListener;
        this.gameImageRequiredListener = gameImageRequiredListener;
    }

    @Override
    public void onGameActionPerformed() {
        onGameStateRequired();
    }

    @Override
    public void onGameStateRequired() {
        gameImageRequiredListener.onGameImageRequired();
    }

    @Override
    public void onGameImageProvided(Image image) {
        // TODO: Recognize image
        GameState gameState = GameState.CLOCK_EMPTY;
        onGameStateChanged(gameState);
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
}
