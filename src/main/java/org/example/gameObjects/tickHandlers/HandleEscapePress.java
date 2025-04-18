package org.example.gameObjects.tickHandlers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import org.example.MyGdxGame;
import org.example.gameObjects.primitive.TickHandler;

public class HandleEscapePress extends TickHandler {
    public HandleEscapePress(MyGdxGame game) {
        super(game);
    }

    @Override
    public void update() {
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            game.dispose();
        }
    }
}
