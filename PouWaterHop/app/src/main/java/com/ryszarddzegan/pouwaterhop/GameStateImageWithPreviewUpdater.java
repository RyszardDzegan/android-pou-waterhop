package com.ryszarddzegan.pouwaterhop;

import android.app.Activity;
import android.widget.ImageView;

public class GameStateImageWithPreviewUpdater extends GameStateImageWithoutPreviewUpdater {
    public GameStateImageWithPreviewUpdater(Activity activity, ImageRecognizer imageRecognizer) {
        super(activity, imageRecognizer);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_game_play_debug;
    }

    @Override
    public void displayGameStateImages(Image image) {
        super.displayGameStateImages(image);

        ImageImp imageForRecognition1 = (ImageImp) imageRecognizer.prepareImageForRecognitionPreview1(image);
        ImageView currentGameStateImageRecognition1 = (ImageView)activity.findViewById(R.id.current_game_state_image_recognition_prior_to_color_reduction);
        currentGameStateImageRecognition1.setImageBitmap(imageForRecognition1.getBitmap());

        ImageImp imageForRecognition2 = (ImageImp) imageRecognizer.prepareImageForRecognitionPreview2(image);
        ImageView currentGameStateImageRecognition2 = (ImageView)activity.findViewById(R.id.current_game_state_image_recognition);
        currentGameStateImageRecognition2.setImageBitmap(imageForRecognition2.getBitmap());
    }
}
