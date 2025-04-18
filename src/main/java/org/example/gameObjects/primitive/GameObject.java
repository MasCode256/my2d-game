package org.example.gameObjects.primitive;

import org.example.MyGdxGame;

public class GameObject {
    protected MyGdxGame game;

    public GameObject(MyGdxGame game) {
        this.game = game;
    }

    public final void delete() {
        game.getObjects().remove(this);
    }

    public void update() {}
    public void dispose() {}
}
