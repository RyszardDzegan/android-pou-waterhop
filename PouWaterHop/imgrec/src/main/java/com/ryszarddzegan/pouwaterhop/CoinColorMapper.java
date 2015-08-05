package com.ryszarddzegan.pouwaterhop;

public class CoinColorMapper extends GlobalColorMapper {
    private static CoinColorMapper instance = null;

    public static CoinColorMapper getInstance() {
        if (instance == null) {
            instance = new CoinColorMapper();
        }

        return instance;
    }

    private CoinColorMapper() {}

    @Override
    public int mapColor(int pixel) {
        switch (pixel) {
            case -8388480: // {128, 0, 128}
                return StandardColors.red;
            case -8355712: // {128, 128, 128}
                return StandardColors.red;
            case -65408: // {255, 0, 128}
                return StandardColors.red;
            default:
                return super.mapColor(pixel);
        }
    }
}
