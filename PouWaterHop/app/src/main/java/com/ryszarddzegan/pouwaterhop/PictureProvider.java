package com.ryszarddzegan.pouwaterhop;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;

public class PictureProvider implements GameImageRequiredListener {
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private final Activity activity;
    private final GameImageProvidedListener gameImageProvidedListener;

    public PictureProvider(Activity activity, GameImageProvidedListener gameImageProvidedListener) {
        this.activity = activity;
        this.gameImageProvidedListener = gameImageProvidedListener;
    }

    public void processActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK || requestCode != REQUEST_IMAGE_CAPTURE)
            return;

        Bundle extras = data.getExtras();
        Bitmap bitmap = (Bitmap) extras.get("data");
        Picture picture = new Picture(bitmap);

        gameImageProvidedListener.onGameImageProvided(picture);
    }

    @Override
    public void onGameImageRequired() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(activity.getPackageManager()) != null) {
            activity.startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }
}
