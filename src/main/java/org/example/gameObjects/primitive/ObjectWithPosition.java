package org.example.gameObjects.primitive;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import org.example.MyGdxGame;

import com.badlogic.gdx.math.Rectangle;

public class ObjectWithPosition extends GameObject {
    protected float x = 0f, y = 0f, angle = 0f;

    public ObjectWithPosition(MyGdxGame game) {
        super(game);
    }

    public ObjectWithPosition(MyGdxGame game, float x, float y) {
        super(game);

        this.x = x;
        this.y = y;
    }

    public ObjectWithPosition(MyGdxGame game, float x, float y, float angle) {
        super(game);

        this.x = x;
        this.y = y;
        this.angle = angle;
    }

    public void setX(float x) {
        this.x = x;
    }
    public void setY(float y) { this.y = y; }
    public void setAngle(float angle) { this.angle = angle; }

    public void setPosition(Vector2 vector) {
        this.x = vector.x;
        this.y = vector.y;
    }


    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }
    public float getAngle() { return angle; }

    public void addX(float a) {
        this.x += a;
    }
    public void addY(float a) {
        this.y += a;
    }
    public void addAngle(float a) { this.angle += a; }

    protected void updateCoordinates(Rectangle bounds) {
        bounds.x = this.x;
        bounds.y = this.y;
    }

    protected void updateCoordinates(Polygon bounds) {
        bounds.setPosition(this.x, this.y);
        bounds.setRotation(this.angle);
    }
}
