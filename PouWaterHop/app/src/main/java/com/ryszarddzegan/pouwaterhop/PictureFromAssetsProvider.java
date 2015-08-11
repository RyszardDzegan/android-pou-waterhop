package com.ryszarddzegan.pouwaterhop;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;

public class PictureFromAssetsProvider implements PictureProvider {
    private final Activity activity;
    private final PictureProvidedListener pictureProvidedListener;
    private final static int ASSETS_COUNT = 30;
    private int assetIndex = 1;

    public PictureFromAssetsProvider(Activity activity, PictureProvidedListener pictureProvidedListener) {
        this.activity = activity;
        this.pictureProvidedListener = pictureProvidedListener;
    }

    public void processActivityResult(int requestCode, int resultCode, Intent data) {
    }

    @Override
    public void onGameImageRequired() {
        final AssetManager assetManager = activity.getApplicationContext().getAssets();
        @SuppressWarnings("SpellCheckingInspection") final String assetName = String.format("waterhop%d.jpg", assetIndex++);

        if (assetIndex > ASSETS_COUNT) {
            assetIndex = 1;
        }

        InputStream inputStream = null;
        try {
            inputStream = assetManager.open(assetName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
        pictureProvidedListener.onPictureProvided(bitmap);
    }
}
