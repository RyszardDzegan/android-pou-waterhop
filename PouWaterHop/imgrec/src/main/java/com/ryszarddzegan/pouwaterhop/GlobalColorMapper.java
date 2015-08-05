package com.ryszarddzegan.pouwaterhop;

public class GlobalColorMapper implements ColorMapper {
    private static GlobalColorMapper instance = null;

    public static GlobalColorMapper getInstance() {
        if (instance == null) {
            instance = new GlobalColorMapper();
        }

        return instance;
    }

    protected GlobalColorMapper() {}

    @Override
    public int mapColor(int pixel) {
        switch (pixel) {
            case -16777216: // {0, 0, 0}
                return StandardColors.blue;
            case -16777088: // {0, 0, 128}
                return StandardColors.blue;
            case -16776961: // {0, 0, 255}
                return StandardColors.blue;
            case -16744320: // {0, 128, 128}
                return StandardColors.blue;
            case -16711681: // {0, 255, 255}
                return StandardColors.blue;
            case -8388480: // {128, 0, 128}
                return StandardColors.yellow;
            case -8355712: // {128, 128, 128}
                return StandardColors.yellow;
            case -8323328: // {128, 255, 0}
                return StandardColors.yellow;
            case -8323200: // {128, 255, 128}
                return StandardColors.yellow;
            case -8323073: // {128, 255, 255}
                return StandardColors.blue;
            case -65408: // {255, 0, 128}
                return StandardColors.yellow;
            case -65281: // {255, 0, 255}
                return StandardColors.yellow;
            case -32640: // {255, 128, 128}
                return StandardColors.yellow;
            case -128: // {255, 255, 128}
                return StandardColors.yellow;
            case -1: // {255, 255, 255}
                return StandardColors.yellow;
            default:
                return StandardColors.unknown;
        }
    }
}
