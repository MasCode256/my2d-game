package org.example.gameObjects.primitive;

import org.example.MyGdxGame;

import com.badlogic.gdx.math.Rectangle;

public class ObjectWithCoordinates extends GameObject {
    protected float x = 0f, y = 0f;

    public ObjectWithCoordinates(MyGdxGame game) {
        super(game);
    }

    public ObjectWithCoordinates(MyGdxGame game, float x, float y) {
        super(game);

        this.x = x;
        this.y = y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void addX(float a) {
        this.x += a;
    }

    public void addY(float a) {
        this.y += a;
    }

    protected void updateCoordinates(Rectangle bounds) {
        bounds.x = this.x;
        bounds.y = this.y;
    }
}
