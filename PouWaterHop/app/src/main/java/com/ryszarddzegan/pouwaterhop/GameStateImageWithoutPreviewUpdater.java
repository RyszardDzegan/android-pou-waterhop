package com.ryszarddzegan.pouwaterhop;

import android.app.Activity;
import android.widget.ImageView;

public class GameStateImageWithoutPreviewUpdater implements GameStateImageUpdater {
    protected final Activity activity;
    protected final ImageRecognizer imageRecognizer;

    public int getLayout() {
        return R.layout.activity_game_play;
    }

    public GameStateImageWithoutPreviewUpdater(Activity activity, ImageRecognizer imageRecognizer) {

        this.activity = activity;
        this.imageRecognizer = imageRecognizer;
    }

    @Override
    public void displayGameStateImages(Image image) {
        ImageImp imageForDisplay = (ImageImp) imageRecognizer.prepareImageForDisplay(image);
        ImageView currentGameStateImage = (ImageView)activity.findViewById(R.id.current_game_state_image);
        currentGameStateImage.setImageBitmap(imageForDisplay.getBitmap());
    }
}
