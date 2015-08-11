package com.ryszarddzegan.pouwaterhop;

public class ApplicationFlow implements GameActionRequiredListener, GameActionPerformedListener, GameImageProvidedListener {
    private final GameActionChangedListener gameActionChangedListener;
    private final GameImageRequiredListener gameImageRequiredListener;
    private final GameStateChangedListener gameStateChangedListener;
    private final GameStateRecognizer gameStateRecognizer;

    public ApplicationFlow(ImageRecognizer imageRecognizer, GameImageRequiredListener gameImageRequiredListener, GameStateChangedListener gameStateChangedListener, GameActionChangedListener gameActionChangedListener) throws IllegalArgumentException {
        if (imageRecognizer == null)
            throw new IllegalArgumentException("imageRecognizer cannot be null");

        if (gameImageRequiredListener == null)
            throw new IllegalArgumentException("gameImageRequiredListener cannot be null");

        if (gameStateChangedListener == null)
            throw new IllegalArgumentException("gameStateChangedListener cannot be null");

        if (gameActionChangedListener == null)
            throw new IllegalArgumentException("gameActionChangedListener cannot be null");

        this.gameStateRecognizer = new GameStateRecognizer(imageRecognizer);
        this.gameImageRequiredListener = gameImageRequiredListener;
        this.gameStateChangedListener = gameStateChangedListener;
        this.gameActionChangedListener = gameActionChangedListener;
    }

    @Override
    public void onGameActionPerformed() {
        gameImageRequiredListener.onGameImageRequired();
    }

    @Override
    public void onGameImageProvided(Image image) {
        GameState gameState = gameStateRecognizer.recognizeState(image);
        gameStateChangedListener.onGameStateChanged(gameState);
    }

    @Override
    public void onGameActionRequired(GameState gameState) {
        if (gameState.getPosition2() == PositionState.HOLE) {
            gameActionChangedListener.onGameActionChanged(GameAction.JUMP1);
            return;
        }

        if (gameState.getPosition1() == PositionState.HOLE) {
            gameActionChangedListener.onGameActionChanged(GameAction.JUMP2);
            return;
        }

        if (gameState.getPosition2() == PositionState.CLOCK) {
            gameActionChangedListener.onGameActionChanged(GameAction.JUMP2);
            return;
        }

        if (gameState.getPosition1() == PositionState.CLOCK) {
            gameActionChangedListener.onGameActionChanged(GameAction.JUMP1);
            return;
        }

        gameActionChangedListener.onGameActionChanged(GameAction.JUMP2);
    }
}
