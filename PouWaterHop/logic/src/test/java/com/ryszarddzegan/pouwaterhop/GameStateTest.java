package com.ryszarddzegan.pouwaterhop;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class GameStateTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void game_state_converts_value_to_correct_position_states_0b0000() {
        GameState sut = new GameState(0b0000);
        Assert.assertEquals("Position 1 should be EMPTY.", sut.getPosition1(), PositionState.EMPTY);
        Assert.assertEquals("Position 2 should be EMPTY.", sut.getPosition2(), PositionState.EMPTY);
    }

    @Test
    public void game_state_converts_value_to_correct_position_states_0b0110() {
        GameState sut = new GameState(0b0110);
        Assert.assertEquals("Position 1 should be HOLE.", sut.getPosition1(), PositionState.HOLE);
        Assert.assertEquals("Position 2 should be COIN.", sut.getPosition2(), PositionState.COIN);
    }

    @Test
    public void game_state_converts_value_to_correct_position_states_0b1100() {
        GameState sut = new GameState(0b1100);
        Assert.assertEquals("Position 1 should be CLOCK.", sut.getPosition1(), PositionState.CLOCK);
        Assert.assertEquals("Position 2 should be EMPTY.", sut.getPosition2(), PositionState.EMPTY);
    }

    @Test
     public void game_state_converts_position_states_to_correct_value_0b0000() {
        GameState sut = new GameState(PositionState.EMPTY, PositionState.EMPTY);
        Assert.assertEquals("Value should be 0b0000.", sut.getValue(), 0b0000);
    }

    @Test
    public void game_state_converts_position_states_to_correct_value_0b0110() {
        GameState sut = new GameState(PositionState.HOLE, PositionState.COIN);
        Assert.assertEquals("Value should be 0b0110.", sut.getValue(), 0b0110);
    }

    @Test
    public void game_state_converts_position_states_to_correct_value_0b1100() {
        GameState sut = new GameState(PositionState.CLOCK, PositionState.EMPTY);
        Assert.assertEquals("Value should be 0b1100.", sut.getValue(), 0b1100);
    }

    @Test
    public void game_state_throws_exception_when_value_represents_two_holes() {
        thrown.expect(IllegalArgumentException.class);
        new GameState(0b0101);
    }

    @Test
    public void game_state_throws_exception_when_both_position_states_represents_holes() {
        thrown.expect(IllegalArgumentException.class);
        new GameState(PositionState.HOLE, PositionState.HOLE);
    }
}
