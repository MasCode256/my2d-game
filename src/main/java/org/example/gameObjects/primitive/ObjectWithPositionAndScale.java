package org.example.gameObjects.primitive;

import org.example.MyGdxGame;

public class ObjectWithPositionAndScale extends ObjectWithPosition {
    protected float width = 50, height = 50;

    public ObjectWithPositionAndScale(MyGdxGame game) {
        super(game);
    }

    public ObjectWithPositionAndScale(MyGdxGame game, float x, float y) {
        super(game, x, y);
    }

    public ObjectWithPositionAndScale(MyGdxGame game, float x, float y, float angle) {
        super(game, x, y, angle);
    }

    public ObjectWithPositionAndScale(MyGdxGame game, float x, float y, float angle, float width, float height) {
        super(game, x, y, angle);

        this.width = width;
        this.height = height;
    }


    public void setWidth(float width) {
        this.width = width;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public void addWidth(float a) {
        this.width += a;
    }

    public void addHeight(float a) {
        this.height += a;
    }
}
