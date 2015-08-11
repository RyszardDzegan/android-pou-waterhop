package com.ryszarddzegan.pouwaterhop;

public enum GameState {
    EMPTY_EMPTY (0b0000),
    EMPTY_HOLE  (0b0001),
    EMPTY_COIN  (0b0010),
    EMPTY_CLOCK (0b0011),
    HOLE_EMPTY  (0b0100),
    HOLE_COIN   (0b0110),
    HOLE_CLOCK  (0b0111),
    COIN_EMPTY  (0b1000),
    COIN_HOLE   (0b1001),
    COIN_COIN   (0b1010),
    COIN_CLOCK  (0b1011),
    CLOCK_EMPTY (0b1100),
    CLOCK_HOLE  (0b1101),
    CLOCK_COIN  (0b1110),
    CLOCK_CLOCK (0b1111);

    private final int value;

    public int getValue() {
        return value;
    }

    public PositionState getPosition1() {
        return getPositionState((0b1100&value)>>2);
    }

    public PositionState getPosition2() {
        return getPositionState((0b0011&value)>>0);
    }

    GameState(int value) throws IllegalArgumentException {
        if (value == 0b0101)
            throw new IllegalArgumentException("Value cannot represent two holes.");

        this.value = value;
    }

    public static GameState fromValue(int value) throws IllegalArgumentException, IndexOutOfBoundsException {
        switch (value){
            case 0b0000:
                return EMPTY_EMPTY;
            case 0b0001:
                return EMPTY_HOLE;
            case 0b0010:
                return EMPTY_COIN;
            case 0b0011:
                return EMPTY_CLOCK;
            case 0b0100:
                return HOLE_EMPTY;
            case 0b0101:
                throw new IllegalArgumentException("Value cannot represent two holes.");
            case 0b0110:
                return HOLE_COIN;
            case 0b0111:
                return HOLE_CLOCK;
            case 0b1000:
                return COIN_EMPTY;
            case 0b1001:
                return COIN_HOLE;
            case 0b1010:
                return COIN_COIN;
            case 0b1011:
                return COIN_CLOCK;
            case 0b1100:
                return CLOCK_EMPTY;
            case 0b1101:
                return CLOCK_HOLE;
            case 0b1110:
                return CLOCK_COIN;
            case 0b1111:
                return CLOCK_CLOCK;
            default:
                throw new IndexOutOfBoundsException("Unknown game state.");
        }
    }

    private static PositionState getPositionState(int value) throws IndexOutOfBoundsException {
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

    @Override
    public String toString() {
        switch (value){
            case 0b0000:
                return "empty empty";
            case 0b0001:
                return "empty hole";
            case 0b0010:
                return "empty coin";
            case 0b0011:
                return "empty clock";
            case 0b0100:
                return "hole empty";
            case 0b0101:
                throw new IllegalArgumentException("Value cannot represent two holes.");
            case 0b0110:
                return "hole coin";
            case 0b0111:
                return "hole clock";
            case 0b1000:
                return "coin empty";
            case 0b1001:
                return "coin hole";
            case 0b1010:
                return "coin coin";
            case 0b1011:
                return "coin clock";
            case 0b1100:
                return "clock empty";
            case 0b1101:
                return "clock hole";
            case 0b1110:
                return "clock coin";
            case 0b1111:
                return "clock clock";
            default:
                throw new IndexOutOfBoundsException("Unknown game state.");
        }
    }
}
