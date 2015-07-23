package com.ryszarddzegan.pouwaterhop;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import android.provider.MediaStore;

public class PictureProvider implements GameImageRequiredListener {
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private final Activity activity;
    private final PictureProvidedListener pictureProvidedListener;

    public PictureProvider(Activity activity, PictureProvidedListener pictureProvidedListener) {
        this.activity = activity;
        this.pictureProvidedListener = pictureProvidedListener;
    }

    public void processActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK || requestCode != REQUEST_IMAGE_CAPTURE)
            return;

        Bundle extras = data.getExtras();
        Bitmap bitmap = (Bitmap) extras.get("data");
        bitmap = transformBitmap(bitmap);
        Picture picture = new Picture(bitmap);

        pictureProvidedListener.onPictureProvided(picture);
    }

    @Override
    public void onGameImageRequired() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(activity.getPackageManager()) != null) {
            activity.startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    private Bitmap transformBitmap(Bitmap bitmap) {
        bitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() << 3, bitmap.getHeight() << 3, true);
        if (bitmap.getHeight() > bitmap.getWidth()) {
            Matrix matrix = new Matrix();
            matrix.postRotate(90);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        }
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight() >> 1);
    }
}
