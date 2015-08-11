package com.ryszarddzegan.pouwaterhop;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

public class GamePlayActivity extends AppCompatActivity implements GameActionChangedListener, GameImageRequiredListener, GameStateChangedListener, PictureProvidedListener {

    private ImageRecognizerImp imageRecognizer;
    private PictureProvider pictureProvider;
    private GameActionRequiredListener gameActionRequiredListener;
    private GameActionPerformedListener gameActionPerformedListener;
    private GameImageProvidedListener gameImageProvidedListener;

    private View.OnClickListener onReadyButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            gameActionPerformedListener.onGameActionPerformed();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_play);
        initializeMembers();
        registerEventHandlers();
        gameActionPerformedListener.onGameActionPerformed();
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
    public void onPictureProvided(Bitmap bitmap) {
        Image image = new ImageImp(bitmap);

        try {
            updateCurrentGameStateImage(image);
        } catch (IOException e) {
            e.printStackTrace();
        }

        gameImageProvidedListener.onGameImageProvided(image);
    }

    @Override
    public void onGameImageRequired() {
        pictureProvider.onGameImageRequired();
    }

    @Override
    public void onGameStateChanged(GameState gameState) {
        updateRecognizedGameState(gameState);
        gameActionRequiredListener.onGameActionRequired(gameState);
    }

    @Override
    public void onGameActionChanged(GameAction gameAction) {
        updateRequiredGameAction(gameAction);
    }

    private void initializeMembers() {
        imageRecognizer = new ImageRecognizerImp(PixelHelperImp.getInstance(), LoggerImp.getInstance());
        ApplicationFlow applicationFlow = new ApplicationFlow(imageRecognizer, this, this, this);
        pictureProvider = new PictureFromAssetsProvider(this, this); //TODO: Replace PictureFromAssetsProvider with PictureFromCameraProvider for production
        gameActionRequiredListener = applicationFlow;
        gameActionPerformedListener = applicationFlow;
        gameImageProvidedListener = applicationFlow;
    }

    private void registerEventHandlers() {
        Button readyButton = (Button)findViewById(R.id.ready_button);
        readyButton.setOnClickListener(onReadyButtonClickListener);
    }

    private void updateCurrentGameStateImage(Image image) throws IOException {
        ImageImp imageForDisplay = (ImageImp) imageRecognizer.prepareImageForDisplay(image);
        ImageView currentGameStateImage = (ImageView)findViewById(R.id.current_game_state_image);
        currentGameStateImage.setImageBitmap(imageForDisplay.getBitmap());

        ImageImp imageForRecognition1 = (ImageImp) imageRecognizer.prepareImageForRecognitionPreview1(image);
        ImageView currentGameStateImageRecognition1 = (ImageView)findViewById(R.id.current_game_state_image_recognition_prior_to_color_reduction);
        currentGameStateImageRecognition1.setImageBitmap(imageForRecognition1.getBitmap());

        ImageImp imageForRecognition2 = (ImageImp) imageRecognizer.prepareImageForRecognitionPreview2(image);
        ImageView currentGameStateImageRecognition2 = (ImageView)findViewById(R.id.current_game_state_image_recognition);
        currentGameStateImageRecognition2.setImageBitmap(imageForRecognition2.getBitmap());
    }

    private void updateRecognizedGameState(GameState gameState) {
        String gameStateText = gameState.toString();
        TextView recognizedGameStateText = (TextView)findViewById(R.id.recognized_game_state_text);
        recognizedGameStateText.setText(gameStateText);
    }

    private void updateRequiredGameAction(GameAction gameAction) {
        String gameActionText = gameAction.toString();
        TextView requiredGameActionText = (TextView)findViewById(R.id.required_game_action_text);
        requiredGameActionText.setText(gameActionText);
    }
}
