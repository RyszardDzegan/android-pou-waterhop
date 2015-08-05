package com.ryszarddzegan.pouwaterhop;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class GamePlayActivity extends AppCompatActivity implements GameActionPerformedListener, GameActionRequiredListener, GameStateChangedListener, GameStateRequiredListener, PictureProvidedListener, GameImageRequiredListener {

    private ImageRecognizer imageRecognizer;
    private PictureProvider pictureProvider;
    private GameActionPerformedListener gameActionPerformedListener;
    private GameStateChangedListener gameStateChangedListener;
    private GameStateRequiredListener gameStateRequiredListener;
    private GameImageProvidedListener gameImageProvidedListener;
    private GameImageRequiredListener gameImageRequiredListener;

    private View.OnClickListener onReadyButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            pictureProvider.onGameImageRequired();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_play);
        initializeMembers();
        registerEventHandlers();
        pictureProvider.onGameImageRequired();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game_play, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        pictureProvider.processActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onGameActionPerformed() {
        gameActionPerformedListener.onGameActionPerformed();
    }

    @Override
    public void onGameActionRequired(GameAction gameAction) {
        updateRequiredGameAction(gameAction);
    }

    @Override
    public void onPictureProvided(Bitmap bitmap) {
        Image image = new ImageImp(bitmap);

        try {
            updateCurrentGameStateImage(image);
        } catch (IOException e) {
            e.printStackTrace();
        }

        image = imageRecognizer.prepareImageForRecognition(image);
        gameImageProvidedListener.onGameImageProvided(image);
    }

    @Override
    public void onGameImageRequired() {
        gameImageRequiredListener.onGameImageRequired();
    }

    @Override
    public void onGameStateChanged(GameState gameState) {
        gameStateChangedListener.onGameStateChanged(gameState);
    }

    @Override
    public void onGameStateRequired() {
        gameStateRequiredListener.onGameStateRequired();
    }

    private void initializeMembers() {
        ApplicationFlow applicationFlow = new ApplicationFlow(this, this);
        imageRecognizer = new ImageRecognizer(PixelHelperImp.getInstance());
        pictureProvider = new PictureProvider(this, this);
        gameActionPerformedListener = applicationFlow;
        gameStateChangedListener = applicationFlow;
        gameStateRequiredListener = applicationFlow;
        gameImageProvidedListener = applicationFlow;
        gameImageRequiredListener = pictureProvider;
    }

    private void registerEventHandlers() {
        Button readyButton = (Button)findViewById(R.id.ready_button);
        readyButton.setOnClickListener(onReadyButtonClickListener);
    }

    private void updateCurrentGameStateImage(Image image) throws IOException {
        /* Uncomment the code below to mock camera's result */
        AssetManager assetManager = getApplicationContext().getAssets();
        InputStream inputStream = assetManager.open("waterhop52.jpg");
        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
        image = new ImageImp(bitmap);
        /**/

        ImageImp imageForDisplay = (ImageImp) imageRecognizer.prepareImageForDisplay(image);
        ImageImp imageForRecognition = (ImageImp) imageRecognizer.prepareImageForRecognitionPreview(image);
        ImageView currentGameStateImage = (ImageView)findViewById(R.id.current_game_state_image);
        ImageView currentGameStateImageRecognition = (ImageView)findViewById(R.id.current_game_state_image_recognition);
        currentGameStateImage.setImageBitmap(imageForDisplay.getBitmap());
        currentGameStateImageRecognition.setImageBitmap(imageForRecognition.getBitmap());
    }

    private void updateRequiredGameAction(GameAction gameAction) {
        String gameActionText = gameAction.toString();
        TextView requiredGameActionText = (TextView)findViewById(R.id.required_game_action_text);
        requiredGameActionText.setText(gameActionText);
    }
}
