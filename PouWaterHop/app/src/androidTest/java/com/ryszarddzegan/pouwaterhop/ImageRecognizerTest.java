package com.ryszarddzegan.pouwaterhop;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.io.InputStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(AndroidJUnit4.class)
public class ImageRecognizerTest {

    private Context context;

    @Before
    public void setup() {
        context = InstrumentationRegistry.getTargetContext();
    }

    @Test
    public void prepareBitmapForRecognition_isHole_test1() throws IOException {
        Image image = getPreparedBitmapFromAssets("waterhop1.jpg");
        ImageRecognizer imageRecognizer = new ImageRecognizer(PixelHelperFactoryImp.getInstance());
        assertThat("Position 1", imageRecognizer.isPosition1Hole(image), is(false));
        assertThat("Position 2", imageRecognizer.isPosition2Hole(image), is(true));
    }

    @Test
    public void prepareBitmapForRecognition_isHole_test2() throws IOException {
        Image image = getPreparedBitmapFromAssets("waterhop2.jpg");
        ImageRecognizer imageRecognizer = new ImageRecognizer(PixelHelperFactoryImp.getInstance());
        assertThat("Position 1", imageRecognizer.isPosition1Hole(image), is(true));
        assertThat("Position 2", imageRecognizer.isPosition2Hole(image), is(false));
    }

    @Test
    public void prepareBitmapForRecognition_isHole_test3() throws IOException {
        Image image = getPreparedBitmapFromAssets("waterhop3.jpg");
        ImageRecognizer imageRecognizer = new ImageRecognizer(PixelHelperFactoryImp.getInstance());
        assertThat("Position 1", imageRecognizer.isPosition1Hole(image), is(false));
        assertThat("Position 2", imageRecognizer.isPosition2Hole(image), is(false));
    }

    @Test
    public void prepareBitmapForRecognition_isHole_test4() throws IOException {
        Image image = getPreparedBitmapFromAssets("waterhop4.jpg");
        ImageRecognizer imageRecognizer = new ImageRecognizer(PixelHelperFactoryImp.getInstance());
        assertThat("Position 1", imageRecognizer.isPosition1Hole(image), is(false));
        assertThat("Position 2", imageRecognizer.isPosition2Hole(image), is(false));
    }

    @Test
    public void prepareBitmapForRecognition_isHole_test5() throws IOException {
        Image image = getPreparedBitmapFromAssets("waterhop5.jpg");
        ImageRecognizer imageRecognizer = new ImageRecognizer(PixelHelperFactoryImp.getInstance());
        assertThat("Position 1", imageRecognizer.isPosition1Hole(image), is(false));
        assertThat("Position 2", imageRecognizer.isPosition2Hole(image), is(true));
    }

    @Test
    public void prepareBitmapForRecognition_isHole_test6() throws IOException {
        Image image = getPreparedBitmapFromAssets("waterhop6.jpg");
        ImageRecognizer imageRecognizer = new ImageRecognizer(PixelHelperFactoryImp.getInstance());
        assertThat("Position 1", imageRecognizer.isPosition1Hole(image), is(false));
        assertThat("Position 2", imageRecognizer.isPosition2Hole(image), is(true));
    }

    @Test
    public void prepareBitmapForRecognition_isHole_test7() throws IOException {
        Image image = getPreparedBitmapFromAssets("waterhop7.jpg");
        ImageRecognizer imageRecognizer = new ImageRecognizer(PixelHelperFactoryImp.getInstance());
        assertThat("Position 1", imageRecognizer.isPosition1Hole(image), is(true));
        assertThat("Position 2", imageRecognizer.isPosition2Hole(image), is(false));
    }

    @Test
    public void prepareBitmapForRecognition_isHole_test8() throws IOException {
        Image image = getPreparedBitmapFromAssets("waterhop8.jpg");
        ImageRecognizer imageRecognizer = new ImageRecognizer(PixelHelperFactoryImp.getInstance());
        assertThat("Position 1", imageRecognizer.isPosition1Hole(image), is(false));
        assertThat("Position 2", imageRecognizer.isPosition2Hole(image), is(false));
    }

    @Test
    public void prepareBitmapForRecognition_isHole_test9() throws IOException {
        Image image = getPreparedBitmapFromAssets("waterhop9.jpg");
        ImageRecognizer imageRecognizer = new ImageRecognizer(PixelHelperFactoryImp.getInstance());
        assertThat("Position 1", imageRecognizer.isPosition1Hole(image), is(false));
        assertThat("Position 2", imageRecognizer.isPosition2Hole(image), is(false));
    }

    @Test
    public void prepareBitmapForRecognition_isHole_test10() throws IOException {
        Image image = getPreparedBitmapFromAssets("waterhop10.jpg");
        ImageRecognizer imageRecognizer = new ImageRecognizer(PixelHelperFactoryImp.getInstance());
        assertThat("Position 1", imageRecognizer.isPosition1Hole(image), is(false));
        assertThat("Position 2", imageRecognizer.isPosition2Hole(image), is(true));
    }

    @Test
    public void prepareBitmapForRecognition_isHole_test11() throws IOException {
        Image image = getPreparedBitmapFromAssets("waterhop11.jpg");
        ImageRecognizer imageRecognizer = new ImageRecognizer(PixelHelperFactoryImp.getInstance());
        assertThat("Position 1", imageRecognizer.isPosition1Hole(image), is(true));
        assertThat("Position 2", imageRecognizer.isPosition2Hole(image), is(false));
    }

    @Test
    public void prepareBitmapForRecognition_isHole_test12() throws IOException {
        Image image = getPreparedBitmapFromAssets("waterhop12.jpg");
        ImageRecognizer imageRecognizer = new ImageRecognizer(PixelHelperFactoryImp.getInstance());
        assertThat("Position 1", imageRecognizer.isPosition1Hole(image), is(false));
        assertThat("Position 2", imageRecognizer.isPosition2Hole(image), is(false));
    }

    @Test
    public void prepareBitmapForRecognition_isHole_test13() throws IOException {
        Image image = getPreparedBitmapFromAssets("waterhop13.jpg");
        ImageRecognizer imageRecognizer = new ImageRecognizer(PixelHelperFactoryImp.getInstance());
        assertThat("Position 1", imageRecognizer.isPosition1Hole(image), is(false));
        assertThat("Position 2", imageRecognizer.isPosition2Hole(image), is(false));
    }

    @Test
    public void prepareBitmapForRecognition_isHole_test14() throws IOException {
        Image image = getPreparedBitmapFromAssets("waterhop14.jpg");
        ImageRecognizer imageRecognizer = new ImageRecognizer(PixelHelperFactoryImp.getInstance());
        assertThat("Position 1", imageRecognizer.isPosition1Hole(image), is(false));
        assertThat("Position 2", imageRecognizer.isPosition2Hole(image), is(false));
    }

    @Test
    public void prepareBitmapForRecognition_isHole_test15() throws IOException {
        Image image = getPreparedBitmapFromAssets("waterhop15.jpg");
        ImageRecognizer imageRecognizer = new ImageRecognizer(PixelHelperFactoryImp.getInstance());
        assertThat("Position 1", imageRecognizer.isPosition1Hole(image), is(true));
        assertThat("Position 2", imageRecognizer.isPosition2Hole(image), is(false));
    }

    @Test
    public void prepareBitmapForRecognition_isHole_test16() throws IOException {
        Image image = getPreparedBitmapFromAssets("waterhop16.jpg");
        ImageRecognizer imageRecognizer = new ImageRecognizer(PixelHelperFactoryImp.getInstance());
        assertThat("Position 1", imageRecognizer.isPosition1Hole(image), is(true));
        assertThat("Position 2", imageRecognizer.isPosition2Hole(image), is(false));
    }

    @Test
    public void prepareBitmapForRecognition_isHole_test17() throws IOException {
        Image image = getPreparedBitmapFromAssets("waterhop17.jpg");
        ImageRecognizer imageRecognizer = new ImageRecognizer(PixelHelperFactoryImp.getInstance());
        assertThat("Position 1", imageRecognizer.isPosition1Hole(image), is(true));
        assertThat("Position 2", imageRecognizer.isPosition2Hole(image), is(false));
    }

    @Test
    public void prepareBitmapForRecognition_isHole_test18() throws IOException {
        Image image = getPreparedBitmapFromAssets("waterhop18.jpg");
        ImageRecognizer imageRecognizer = new ImageRecognizer(PixelHelperFactoryImp.getInstance());
        assertThat("Position 1", imageRecognizer.isPosition1Hole(image), is(false));
        assertThat("Position 2", imageRecognizer.isPosition2Hole(image), is(false));
    }

    @Test
    public void prepareBitmapForRecognition_isHole_test19() throws IOException {
        Image image = getPreparedBitmapFromAssets("waterhop19.jpg");
        ImageRecognizer imageRecognizer = new ImageRecognizer(PixelHelperFactoryImp.getInstance());
        assertThat("Position 1", imageRecognizer.isPosition1Hole(image), is(true));
        assertThat("Position 2", imageRecognizer.isPosition2Hole(image), is(false));
    }

    @Test
    public void prepareBitmapForRecognition_isHole_test20() throws IOException {
        Image image = getPreparedBitmapFromAssets("waterhop20.jpg");
        ImageRecognizer imageRecognizer = new ImageRecognizer(PixelHelperFactoryImp.getInstance());
        assertThat("Position 1", imageRecognizer.isPosition1Hole(image), is(true));
        assertThat("Position 2", imageRecognizer.isPosition2Hole(image), is(false));
    }

    @Test
    public void prepareBitmapForRecognition_isHole_test21() throws IOException {
        Image image = getPreparedBitmapFromAssets("waterhop21.jpg");
        ImageRecognizer imageRecognizer = new ImageRecognizer(PixelHelperFactoryImp.getInstance());
        assertThat("Position 1", imageRecognizer.isPosition1Hole(image), is(false));
        assertThat("Position 2", imageRecognizer.isPosition2Hole(image), is(false));
    }

    @Test
    public void prepareBitmapForRecognition_isHole_test22() throws IOException {
        Image image = getPreparedBitmapFromAssets("waterhop22.jpg");
        ImageRecognizer imageRecognizer = new ImageRecognizer(PixelHelperFactoryImp.getInstance());
        assertThat("Position 1", imageRecognizer.isPosition1Hole(image), is(false));
        assertThat("Position 2", imageRecognizer.isPosition2Hole(image), is(false));
    }

    @Test
    public void prepareBitmapForRecognition_isHole_test23() throws IOException {
        Image image = getPreparedBitmapFromAssets("waterhop23.jpg");
        ImageRecognizer imageRecognizer = new ImageRecognizer(PixelHelperFactoryImp.getInstance());
        assertThat("Position 1", imageRecognizer.isPosition1Hole(image), is(false));
        assertThat("Position 2", imageRecognizer.isPosition2Hole(image), is(false));
    }

    @Test
    public void prepareBitmapForRecognition_isHole_test24() throws IOException {
        Image image = getPreparedBitmapFromAssets("waterhop24.jpg");
        ImageRecognizer imageRecognizer = new ImageRecognizer(PixelHelperFactoryImp.getInstance());
        assertThat("Position 1", imageRecognizer.isPosition1Hole(image), is(true));
        assertThat("Position 2", imageRecognizer.isPosition2Hole(image), is(false));
    }

    @Test
    public void prepareBitmapForRecognition_isHole_test25() throws IOException {
        Image image = getPreparedBitmapFromAssets("waterhop25.jpg");
        ImageRecognizer imageRecognizer = new ImageRecognizer(PixelHelperFactoryImp.getInstance());
        assertThat("Position 1", imageRecognizer.isPosition1Hole(image), is(false));
        assertThat("Position 2", imageRecognizer.isPosition2Hole(image), is(true));
    }

    @Test
    public void prepareBitmapForRecognition_isHole_test26() throws IOException {
        Image image = getPreparedBitmapFromAssets("waterhop26.jpg");
        ImageRecognizer imageRecognizer = new ImageRecognizer(PixelHelperFactoryImp.getInstance());
        assertThat("Position 1", imageRecognizer.isPosition1Hole(image), is(false));
        assertThat("Position 2", imageRecognizer.isPosition2Hole(image), is(true));
    }

    @Test
    public void prepareBitmapForRecognition_isHole_test27() throws IOException {
        Image image = getPreparedBitmapFromAssets("waterhop27.jpg");
        ImageRecognizer imageRecognizer = new ImageRecognizer(PixelHelperFactoryImp.getInstance());
        assertThat("Position 1", imageRecognizer.isPosition1Hole(image), is(false));
        assertThat("Position 2", imageRecognizer.isPosition2Hole(image), is(false));
    }

    @Test
    public void prepareBitmapForRecognition_isHole_test28() throws IOException {
        Image image = getPreparedBitmapFromAssets("waterhop28.jpg");
        ImageRecognizer imageRecognizer = new ImageRecognizer(PixelHelperFactoryImp.getInstance());
        assertThat("Position 1", imageRecognizer.isPosition1Hole(image), is(false));
        assertThat("Position 2", imageRecognizer.isPosition2Hole(image), is(false));
    }

    @Test
    public void prepareBitmapForRecognition_isHole_test29() throws IOException {
        Image image = getPreparedBitmapFromAssets("waterhop29.jpg");
        ImageRecognizer imageRecognizer = new ImageRecognizer(PixelHelperFactoryImp.getInstance());
        assertThat("Position 1", imageRecognizer.isPosition1Hole(image), is(false));
        assertThat("Position 2", imageRecognizer.isPosition2Hole(image), is(false));
    }

    @Test
    public void prepareBitmapForRecognition_isHole_test30() throws IOException {
        Image image = getPreparedBitmapFromAssets("waterhop30.jpg");
        ImageRecognizer imageRecognizer = new ImageRecognizer(PixelHelperFactoryImp.getInstance());
        assertThat("Position 1", imageRecognizer.isPosition1Hole(image), is(false));
        assertThat("Position 2", imageRecognizer.isPosition2Hole(image), is(false));
    }

    @Test
    public void prepareBitmapForRecognition_isHole_test31() throws IOException {
        Image image = getPreparedBitmapFromAssets("waterhop31.jpg");
        ImageRecognizer imageRecognizer = new ImageRecognizer(PixelHelperFactoryImp.getInstance());
        assertThat("Position 1", imageRecognizer.isPosition1Hole(image), is(false));
        assertThat("Position 2", imageRecognizer.isPosition2Hole(image), is(false));
    }

    @Test
    public void prepareBitmapForRecognition_isHole_test32() throws IOException {
        Image image = getPreparedBitmapFromAssets("waterhop32.jpg");
        ImageRecognizer imageRecognizer = new ImageRecognizer(PixelHelperFactoryImp.getInstance());
        assertThat("Position 1", imageRecognizer.isPosition1Hole(image), is(false));
        assertThat("Position 2", imageRecognizer.isPosition2Hole(image), is(true));
    }

    @Test
    public void prepareBitmapForRecognition_isHole_test33() throws IOException {
        Image image = getPreparedBitmapFromAssets("waterhop33.jpg");
        ImageRecognizer imageRecognizer = new ImageRecognizer(PixelHelperFactoryImp.getInstance());
        assertThat("Position 1", imageRecognizer.isPosition1Hole(image), is(false));
        assertThat("Position 2", imageRecognizer.isPosition2Hole(image), is(false));
    }

    @Test
    public void prepareBitmapForRecognition_isHole_test34() throws IOException {
        Image image = getPreparedBitmapFromAssets("waterhop34.jpg");
        ImageRecognizer imageRecognizer = new ImageRecognizer(PixelHelperFactoryImp.getInstance());
        assertThat("Position 1", imageRecognizer.isPosition1Hole(image), is(false));
        assertThat("Position 2", imageRecognizer.isPosition2Hole(image), is(true));
    }

    @Test
    public void prepareBitmapForRecognition_isHole_test35() throws IOException {
        Image image = getPreparedBitmapFromAssets("waterhop35.jpg");
        ImageRecognizer imageRecognizer = new ImageRecognizer(PixelHelperFactoryImp.getInstance());
        assertThat("Position 1", imageRecognizer.isPosition1Hole(image), is(true));
        assertThat("Position 2", imageRecognizer.isPosition2Hole(image), is(false));
    }

    @Test
    public void prepareBitmapForRecognition_isHole_test36() throws IOException {
        Image image = getPreparedBitmapFromAssets("waterhop36.jpg");
        ImageRecognizer imageRecognizer = new ImageRecognizer(PixelHelperFactoryImp.getInstance());
        assertThat("Position 1", imageRecognizer.isPosition1Hole(image), is(false));
        assertThat("Position 2", imageRecognizer.isPosition2Hole(image), is(false));
    }

    @Test
    public void prepareBitmapForRecognition_isHole_test37() throws IOException {
        Image image = getPreparedBitmapFromAssets("waterhop37.jpg");
        ImageRecognizer imageRecognizer = new ImageRecognizer(PixelHelperFactoryImp.getInstance());
        assertThat("Position 1", imageRecognizer.isPosition1Hole(image), is(false));
        assertThat("Position 2", imageRecognizer.isPosition2Hole(image), is(false));
    }

    @Test
    public void prepareBitmapForRecognition_isHole_test38() throws IOException {
        Image image = getPreparedBitmapFromAssets("waterhop38.jpg");
        ImageRecognizer imageRecognizer = new ImageRecognizer(PixelHelperFactoryImp.getInstance());
        assertThat("Position 1", imageRecognizer.isPosition1Hole(image), is(false));
        assertThat("Position 2", imageRecognizer.isPosition2Hole(image), is(true));
    }

    @Test
    public void prepareBitmapForRecognition_isHole_test39() throws IOException {
        Image image = getPreparedBitmapFromAssets("waterhop39.jpg");
        ImageRecognizer imageRecognizer = new ImageRecognizer(PixelHelperFactoryImp.getInstance());
        assertThat("Position 1", imageRecognizer.isPosition1Hole(image), is(false));
        assertThat("Position 2", imageRecognizer.isPosition2Hole(image), is(false));
    }

    @Test
    public void prepareBitmapForRecognition_isHole_test40() throws IOException {
        Image image = getPreparedBitmapFromAssets("waterhop40.jpg");
        ImageRecognizer imageRecognizer = new ImageRecognizer(PixelHelperFactoryImp.getInstance());
        assertThat("Position 1", imageRecognizer.isPosition1Hole(image), is(true));
        assertThat("Position 2", imageRecognizer.isPosition2Hole(image), is(false));
    }

    @Test
    public void prepareBitmapForRecognition_isHole_test41() throws IOException {
        Image image = getPreparedBitmapFromAssets("waterhop41.jpg");
        ImageRecognizer imageRecognizer = new ImageRecognizer(PixelHelperFactoryImp.getInstance());
        assertThat("Position 1", imageRecognizer.isPosition1Hole(image), is(false));
        assertThat("Position 2", imageRecognizer.isPosition2Hole(image), is(true));
    }

    @Test
    public void prepareBitmapForRecognition_isHole_test42() throws IOException {
        Image image = getPreparedBitmapFromAssets("waterhop42.jpg");
        ImageRecognizer imageRecognizer = new ImageRecognizer(PixelHelperFactoryImp.getInstance());
        assertThat("Position 1", imageRecognizer.isPosition1Hole(image), is(true));
        assertThat("Position 2", imageRecognizer.isPosition2Hole(image), is(false));
    }

    @Test
    public void prepareBitmapForRecognition_isHole_test43() throws IOException {
        Image image = getPreparedBitmapFromAssets("waterhop43.jpg");
        ImageRecognizer imageRecognizer = new ImageRecognizer(PixelHelperFactoryImp.getInstance());
        assertThat("Position 1", imageRecognizer.isPosition1Hole(image), is(false));
        assertThat("Position 2", imageRecognizer.isPosition2Hole(image), is(false));
    }

    @Test
    public void prepareBitmapForRecognition_isHole_test44() throws IOException {
        Image image = getPreparedBitmapFromAssets("waterhop44.jpg");
        ImageRecognizer imageRecognizer = new ImageRecognizer(PixelHelperFactoryImp.getInstance());
        assertThat("Position 1", imageRecognizer.isPosition1Hole(image), is(true));
        assertThat("Position 2", imageRecognizer.isPosition2Hole(image), is(false));
    }

    @Test
    public void prepareBitmapForRecognition_isHole_test45() throws IOException {
        Image image = getPreparedBitmapFromAssets("waterhop45.jpg");
        ImageRecognizer imageRecognizer = new ImageRecognizer(PixelHelperFactoryImp.getInstance());
        assertThat("Position 1", imageRecognizer.isPosition1Hole(image), is(false));
        assertThat("Position 2", imageRecognizer.isPosition2Hole(image), is(true));
    }

    @Test
    public void prepareBitmapForRecognition_isHole_test46() throws IOException {
        Image image = getPreparedBitmapFromAssets("waterhop46.png");
        ImageRecognizer imageRecognizer = new ImageRecognizer(PixelHelperFactoryImp.getInstance());
        assertThat("Position 1", imageRecognizer.isPosition1Hole(image), is(false));
        assertThat("Position 2", imageRecognizer.isPosition2Hole(image), is(true));
    }

    @Test
    public void prepareBitmapForRecognition_isHole_test47() throws IOException {
        Image image = getPreparedBitmapFromAssets("waterhop47.png");
        ImageRecognizer imageRecognizer = new ImageRecognizer(PixelHelperFactoryImp.getInstance());
        assertThat("Position 1", imageRecognizer.isPosition1Hole(image), is(false));
        assertThat("Position 2", imageRecognizer.isPosition2Hole(image), is(false));
    }

    @Test
    public void prepareBitmapForRecognition_isHole_test48() throws IOException {
        Image image = getPreparedBitmapFromAssets("waterhop48.png");
        ImageRecognizer imageRecognizer = new ImageRecognizer(PixelHelperFactoryImp.getInstance());
        assertThat("Position 1", imageRecognizer.isPosition1Hole(image), is(true));
        assertThat("Position 2", imageRecognizer.isPosition2Hole(image), is(false));
    }

    @Test
    public void prepareBitmapForRecognition_isHole_test49() throws IOException {
        Image image = getPreparedBitmapFromAssets("waterhop49.jpg");
        ImageRecognizer imageRecognizer = new ImageRecognizer(PixelHelperFactoryImp.getInstance());
        assertThat("Position 1", imageRecognizer.isPosition1Hole(image), is(false));
        assertThat("Position 2", imageRecognizer.isPosition2Hole(image), is(true));
    }

    @Test
    public void prepareBitmapForRecognition_isHole_test50() throws IOException {
        Image image = getPreparedBitmapFromAssets("waterhop50.png");
        ImageRecognizer imageRecognizer = new ImageRecognizer(PixelHelperFactoryImp.getInstance());
        assertThat("Position 1", imageRecognizer.isPosition1Hole(image), is(false));
        assertThat("Position 2", imageRecognizer.isPosition2Hole(image), is(true));
    }

    @Test
    public void prepareBitmapForRecognition_isHole_test51() throws IOException {
        Image image = getPreparedBitmapFromAssets("waterhop51.png");
        ImageRecognizer imageRecognizer = new ImageRecognizer(PixelHelperFactoryImp.getInstance());
        assertThat("Position 1", imageRecognizer.isPosition1Hole(image), is(false));
        assertThat("Position 2", imageRecognizer.isPosition2Hole(image), is(false));
    }

    @Test
    public void prepareBitmapForRecognition_isHole_test52() throws IOException {
        Image image = getPreparedBitmapFromAssets("waterhop52.jpg");
        ImageRecognizer imageRecognizer = new ImageRecognizer(PixelHelperFactoryImp.getInstance());
        assertThat("Position 1", imageRecognizer.isPosition1Hole(image), is(true));
        assertThat("Position 2", imageRecognizer.isPosition2Hole(image), is(false));
    }

    private Image getPreparedBitmapFromAssets(String fileName) throws IOException {
        AssetManager assetManager = context.getAssets();
        InputStream inputStream = assetManager.open(fileName);
        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
        Image image = new ImageImp(bitmap);
        ImageRecognizer imageRecognizer = new ImageRecognizer(PixelHelperFactoryImp.getInstance());
        return imageRecognizer.prepareImageForRecognition(image);
    }
}