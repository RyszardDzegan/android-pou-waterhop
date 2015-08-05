package com.ryszarddzegan.pouwaterhop;

public class HoleColorMapper extends GlobalColorMapper {
    private static HoleColorMapper instance = null;

    public static HoleColorMapper getInstance() {
        if (instance == null) {
            instance = new HoleColorMapper();
        }

        return instance;
    }

    private HoleColorMapper() {}

    @Override
    public int mapColor(int pixel) {
        return super.mapColor(pixel);
    }
}
