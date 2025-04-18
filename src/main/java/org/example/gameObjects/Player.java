package org.example.gameObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import org.example.MyGdxGame;
import org.example.gameObjects.primitive.Damageable;

public class Player extends Damageable {
    private ShapeRenderer shapeRenderer;
    private Rectangle bounds;
    private float speed = 2;

    private static final float INITIAL_HP = 100f;

    public Player(MyGdxGame game) {
        super(game, INITIAL_HP, 100, 100);

        shapeRenderer = new ShapeRenderer();
        bounds = new Rectangle(this.x, this.y, 50, 50);
    }

    public Player(MyGdxGame game, float x, float y) {
        super(game, INITIAL_HP, x, y);

        shapeRenderer = new ShapeRenderer();
        bounds = new Rectangle(this.x, this.y, 50, 50);
    }


    @Override
    public void update() {
        if (Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.LEFT) || Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.A)) {
            this.x -= speed;
        }
        if (Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.RIGHT) || Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.D)) {
            this.x += speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.D)) {
            this.y += speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN) || Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.D)) {
            this.y -= speed;
        }

        updateCoordinates(bounds);

        this.draw();
    }

    public void draw() {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.BLACK);
        shapeRenderer.rect(bounds.x, bounds.y, bounds.width, bounds.height);
        shapeRenderer.end();
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }

    public Rectangle getBounds() {
        return bounds;
    }
}