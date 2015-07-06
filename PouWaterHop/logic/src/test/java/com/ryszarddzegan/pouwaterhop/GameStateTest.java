package com.ryszarddzegan.pouwaterhop;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class GameStateTest {
    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Test
    public void game_state_converts_value_to_correct_position_states_EMPTY_EMPTY() {
        final GameState sut = GameState.EMPTY_EMPTY;
        Assert.assertEquals("Value should be 0b0000.", sut.getValue(), 0b0000);
        Assert.assertEquals("Position 1 should be EMPTY.", sut.getPosition1(), PositionState.EMPTY);
        Assert.assertEquals("Position 2 should be EMPTY.", sut.getPosition2(), PositionState.EMPTY);
    }

    @Test
    public void game_state_converts_value_to_correct_position_states_EMPTY_HOLE() {
        final GameState sut = GameState.EMPTY_HOLE;
        Assert.assertEquals("Value should be 0b0001.", sut.getValue(), 0b0001);
        Assert.assertEquals("Position 1 should be EMPTY.", sut.getPosition1(), PositionState.EMPTY);
        Assert.assertEquals("Position 2 should be HOLE.", sut.getPosition2(), PositionState.HOLE);
    }

    @Test
    public void game_state_converts_value_to_correct_position_states_EMPTY_COIN() {
        final GameState sut = GameState.EMPTY_COIN;
        Assert.assertEquals("Value should be 0b0010.", sut.getValue(), 0b0010);
        Assert.assertEquals("Position 1 should be EMPTY.", sut.getPosition1(), PositionState.EMPTY);
        Assert.assertEquals("Position 2 should be COIN.", sut.getPosition2(), PositionState.COIN);
    }

    @Test
    public void game_state_converts_value_to_correct_position_states_EMPTY_CLOCK() {
        final GameState sut = GameState.EMPTY_CLOCK;
        Assert.assertEquals("Value should be 0b0011.", sut.getValue(), 0b0011);
        Assert.assertEquals("Position 1 should be EMPTY.", sut.getPosition1(), PositionState.EMPTY);
        Assert.assertEquals("Position 2 should be CLOCK.", sut.getPosition2(), PositionState.CLOCK);
    }

    @Test
    public void game_state_converts_value_to_correct_position_states_HOLE_EMPTY() {
        final GameState sut = GameState.HOLE_EMPTY;
        Assert.assertEquals("Value should be 0b0100.", sut.getValue(), 0b0100);
        Assert.assertEquals("Position 1 should be HOLE.", sut.getPosition1(), PositionState.HOLE);
        Assert.assertEquals("Position 2 should be EMPTY.", sut.getPosition2(), PositionState.EMPTY);
    }

    @Test
    public void game_state_converts_value_to_correct_position_states_HOLE_COIN() {
        final GameState sut = GameState.HOLE_COIN;
        Assert.assertEquals("Value should be 0b0110.", sut.getValue(), 0b0110);
        Assert.assertEquals("Position 1 should be HOLE.", sut.getPosition1(), PositionState.HOLE);
        Assert.assertEquals("Position 2 should be COIN.", sut.getPosition2(), PositionState.COIN);
    }

    @Test
    public void game_state_converts_value_to_correct_position_states_HOLE_CLOCK() {
        final GameState sut = GameState.HOLE_CLOCK;
        Assert.assertEquals("Value should be 0b0111.", sut.getValue(), 0b0111);
        Assert.assertEquals("Position 1 should be HOLE.", sut.getPosition1(), PositionState.HOLE);
        Assert.assertEquals("Position 2 should be CLOCK.", sut.getPosition2(), PositionState.CLOCK);
    }

    @Test
    public void game_state_converts_value_to_correct_position_states_COIN_EMPTY() {
        final GameState sut = GameState.COIN_EMPTY;
        Assert.assertEquals("Value should be 0b1000.", sut.getValue(), 0b1000);
        Assert.assertEquals("Position 1 should be COIN.", sut.getPosition1(), PositionState.COIN);
        Assert.assertEquals("Position 2 should be EMPTY.", sut.getPosition2(), PositionState.EMPTY);
    }

    @Test
    public void game_state_converts_value_to_correct_position_states_COIN_HOLE() {
        final GameState sut = GameState.COIN_HOLE;
        Assert.assertEquals("Value should be 0b1001.", sut.getValue(), 0b1001);
        Assert.assertEquals("Position 1 should be COIN.", sut.getPosition1(), PositionState.COIN);
        Assert.assertEquals("Position 2 should be HOLE.", sut.getPosition2(), PositionState.HOLE);
    }

    @Test
    public void game_state_converts_value_to_correct_position_states_COIN_COIN() {
        final GameState sut = GameState.COIN_COIN;
        Assert.assertEquals("Value should be 0b1010.", sut.getValue(), 0b1010);
        Assert.assertEquals("Position 1 should be COIN.", sut.getPosition1(), PositionState.COIN);
        Assert.assertEquals("Position 2 should be COIN.", sut.getPosition2(), PositionState.COIN);
    }

    @Test
    public void game_state_converts_value_to_correct_position_states_COIN_CLOCK() {
        final GameState sut = GameState.COIN_CLOCK;
        Assert.assertEquals("Value should be 0b1011.", sut.getValue(), 0b1011);
        Assert.assertEquals("Position 1 should be COIN.", sut.getPosition1(), PositionState.COIN);
        Assert.assertEquals("Position 2 should be CLOCK.", sut.getPosition2(), PositionState.CLOCK);
    }

    @Test
    public void game_state_converts_value_to_correct_position_states_CLOCK_EMPTY() {
        final GameState sut = GameState.CLOCK_EMPTY;
        Assert.assertEquals("Value should be 0b1100.", sut.getValue(), 0b1100);
        Assert.assertEquals("Position 1 should be CLOCK.", sut.getPosition1(), PositionState.CLOCK);
        Assert.assertEquals("Position 2 should be EMPTY.", sut.getPosition2(), PositionState.EMPTY);
    }

    @Test
    public void game_state_converts_value_to_correct_position_states_CLOCK_HOLE() {
        final GameState sut = GameState.CLOCK_HOLE;
        Assert.assertEquals("Value should be 0b1101.", sut.getValue(), 0b1101);
        Assert.assertEquals("Position 1 should be CLOCK.", sut.getPosition1(), PositionState.CLOCK);
        Assert.assertEquals("Position 2 should be HOLE.", sut.getPosition2(), PositionState.HOLE);
    }

    @Test
    public void game_state_converts_value_to_correct_position_states_CLOCK_COIN() {
        final GameState sut = GameState.CLOCK_COIN;
        Assert.assertEquals("Value should be 0b1110.", sut.getValue(), 0b1110);
        Assert.assertEquals("Position 1 should be CLOCK.", sut.getPosition1(), PositionState.CLOCK);
        Assert.assertEquals("Position 2 should be COIN.", sut.getPosition2(), PositionState.COIN);
    }

    @Test
    public void game_state_converts_value_to_correct_position_states_CLOCK_CLOCK() {
        final GameState sut = GameState.CLOCK_CLOCK;
        Assert.assertEquals("Value should be 0b1111.", sut.getValue(), 0b1111);
        Assert.assertEquals("Position 1 should be CLOCK.", sut.getPosition1(), PositionState.CLOCK);
        Assert.assertEquals("Position 2 should be CLOCK.", sut.getPosition2(), PositionState.CLOCK);
    }

    @Test
    public void game_state_is_valid_for_value_0b0000() {
        final GameState sut = GameState.fromValue(0b0000);
        Assert.assertEquals("Value should be EMPTY_EMPTY.", sut, GameState.EMPTY_EMPTY);
        Assert.assertEquals("Value should be 0b0000.", sut.getValue(), 0b0000);
        Assert.assertEquals("Position 1 should be EMPTY.", sut.getPosition1(), PositionState.EMPTY);
        Assert.assertEquals("Position 2 should be EMPTY.", sut.getPosition2(), PositionState.EMPTY);
    }

    @Test
    public void game_state_is_valid_for_value_0b0001() {
        final GameState sut = GameState.fromValue(0b0001);
        Assert.assertEquals("Value should be EMPTY_HOLE.", sut, GameState.EMPTY_HOLE);
        Assert.assertEquals("Value should be 0b0001.", sut.getValue(), 0b0001);
        Assert.assertEquals("Position 1 should be EMPTY.", sut.getPosition1(), PositionState.EMPTY);
        Assert.assertEquals("Position 2 should be HOLE.", sut.getPosition2(), PositionState.HOLE);
    }

    @Test
    public void game_state_is_valid_for_value_0b0010() {
        final GameState sut = GameState.fromValue(0b0010);
        Assert.assertEquals("Value should be EMPTY_COIN.", sut, GameState.EMPTY_COIN);
        Assert.assertEquals("Value should be 0b0010.", sut.getValue(), 0b0010);
        Assert.assertEquals("Position 1 should be EMPTY.", sut.getPosition1(), PositionState.EMPTY);
        Assert.assertEquals("Position 2 should be COIN.", sut.getPosition2(), PositionState.COIN);
    }

    @Test
    public void game_state_is_valid_for_value_0b0011() {
        final GameState sut = GameState.fromValue(0b0011);
        Assert.assertEquals("Value should be EMPTY_CLOCK.", sut, GameState.EMPTY_CLOCK);
        Assert.assertEquals("Value should be 0b0011.", sut.getValue(), 0b0011);
        Assert.assertEquals("Position 1 should be EMPTY.", sut.getPosition1(), PositionState.EMPTY);
        Assert.assertEquals("Position 2 should be CLOCK.", sut.getPosition2(), PositionState.CLOCK);
    }

    @Test
    public void game_state_is_valid_for_value_0b0100() {
        final GameState sut = GameState.fromValue(0b0100);
        Assert.assertEquals("Value should be HOLE_EMPTY.", sut, GameState.HOLE_EMPTY);
        Assert.assertEquals("Value should be 0b0100.", sut.getValue(), 0b0100);
        Assert.assertEquals("Position 1 should be HOLE.", sut.getPosition1(), PositionState.HOLE);
        Assert.assertEquals("Position 2 should be EMPTY.", sut.getPosition2(), PositionState.EMPTY);
    }

    @Test
    public void game_state_throws_exception_when_value_represents_two_holes() {
        thrown.expect(IllegalArgumentException.class);
        GameState.fromValue(0b0101);
    }

    @Test
     public void game_state_is_valid_for_value_0b0110() {
        final GameState sut = GameState.fromValue(0b0110);
        Assert.assertEquals("Value should be HOLE_COIN.", sut, GameState.HOLE_COIN);
        Assert.assertEquals("Value should be 0b0110.", sut.getValue(), 0b0110);
        Assert.assertEquals("Position 1 should be HOLE.", sut.getPosition1(), PositionState.HOLE);
        Assert.assertEquals("Position 2 should be COIN.", sut.getPosition2(), PositionState.COIN);
    }

    @Test
    public void game_state_is_valid_for_value_0b0111() {
        final GameState sut = GameState.fromValue(0b0111);
        Assert.assertEquals("Value should be HOLE_CLOCK.", sut, GameState.HOLE_CLOCK);
        Assert.assertEquals("Value should be 0b0111.", sut.getValue(), 0b0111);
        Assert.assertEquals("Position 1 should be HOLE.", sut.getPosition1(), PositionState.HOLE);
        Assert.assertEquals("Position 2 should be CLOCK.", sut.getPosition2(), PositionState.CLOCK);
    }

    @Test
    public void game_state_is_valid_for_value_0b1000() {
        final GameState sut = GameState.fromValue(0b1000);
        Assert.assertEquals("Value should be COIN_EMPTY.", sut, GameState.COIN_EMPTY);
        Assert.assertEquals("Value should be 0b1000.", sut.getValue(), 0b1000);
        Assert.assertEquals("Position 1 should be COIN.", sut.getPosition1(), PositionState.COIN);
        Assert.assertEquals("Position 2 should be EMPTY.", sut.getPosition2(), PositionState.EMPTY);
    }

    @Test
    public void game_state_is_valid_for_value_0b1001() {
        final GameState sut = GameState.fromValue(0b1001);
        Assert.assertEquals("Value should be COIN_HOLE.", sut, GameState.COIN_HOLE);
        Assert.assertEquals("Value should be 0b1001.", sut.getValue(), 0b1001);
        Assert.assertEquals("Position 1 should be COIN.", sut.getPosition1(), PositionState.COIN);
        Assert.assertEquals("Position 2 should be HOLE.", sut.getPosition2(), PositionState.HOLE);
    }

    @Test
    public void game_state_is_valid_for_value_0b1010() {
        final GameState sut = GameState.fromValue(0b1010);
        Assert.assertEquals("Value should be COIN_COIN.", sut, GameState.COIN_COIN);
        Assert.assertEquals("Value should be 0b1010.", sut.getValue(), 0b1010);
        Assert.assertEquals("Position 1 should be COIN.", sut.getPosition1(), PositionState.COIN);
        Assert.assertEquals("Position 2 should be COIN.", sut.getPosition2(), PositionState.COIN);
    }

    @Test
    public void game_state_is_valid_for_value_0b1011() {
        final GameState sut = GameState.fromValue(0b1011);
        Assert.assertEquals("Value should be COIN_CLOCK.", sut, GameState.COIN_CLOCK);
        Assert.assertEquals("Value should be 0b1011.", sut.getValue(), 0b1011);
        Assert.assertEquals("Position 1 should be COIN.", sut.getPosition1(), PositionState.COIN);
        Assert.assertEquals("Position 2 should be CLOCK.", sut.getPosition2(), PositionState.CLOCK);
    }

    @Test
    public void game_state_is_valid_for_value_0b1100() {
        final GameState sut = GameState.fromValue(0b1100);
        Assert.assertEquals("Value should be CLOCK_EMPTY.", sut, GameState.CLOCK_EMPTY);
        Assert.assertEquals("Value should be 0b1100.", sut.getValue(), 0b1100);
        Assert.assertEquals("Position 1 should be CLOCK.", sut.getPosition1(), PositionState.CLOCK);
        Assert.assertEquals("Position 2 should be EMPTY.", sut.getPosition2(), PositionState.EMPTY);
    }

    @Test
    public void game_state_is_valid_for_value_0b1101() {
        final GameState sut = GameState.fromValue(0b1101);
        Assert.assertEquals("Value should be CLOCK_HOLE.", sut, GameState.CLOCK_HOLE);
        Assert.assertEquals("Value should be 0b1101.", sut.getValue(), 0b1101);
        Assert.assertEquals("Position 1 should be CLOCK.", sut.getPosition1(), PositionState.CLOCK);
        Assert.assertEquals("Position 2 should be HOLE.", sut.getPosition2(), PositionState.HOLE);
    }

    @Test
    public void game_state_is_valid_for_value_0b1110() {
        final GameState sut = GameState.fromValue(0b1110);
        Assert.assertEquals("Value should be CLOCK_COIN.", sut, GameState.CLOCK_COIN);
        Assert.assertEquals("Value should be 0b1110.", sut.getValue(), 0b1110);
        Assert.assertEquals("Position 1 should be CLOCK.", sut.getPosition1(), PositionState.CLOCK);
        Assert.assertEquals("Position 2 should be COIN.", sut.getPosition2(), PositionState.COIN);
    }

    @Test
    public void game_state_is_valid_for_value_0b1111() {
        final GameState sut = GameState.fromValue(0b1111);
        Assert.assertEquals("Value should be CLOCK_CLOCK.", sut, GameState.CLOCK_CLOCK);
        Assert.assertEquals("Value should be 0b1111.", sut.getValue(), 0b1111);
        Assert.assertEquals("Position 1 should be CLOCK.", sut.getPosition1(), PositionState.CLOCK);
        Assert.assertEquals("Position 2 should be CLOCK.", sut.getPosition2(), PositionState.CLOCK);
    }

    @Test
    public void game_state_throws_exception_when_value_is_too_large() {
        thrown.expect(IndexOutOfBoundsException.class);
        GameState.fromValue(0b10000);
    }
}
