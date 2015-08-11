package com.ryszarddzegan.pouwaterhop;

public class ServiceProvider {
    private static Logger logger;
    private static PixelHelper pixelHelper;
    private static ImageRecognizer imageRecognizer;
    private static ApplicationFlow applicationFlow;
    private static PictureProvider pictureProvider;
    private static GameActionRequiredListener gameActionRequiredListener;
    private static GameActionPerformedListener gameActionPerformedListener;
    private static GameImageProvidedListener gameImageProvidedListener;

    public static void setGamePlayActivity(GamePlayActivity gamePlayActivity) {
        logger = LoggerImp.getInstance();
        pixelHelper = PixelHelperImp.getInstance();
        imageRecognizer = new ImageRecognizerImp(pixelHelper, logger);
        applicationFlow = new ApplicationFlow(imageRecognizer, gamePlayActivity, gamePlayActivity, gamePlayActivity);
        pictureProvider = new PictureFromAssetsProvider(gamePlayActivity, gamePlayActivity); //TODO: Replace PictureFromAssetsProvider with PictureFromCameraProvider for production
        gameActionRequiredListener = applicationFlow;
        gameActionPerformedListener = applicationFlow;
        gameImageProvidedListener = applicationFlow;
    }

    public static Logger getLogger() {
        return logger;
    }

    public static PixelHelper getPixelHelper() {
        return pixelHelper;
    }

    public static ImageRecognizer getImageRecognizer() {
        return imageRecognizer;
    }

    public static ApplicationFlow getApplicationFlow() {
        return applicationFlow;
    }

    public static PictureProvider getPictureProvider() {
        return pictureProvider;
    }

    public static GameActionRequiredListener getGameActionRequiredListener() {
        return gameActionRequiredListener;
    }

    public static GameActionPerformedListener getGameActionPerformedListener() {
        return gameActionPerformedListener;
    }

    public static GameImageProvidedListener getGameImageProvidedListener() {
        return gameImageProvidedListener;
    }
}
