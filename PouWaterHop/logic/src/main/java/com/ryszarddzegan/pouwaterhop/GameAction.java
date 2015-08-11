package com.ryszarddzegan.pouwaterhop;

public enum GameAction {
    JUMP1,
    JUMP2;

    @Override
    public String toString() {
        switch (name()) {
            case "JUMP1":
                return "Jump 1";
            case "JUMP2":
                return "Jump 2";
            default:
                throw new IndexOutOfBoundsException("Unknown game action.");
        }
    }
}
