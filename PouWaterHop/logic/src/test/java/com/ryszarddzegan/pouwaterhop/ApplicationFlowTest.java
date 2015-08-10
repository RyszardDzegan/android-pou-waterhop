package com.ryszarddzegan.pouwaterhop;

import static org.mockito.Mockito.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ApplicationFlowTest {
    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Test
    public void Constructor_throws_exception_when_first_argument_is_null() {
        thrown.expect(IllegalArgumentException.class);
        final GameImageRequiredListener gameImageRequiredListener = mock(GameImageRequiredListener.class);
        final ImageRecognizer imageRecognizer = mock(ImageRecognizer.class);
        new ApplicationFlow(null, gameImageRequiredListener, imageRecognizer);
    }

    @Test
    public void Constructor_throws_exception_when_second_argument_is_null() {
        thrown.expect(IllegalArgumentException.class);
        final GameActionRequiredListener gameActionRequiredListener = mock(GameActionRequiredListener.class);
        final ImageRecognizer imageRecognizer = mock(ImageRecognizer.class);
        new ApplicationFlow(gameActionRequiredListener, null, imageRecognizer);
    }

    @Test
    public void Game_state_EMPTY_EMPTY_implicates_JUMP2_action() {
        final GameActionRequiredListener gameActionRequiredListener = mock(GameActionRequiredListener.class);
        final GameImageRequiredListener gameImageRequiredListener = mock(GameImageRequiredListener.class);
        final ImageRecognizer imageRecognizer = mock(ImageRecognizer.class);
        final ApplicationFlow sut = new ApplicationFlow(gameActionRequiredListener, gameImageRequiredListener, imageRecognizer);
        sut.onGameStateChanged(GameState.EMPTY_EMPTY);
        verify(gameActionRequiredListener).onGameActionRequired(GameAction.JUMP2);
    }

    @Test
    public void Game_state_EMPTY_HOLE_implicates_JUMP1_action() {
        final GameActionRequiredListener gameActionRequiredListener = mock(GameActionRequiredListener.class);
        final GameImageRequiredListener gameImageRequiredListener = mock(GameImageRequiredListener.class);
        final ImageRecognizer imageRecognizer = mock(ImageRecognizer.class);
        final ApplicationFlow sut = new ApplicationFlow(gameActionRequiredListener, gameImageRequiredListener, imageRecognizer);
        sut.onGameStateChanged(GameState.EMPTY_HOLE);
        verify(gameActionRequiredListener).onGameActionRequired(GameAction.JUMP1);
    }

    @Test
    public void Game_state_EMPTY_COIN_implicates_JUMP2_action() {
        final GameActionRequiredListener gameActionRequiredListener = mock(GameActionRequiredListener.class);
        final GameImageRequiredListener gameImageRequiredListener = mock(GameImageRequiredListener.class);
        final ImageRecognizer imageRecognizer = mock(ImageRecognizer.class);
        final ApplicationFlow sut = new ApplicationFlow(gameActionRequiredListener, gameImageRequiredListener, imageRecognizer);
        sut.onGameStateChanged(GameState.EMPTY_COIN);
        verify(gameActionRequiredListener).onGameActionRequired(GameAction.JUMP2);
    }

    @Test
    public void Game_state_EMPTY_CLOCK_implicates_JUMP2_action() {
        final GameActionRequiredListener gameActionRequiredListener = mock(GameActionRequiredListener.class);
        final GameImageRequiredListener gameImageRequiredListener = mock(GameImageRequiredListener.class);
        final ImageRecognizer imageRecognizer = mock(ImageRecognizer.class);
        final ApplicationFlow sut = new ApplicationFlow(gameActionRequiredListener, gameImageRequiredListener, imageRecognizer);
        sut.onGameStateChanged(GameState.EMPTY_CLOCK);
        verify(gameActionRequiredListener).onGameActionRequired(GameAction.JUMP2);
    }

    @Test
    public void Game_state_HOLE_EMPTY_implicates_JUMP2_action() {
        final GameActionRequiredListener gameActionRequiredListener = mock(GameActionRequiredListener.class);
        final GameImageRequiredListener gameImageRequiredListener = mock(GameImageRequiredListener.class);
        final ImageRecognizer imageRecognizer = mock(ImageRecognizer.class);
        final ApplicationFlow sut = new ApplicationFlow(gameActionRequiredListener, gameImageRequiredListener, imageRecognizer);
        sut.onGameStateChanged(GameState.HOLE_EMPTY);
        verify(gameActionRequiredListener).onGameActionRequired(GameAction.JUMP2);
    }

    @Test
    public void Game_state_HOLE_COIN_implicates_JUMP2_action() {
        final GameActionRequiredListener gameActionRequiredListener = mock(GameActionRequiredListener.class);
        final GameImageRequiredListener gameImageRequiredListener = mock(GameImageRequiredListener.class);
        final ImageRecognizer imageRecognizer = mock(ImageRecognizer.class);
        final ApplicationFlow sut = new ApplicationFlow(gameActionRequiredListener, gameImageRequiredListener, imageRecognizer);
        sut.onGameStateChanged(GameState.HOLE_COIN);
        verify(gameActionRequiredListener).onGameActionRequired(GameAction.JUMP2);
    }

    @Test
    public void Game_state_HOLE_CLOCK_implicates_JUMP2_action() {
        final GameActionRequiredListener gameActionRequiredListener = mock(GameActionRequiredListener.class);
        final GameImageRequiredListener gameImageRequiredListener = mock(GameImageRequiredListener.class);
        final ImageRecognizer imageRecognizer = mock(ImageRecognizer.class);
        final ApplicationFlow sut = new ApplicationFlow(gameActionRequiredListener, gameImageRequiredListener, imageRecognizer);
        sut.onGameStateChanged(GameState.HOLE_CLOCK);
        verify(gameActionRequiredListener).onGameActionRequired(GameAction.JUMP2);
    }

    @Test
    public void Game_state_COIN_EMPTY_implicates_JUMP2_action() {
        final GameActionRequiredListener gameActionRequiredListener = mock(GameActionRequiredListener.class);
        final GameImageRequiredListener gameImageRequiredListener = mock(GameImageRequiredListener.class);
        final ImageRecognizer imageRecognizer = mock(ImageRecognizer.class);
        final ApplicationFlow sut = new ApplicationFlow(gameActionRequiredListener, gameImageRequiredListener, imageRecognizer);
        sut.onGameStateChanged(GameState.COIN_EMPTY);
        verify(gameActionRequiredListener).onGameActionRequired(GameAction.JUMP2);
    }

    @Test
    public void Game_state_COIN_HOLE_implicates_JUMP1_action() {
        final GameActionRequiredListener gameActionRequiredListener = mock(GameActionRequiredListener.class);
        final GameImageRequiredListener gameImageRequiredListener = mock(GameImageRequiredListener.class);
        final ImageRecognizer imageRecognizer = mock(ImageRecognizer.class);
        final ApplicationFlow sut = new ApplicationFlow(gameActionRequiredListener, gameImageRequiredListener, imageRecognizer);
        sut.onGameStateChanged(GameState.COIN_HOLE);
        verify(gameActionRequiredListener).onGameActionRequired(GameAction.JUMP1);
    }

    @Test
    public void Game_state_COIN_COIN_implicates_JUMP2_action() {
        final GameActionRequiredListener gameActionRequiredListener = mock(GameActionRequiredListener.class);
        final GameImageRequiredListener gameImageRequiredListener = mock(GameImageRequiredListener.class);
        final ImageRecognizer imageRecognizer = mock(ImageRecognizer.class);
        final ApplicationFlow sut = new ApplicationFlow(gameActionRequiredListener, gameImageRequiredListener, imageRecognizer);
        sut.onGameStateChanged(GameState.COIN_COIN);
        verify(gameActionRequiredListener).onGameActionRequired(GameAction.JUMP2);
    }

    @Test
    public void Game_state_COIN_CLOCK_implicates_JUMP2_action() {
        final GameActionRequiredListener gameActionRequiredListener = mock(GameActionRequiredListener.class);
        final GameImageRequiredListener gameImageRequiredListener = mock(GameImageRequiredListener.class);
        final ImageRecognizer imageRecognizer = mock(ImageRecognizer.class);
        final ApplicationFlow sut = new ApplicationFlow(gameActionRequiredListener, gameImageRequiredListener, imageRecognizer);
        sut.onGameStateChanged(GameState.COIN_CLOCK);
        verify(gameActionRequiredListener).onGameActionRequired(GameAction.JUMP2);
    }

    @Test
    public void Game_state_CLOCK_EMPTY_implicates_JUMP1_action() {
        final GameActionRequiredListener gameActionRequiredListener = mock(GameActionRequiredListener.class);
        final GameImageRequiredListener gameImageRequiredListener = mock(GameImageRequiredListener.class);
        final ImageRecognizer imageRecognizer = mock(ImageRecognizer.class);
        final ApplicationFlow sut = new ApplicationFlow(gameActionRequiredListener, gameImageRequiredListener, imageRecognizer);
        sut.onGameStateChanged(GameState.CLOCK_EMPTY);
        verify(gameActionRequiredListener).onGameActionRequired(GameAction.JUMP1);
    }

    @Test
    public void Game_state_CLOCK_HOLE_implicates_JUMP1_action() {
        final GameActionRequiredListener gameActionRequiredListener = mock(GameActionRequiredListener.class);
        final GameImageRequiredListener gameImageRequiredListener = mock(GameImageRequiredListener.class);
        final ImageRecognizer imageRecognizer = mock(ImageRecognizer.class);
        final ApplicationFlow sut = new ApplicationFlow(gameActionRequiredListener, gameImageRequiredListener, imageRecognizer);
        sut.onGameStateChanged(GameState.CLOCK_HOLE);
        verify(gameActionRequiredListener).onGameActionRequired(GameAction.JUMP1);
    }

    @Test
    public void Game_state_CLOCK_COIN_implicates_JUMP1_action() {
        final GameActionRequiredListener gameActionRequiredListener = mock(GameActionRequiredListener.class);
        final GameImageRequiredListener gameImageRequiredListener = mock(GameImageRequiredListener.class);
        final ImageRecognizer imageRecognizer = mock(ImageRecognizer.class);
        final ApplicationFlow sut = new ApplicationFlow(gameActionRequiredListener, gameImageRequiredListener, imageRecognizer);
        sut.onGameStateChanged(GameState.CLOCK_COIN);
        verify(gameActionRequiredListener).onGameActionRequired(GameAction.JUMP1);
    }

    @Test
    public void Game_state_CLOCK_CLOCK_implicates_JUMP2_action() {
        final GameActionRequiredListener gameActionRequiredListener = mock(GameActionRequiredListener.class);
        final GameImageRequiredListener gameImageRequiredListener = mock(GameImageRequiredListener.class);
        final ImageRecognizer imageRecognizer = mock(ImageRecognizer.class);
        final ApplicationFlow sut = new ApplicationFlow(gameActionRequiredListener, gameImageRequiredListener, imageRecognizer);
        sut.onGameStateChanged(GameState.CLOCK_CLOCK);
        verify(gameActionRequiredListener).onGameActionRequired(GameAction.JUMP2);
    }

    @Test
    public void Game_action_performed_confirmation_implicates_game_state_request() {
        final GameActionRequiredListener gameActionRequiredListener = mock(GameActionRequiredListener.class);
        final GameImageRequiredListener gameImageRequiredListener = mock(GameImageRequiredListener.class);
        final ImageRecognizer imageRecognizer = mock(ImageRecognizer.class);
        final ApplicationFlow sut = new ApplicationFlow(gameActionRequiredListener, gameImageRequiredListener, imageRecognizer);
        sut.onGameActionPerformed();
        verify(gameImageRequiredListener).onGameImageRequired();
    }
}
