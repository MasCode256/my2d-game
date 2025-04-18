package org.example;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.*;

public class MyGameScreen implements Screen {
    private SpriteBatch batch;

    public MyGameScreen() {
        batch = new SpriteBatch();
    }

    @Override
    public void show() {
        // Код, который выполняется при отображении экрана
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1); // Белый цвет
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        // Рендеринг ваших объектов
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        // Код, который выполняется при изменении размера окна
    }

    @Override
    public void pause() {
        // Код, который выполняется при приостановке игры
    }

    @Override
    public void resume() {
        // Код, который выполняется при возобновлении игры
    }

    @Override
    public void hide() {
        // Код, который выполняется при скрытии экрана
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}