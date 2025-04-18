package org.example.gameObjects.primitive;

import com.badlogic.gdx.Gdx;
import org.example.MyGdxGame;

public class KeyboardEvent extends TickHandler {
    private int key;

    public KeyboardEvent(MyGdxGame game, int key) {
        super(game);
        this.key = key;
    }

    protected void handleKeyboardEvent() {}

    @Override
    public void update() {
        if (Gdx.input.isKeyPressed(key)) {
            handleKeyboardEvent();
        }
    }
}
