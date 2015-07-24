package com.ryszarddzegan.pouwaterhop;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.InputStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(AndroidJUnit4.class)
public class BitmapHelperTest {

    private Context context;

    @Before
    public void setup() {
        context = InstrumentationRegistry.getTargetContext();
    }

    @Test
    public void prepareBitmapForRecognition_test1() throws Exception {
        AssetManager assetManager = context.getAssets();
        InputStream inputStream = assetManager.open("waterhop1.png");
        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
        BitmapHelper bitmapHelper = new BitmapHelper();
        bitmap = bitmapHelper.prepareBitmapForRecognition(bitmap);
        assertThat(bitmap.getHeight(), equalTo(24));
        assertThat(bitmap.getWidth(), equalTo(64));
    }
}