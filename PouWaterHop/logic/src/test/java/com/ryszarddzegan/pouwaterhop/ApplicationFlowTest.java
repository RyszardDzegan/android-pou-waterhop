package com.ryszarddzegan.pouwaterhop;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class ApplicationFlowTest {
    private GameActionChangedListener gameActionChangedListener;
    private ApplicationFlow applicationFlow;
            
    @Before
    public void before() {
        final ImageRecognizer imageRecognizer = mock(ImageRecognizer.class);
        final GameImageRequiredListener gameImageRequiredListener = mock(GameImageRequiredListener.class);
        final GameStateChangedListener gameStateChangedListener = mock(GameStateChangedListener.class);
        gameActionChangedListener = mock(GameActionChangedListener.class);
        applicationFlow = new ApplicationFlow(imageRecognizer, gameImageRequiredListener, gameStateChangedListener, gameActionChangedListener);
    }
    
    @Test
    public void Game_state_EMPTY_EMPTY_implicates_JUMP2_action() {
        applicationFlow.onGameActionRequired(GameState.EMPTY_EMPTY);
        verify(gameActionChangedListener).onGameActionChanged(GameAction.JUMP2);
    }

    @Test
    public void Game_state_EMPTY_HOLE_implicates_JUMP1_action() {
        applicationFlow.onGameActionRequired(GameState.EMPTY_HOLE);
        verify(gameActionChangedListener).onGameActionChanged(GameAction.JUMP1);
    }

    @Test
    public void Game_state_EMPTY_COIN_implicates_JUMP2_action() {
        applicationFlow.onGameActionRequired(GameState.EMPTY_COIN);
        verify(gameActionChangedListener).onGameActionChanged(GameAction.JUMP2);
    }

    @Test
    public void Game_state_EMPTY_CLOCK_implicates_JUMP2_action() {
        applicationFlow.onGameActionRequired(GameState.EMPTY_CLOCK);
        verify(gameActionChangedListener).onGameActionChanged(GameAction.JUMP2);
    }

    @Test
    public void Game_state_HOLE_EMPTY_implicates_JUMP2_action() {
        applicationFlow.onGameActionRequired(GameState.HOLE_EMPTY);
        verify(gameActionChangedListener).onGameActionChanged(GameAction.JUMP2);
    }

    @Test
    public void Game_state_HOLE_COIN_implicates_JUMP2_action() {
        applicationFlow.onGameActionRequired(GameState.HOLE_COIN);
        verify(gameActionChangedListener).onGameActionChanged(GameAction.JUMP2);
    }

    @Test
    public void Game_state_HOLE_CLOCK_implicates_JUMP2_action() {
        applicationFlow.onGameActionRequired(GameState.HOLE_CLOCK);
        verify(gameActionChangedListener).onGameActionChanged(GameAction.JUMP2);
    }

    @Test
    public void Game_state_COIN_EMPTY_implicates_JUMP2_action() {
        applicationFlow.onGameActionRequired(GameState.COIN_EMPTY);
        verify(gameActionChangedListener).onGameActionChanged(GameAction.JUMP2);
    }

    @Test
    public void Game_state_COIN_HOLE_implicates_JUMP1_action() {
        applicationFlow.onGameActionRequired(GameState.COIN_HOLE);
        verify(gameActionChangedListener).onGameActionChanged(GameAction.JUMP1);
    }

    @Test
    public void Game_state_COIN_COIN_implicates_JUMP2_action() {
        applicationFlow.onGameActionRequired(GameState.COIN_COIN);
        verify(gameActionChangedListener).onGameActionChanged(GameAction.JUMP2);
    }

    @Test
    public void Game_state_COIN_CLOCK_implicates_JUMP2_action() {
        applicationFlow.onGameActionRequired(GameState.COIN_CLOCK);
        verify(gameActionChangedListener).onGameActionChanged(GameAction.JUMP2);
    }

    @Test
    public void Game_state_CLOCK_EMPTY_implicates_JUMP1_action() {
        applicationFlow.onGameActionRequired(GameState.CLOCK_EMPTY);
        verify(gameActionChangedListener).onGameActionChanged(GameAction.JUMP1);
    }

    @Test
    public void Game_state_CLOCK_HOLE_implicates_JUMP1_action() {
        applicationFlow.onGameActionRequired(GameState.CLOCK_HOLE);
        verify(gameActionChangedListener).onGameActionChanged(GameAction.JUMP1);
    }

    @Test
    public void Game_state_CLOCK_COIN_implicates_JUMP1_action() {
        applicationFlow.onGameActionRequired(GameState.CLOCK_COIN);
        verify(gameActionChangedListener).onGameActionChanged(GameAction.JUMP1);
    }

    @Test
    public void Game_state_CLOCK_CLOCK_implicates_JUMP2_action() {
        applicationFlow.onGameActionRequired(GameState.CLOCK_CLOCK);
        verify(gameActionChangedListener).onGameActionChanged(GameAction.JUMP2);
    }
}
