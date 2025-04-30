package com.badlogic.drop;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture welcomeScreen;
    private Texture baseGround;

    enum GameState {
        WELCOME,
        PLAYING
    }

    GameState currentState = GameState.WELCOME;

    @Override
    public void create() {
        batch = new SpriteBatch();
        welcomeScreen = new Texture("welcome_screen.png");
        baseGround = new Texture("base_ground.png");
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        if (currentState == GameState.WELCOME) {
            renderWelcomeScreen();
            if(Gdx.input.justTouched()) {
                currentState = GameState.PLAYING;
            }
        } else if (currentState == GameState.PLAYING) {
            renderGame();
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        welcomeScreen.dispose();
    }

    public void renderWelcomeScreen(){
        batch.begin();
        batch.draw(welcomeScreen, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.end();
    };

    public void renderGame() {
        batch.begin();
        batch.draw(baseGround, 0, 0, Gdx.graphics.getWidth(), (float) Gdx.graphics.getHeight() /5);
        batch.end();
    };
}
