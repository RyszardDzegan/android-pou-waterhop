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
            case 0xFF008000: // {0, 128, 0}
                return StandardColors.blue;
            case -16744320: // {0, 128, 128}
                return StandardColors.blue;
            case 0xFF0080FF: // {0, 128, 255}
                return StandardColors.blue;
            case -16711808: // {0, 255, 128}
                return StandardColors.yellow;
            case -16711681: // {0, 255, 255}
                return StandardColors.blue;
            case -8388608: // {128, 0, 0}
                return StandardColors.yellow;
            case -8388480: // {128, 0, 128}
                return StandardColors.yellow;
            case -8388353: // {128, 0, 255}
                return StandardColors.blue;
            case 0xFF808000: // {128, 128, 0}
                return StandardColors.yellow;
            case -8355712: // {128, 128, 128}
                return StandardColors.unknown;
            case 0xFF8080FF: // {128, 128, 255}
                return StandardColors.blue;
            case -8323328: // {128, 255, 0}
                return StandardColors.yellow;
            case -8323200: // {128, 255, 128}
                return StandardColors.unknown;
            case -8323073: // {128, 255, 255}
                return StandardColors.blue;
            case 0xFFFF0000: // {255, 0, 0}
                return StandardColors.yellow;
            case -65408: // {255, 0, 128}
                return StandardColors.yellow;
            case -65281: // {255, 0, 255}
                return StandardColors.yellow;
            case 0xFFFF8000: // {255, 128, 0}
                return StandardColors.yellow;
            case -32640: // {255, 128, 128}
                return StandardColors.yellow;
            case 0xFFFFFF00: // {255, 255, 0}
                return StandardColors.yellow;
            case -128: // {255, 255, 128}
                return StandardColors.yellow;
            case -1: // {255, 255, 255}
                return StandardColors.unknown;
            default:
                return StandardColors.unknown;
        }
    }
}
