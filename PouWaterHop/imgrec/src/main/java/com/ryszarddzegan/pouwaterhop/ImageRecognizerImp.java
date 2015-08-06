package com.ryszarddzegan.pouwaterhop;

public class ImageRecognizerImp implements ImageRecognizer {
    private static final int MIN_WIDTH = 128;
    private static final int MIN_HEIGHT = 96;

    private static final String LOGGER_TAG = "ImgRec";

    private final PixelHelper pixelHelper;
    private final Logger logger;
    private final PixelsSnapper pixelsSnapper;
    private final ColorMapper colorMapper;

    private final ImageArea position1Hole;
    private final ImageArea position1Item;

    private final ImageArea position2Hole;
    private final ImageArea position2Item;

    private final ImageAreaRecognizer position1;
    private final ImageAreaRecognizer position2;

    public ImageRecognizerImp(PixelHelper pixelHelper) {
        this(pixelHelper, LoggerNullObject.getInstance());
    }

    public ImageRecognizerImp(PixelHelper pixelHelper, Logger logger){
        this.pixelHelper = pixelHelper;
        this.logger = logger;
        this.pixelsSnapper = new PixelsSnapper(pixelHelper);
        this.colorMapper = GlobalColorMapper.getInstance();

        position1Hole = new ImageArea(0.30f, 0.60f, 0.20f, 0.20f);
        position1Item = new ImageArea(0.35f, 0.30f, 0.10f, 0.30f);

        position2Hole = new ImageArea(0.55f, 0.60f, 0.20f, 0.20f);
        position2Item = new ImageArea(0.60f, 0.30f, 0.10f, 0.30f);

        position1 = new ImageAreaRecognizer(position1Hole, position1Item);
        position2 = new ImageAreaRecognizer(position2Hole, position2Item);
    }

    public Image prepareImageForRecognitionPreview1(Image image) {
        image = prepareImageForDisplay(image);

        image = image.scale(MIN_WIDTH, MIN_HEIGHT);
        pixelsSnapper.snap(image);
        NoiseRemover.removeNoise(image);

        return image;
    }

    public Image prepareImageForRecognitionPreview2(Image image) {
        image = prepareImageForRecognitionPreview1(image);
        image = image.clone();

        ColorsHelper.mapColors(image, colorMapper);

        position1Hole.markArea(image, StandardColors.red);
        position1Item.markArea(image, StandardColors.red);
        position2Hole.markArea(image, StandardColors.red);
        position2Item.markArea(image, StandardColors.red);

        return image;
    }

    public Image prepareImageForRecognition(Image image) {
        image = prepareImageForRecognitionPreview1(image);
        image = image.clone();

        logger.info(LOGGER_TAG, String.format("Prepared image: %dx%d", image.getWidth(), image.getHeight()));
        logger.info(LOGGER_TAG, String.format("Prepared image colors: %s", ColorsHelper.getPixelsInfo(image, pixelHelper)));

        return image;
    }

    public Image prepareImageForDisplay(Image image) {
        if (ImageHelper.isPortrait(image))
            image = image.rotate(90);

        if (image.getWidth() < MIN_WIDTH)
            throw new IllegalArgumentException(String.format("Width must be greater than or equal %s.", MIN_WIDTH));

        if (image.getHeight() < MIN_HEIGHT)
            throw new IllegalArgumentException(String.format("Height must be greater than or equal %s.", MIN_HEIGHT));

        return ImageHelper.getBottomHalf(image);
    }

    public boolean isPosition1Hole(Image image) {
        return position1.isHole(image);
    }

    public boolean isPosition2Hole(Image image) {
        return position2.isHole(image);
    }

    public boolean isPosition1Coin(Image image) {
        return position1.isCoin(image);
    }

    public boolean isPosition2Coin(Image image) {
        return position2.isCoin(image);
    }

    public boolean isPosition1Watch(Image image) {
        return position1.isWatch(image);
    }

    public boolean isPosition2Watch(Image image) {
        return position2.isWatch(image);
    }
}
