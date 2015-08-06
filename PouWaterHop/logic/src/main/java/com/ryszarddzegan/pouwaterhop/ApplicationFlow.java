package com.ryszarddzegan.pouwaterhop;

public class ApplicationFlow implements GameActionPerformedListener, GameStateRequiredListener, GameImageProvidedListener, GameStateChangedListener {
    private final GameActionRequiredListener gameActionRequiredListener;
    private final GameImageRequiredListener gameImageRequiredListener;
    private final GameStateRecognizer gameStateRecognizer;

    public ApplicationFlow(GameActionRequiredListener gameActionRequiredListener, GameImageRequiredListener gameImageRequiredListener, ImageRecognizer imageRecognizer) throws IllegalArgumentException {
        if (imageRecognizer == null)
            throw new IllegalArgumentException("imageRecognizer cannot be null");

        if (gameActionRequiredListener == null)
            throw new IllegalArgumentException("gameActionRequiredListener cannot be null");

        if (gameImageRequiredListener == null)
            throw new IllegalArgumentException("gameImageRequiredListener cannot be null");

        this.gameStateRecognizer = new GameStateRecognizer(imageRecognizer);
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
        GameState gameState = gameStateRecognizer.recognizeState(image);
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
