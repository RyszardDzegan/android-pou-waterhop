package com.ryszarddzegan.pouwaterhop;

public class GameState {
    private int value;

    public int getValue() {
        return value;
    }

    public PositionState getPosition1() {
        return getPositionState((0b1100&value)>>2);
    }

    public PositionState getPosition2() {
        return getPositionState((0b0011&value)>>0);
    }

    public GameState(int value) throws IllegalArgumentException {
        if (value == 0b0101)
            throw new IllegalArgumentException("Value cannot represent two holes.");

        this.value = value;
    }

    public GameState(PositionState position1, PositionState position2) throws IllegalArgumentException {
        if (position1 == PositionState.HOLE && position2 == PositionState.HOLE)
            throw new IllegalArgumentException("Both positions cannot represent a hole.");

        this.value = (position1.getValue()<<2)|(position2.getValue()<<0);
    }

    private PositionState getPositionState(int value) throws IndexOutOfBoundsException {
        switch (value) {
            case 0x0:
                return PositionState.EMPTY;
            case 0x1:
                return PositionState.HOLE;
            case 0x2:
                return PositionState.COIN;
            case 0x3:
                return PositionState.CLOCK;
            default:
                throw new IndexOutOfBoundsException("Unknown position state.");
        }
    }
}
