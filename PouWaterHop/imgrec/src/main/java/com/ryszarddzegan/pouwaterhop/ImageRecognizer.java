package com.ryszarddzegan.pouwaterhop;

public class ImageRecognizer {
    private static final int MIN_WIDTH = 64;
    private static final int MIN_HEIGHT = 48;

    private final PixelHelperFactory pixelHelperFactory;

    private final ImageArea itemImageArea;
    private final ImageArea position1ImageArea;
    private final ImageArea position2ImageArea;

    private final HoleRecognizer position1HoleRecognizer;
    private final HoleRecognizer position2HoleRecognizer;

    public ImageRecognizer(PixelHelperFactory pixelHelperFactory){
        this.pixelHelperFactory = pixelHelperFactory;

        itemImageArea = new ImageArea(pixelHelperFactory, 0.34f, 0.3f, 0.1f, 0.3f, 1f, 0.25f, 0.25f);
        position1ImageArea = new ImageArea(pixelHelperFactory, 0.31f, 0.6f, 0.15f, 0.2f, 0.25f, 1f, 0.25f);
        position2ImageArea = new ImageArea(pixelHelperFactory, 0.5f, 0.6f, 0.15f, 0.2f, 0.25f, 0.25f, 1f);

        position1HoleRecognizer = new HoleRecognizer(pixelHelperFactory, position1ImageArea);
        position2HoleRecognizer = new HoleRecognizer(pixelHelperFactory, position2ImageArea);
    }

    public Image prepareImageForDisplay(Image image) {
        return prepareImageForRecognition(image);
    }

    public Image prepareImageForRecognitionPreview(Image image) {
        if (ImageHelper.isPortrait(image))
            image = image.rotate(90);

        if (image.getWidth() < MIN_WIDTH)
            throw new IllegalArgumentException(String.format("Width must be greater than or equal %s.", MIN_WIDTH));

        if (image.getHeight() < MIN_HEIGHT)
            throw new IllegalArgumentException(String.format("Height must be greater than or equal %s.", MIN_HEIGHT));

        image = ImageHelper.getBottomHalf(image);
        itemImageArea.markArea(image);
        position1ImageArea.markArea(image);
        position2ImageArea.markArea(image);

        return image;
    }

    public Image prepareImageForRecognition(Image image) {
        if (ImageHelper.isPortrait(image))
            image = image.rotate(90);

        if (image.getWidth() < MIN_WIDTH)
            throw new IllegalArgumentException(String.format("Width must be greater than or equal %s.", MIN_WIDTH));

        if (image.getHeight() < MIN_HEIGHT)
            throw new IllegalArgumentException(String.format("Height must be greater than or equal %s.", MIN_HEIGHT));

        return ImageHelper.getBottomHalf(image);
    }

    public boolean isPosition1Hole(Image image) {
        return position1HoleRecognizer.isHole(image);
    }

    public boolean isPosition2Hole(Image image) {
        return position2HoleRecognizer.isHole(image);
    }
}
