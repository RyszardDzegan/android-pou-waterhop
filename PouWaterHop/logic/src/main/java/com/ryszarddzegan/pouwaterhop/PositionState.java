package com.ryszarddzegan.pouwaterhop;

public enum PositionState {
    EMPTY   (0b00),
    HOLE    (0b01),
    COIN    (0b10),
    CLOCK   (0b11);

    private final int value;

    public int getValue() {
        return value;
    }

    PositionState(int value) {
        this.value = value;
    }
}
