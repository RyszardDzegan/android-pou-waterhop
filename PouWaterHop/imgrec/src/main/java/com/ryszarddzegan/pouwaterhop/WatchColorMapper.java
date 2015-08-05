package com.ryszarddzegan.pouwaterhop;

public class WatchColorMapper extends GlobalColorMapper {
    private static WatchColorMapper instance = null;

    public static WatchColorMapper getInstance() {
        if (instance == null) {
            instance = new WatchColorMapper();
        }

        return instance;
    }

    private WatchColorMapper() {}

    @Override
    public int mapColor(int pixel) {
        switch (pixel) {
            case -8323073: // {128, 255, 255}
                return StandardColors.red;
            case -65281: // {255, 0, 255}
                return StandardColors.red;
            case -1: // {255, 255, 255}
                return StandardColors.red;
            default:
                return super.mapColor(pixel);
        }
    }
}