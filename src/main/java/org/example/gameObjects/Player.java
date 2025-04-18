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
    private float speed = 2; // скорость движения игрока

    public Player(MyGdxGame game) {
        super(game, 100f, 100, 100);

        shapeRenderer = new ShapeRenderer();
        bounds = new Rectangle(this.x, this.y, 50, 50);
    }


    @Override
    public void update() {
        if (Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.LEFT) || Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.A)) {
            this.x -= speed; // Движение влево
        }
        if (Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.RIGHT) || Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.D)) {
            this.x += speed; // Движение вправо
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.D)) {
            this.y += speed; // Движение вправо
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN) || Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.D)) {
            this.y -= speed; // Движение вправо
        }

        updateCoordinates(bounds);

        this.draw();
    }

    public void draw() {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.BLACK); // Установите цвет игрока
        shapeRenderer.rect(bounds.x, bounds.y, bounds.width, bounds.height); // Рисуем прямоугольник
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