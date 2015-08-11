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
    private static GameStateImageUpdater gameStateImageUpdater;

    public static void setGamePlayActivity(GamePlayActivity gamePlayActivity) {
        logger = LoggerImp.getInstance();
        pixelHelper = PixelHelperImp.getInstance();
        imageRecognizer = new ImageRecognizerImp(pixelHelper, logger);
        applicationFlow = new ApplicationFlow(imageRecognizer, gamePlayActivity, gamePlayActivity, gamePlayActivity);
        pictureProvider = new PictureFromAssetsProvider(gamePlayActivity, gamePlayActivity); //TODO: Replace PictureFromAssetsProvider with PictureFromCameraProvider in production
        gameActionRequiredListener = applicationFlow;
        gameActionPerformedListener = applicationFlow;
        gameImageProvidedListener = applicationFlow;
        gameStateImageUpdater = new GameStateImageWithoutPreviewUpdater(gamePlayActivity, imageRecognizer); //TODO: Replace GameStateImageWithPreviewUpdater with GameStateImageWithoutPreviewUpdater in production
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

    public static GameStateImageUpdater getGameStateImageUpdater() {
        return gameStateImageUpdater;
    }
}
