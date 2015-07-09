package com.ryszarddzegan.pouwaterhop;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class GamePlayActivity extends ActionBarActivity implements GameActionPerformedListener, GameActionRequiredListener, GameStateChangedListener, GameStateRequiredListener, GameImageProvidedListener, GameImageRequiredListener {
    private final PictureProvider pictureProvider;
    private final GameActionPerformedListener gameActionPerformedListener;
    private final GameActionRequiredListener gameActionRequiredListener;
    private final GameStateChangedListener gameStateChangedListener;
    private final GameStateRequiredListener gameStateRequiredListener;
    private final GameImageProvidedListener gameImageProvidedListener;
    private final GameImageRequiredListener gameImageRequiredListener;


    public GamePlayActivity() {
        GameActionProvider gameActionProvider = new GameActionProvider(this, this);
        ApplicationFlow applicationFlow = new ApplicationFlow(this, this);

        pictureProvider = new PictureProvider(this, this);
        gameActionPerformedListener = applicationFlow;
        gameActionRequiredListener = gameActionProvider;
        gameStateChangedListener = applicationFlow;
        gameStateRequiredListener = applicationFlow;
        gameImageProvidedListener = applicationFlow;
        gameImageRequiredListener = pictureProvider;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_play);
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
        gameActionRequiredListener.onGameActionRequired(gameAction);
    }

    @Override
    public void onGameImageProvided(Image image) {
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
}
