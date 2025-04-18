package org.example.gameObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Polygon;
import org.example.MyGdxGame;
import org.example.gameObjects.primitive.Damageable;

public class Player extends Damageable {
    private ShapeRenderer shapeRenderer;
    private Polygon rectangle;
    private float speed = 2;

    private static final float INITIAL_HP = 100f;

    public Player(MyGdxGame game) {
        super(game, INITIAL_HP, 100, 100);
        initPolygon();
    }

    public Player(MyGdxGame game, float x, float y) {
        super(game, INITIAL_HP, x, y, 45);
        initPolygon();
    }

    private void initPolygon() {
        shapeRenderer = new ShapeRenderer();

        float[] vertices = new float[]{
                -width / 2, -height / 2,  // Левый нижний
                width / 2, -height / 2,   // Правый нижний
                width / 2, height / 2,    // Правый верхний
                -width / 2, height / 2     // Левый верхний
        };

        // Применяем поворот
        for (int i = 0; i < vertices.length; i += 2) {
            float x = vertices[i];
            float y = vertices[i + 1];
            vertices[i] = (float) (x * Math.cos(Math.toRadians(angle)) - y * Math.sin(Math.toRadians(angle))) + this.x; // Используем this.x
            vertices[i + 1] = (float) (x * Math.sin(Math.toRadians(angle)) + y * Math.cos(Math.toRadians(angle))) + this.y; // Используем this.y
        }

        rectangle = new Polygon(vertices);
    }

    private void updatePolygon() {
        float[] vertices = new float[]{
                -width / 2, -height / 2,  // Левый нижний
                width / 2, -height / 2,   // Правый нижний
                width / 2, height / 2,    // Правый верхний
                -width / 2, height / 2     // Левый верхний
        };

        // Применяем поворот и обновляем координаты
        for (int i = 0; i < vertices.length; i += 2) {
            float x = vertices[i];
            float y = vertices[i + 1];
            vertices[i] = (float) (x * Math.cos(Math.toRadians(angle)) - y * Math.sin(Math.toRadians(angle))) + this.x;
            vertices[i + 1] = (float) (x * Math.sin(Math.toRadians(angle)) + y * Math.cos(Math.toRadians(angle))) + this.y;
        }

        rectangle.setVertices(vertices);
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

        updatePolygon();

        this.draw();
    }

    public void draw() {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line); // Используем Filled для заполненной фигуры
        shapeRenderer.setColor(Color.BLACK);
        shapeRenderer.polygon(rectangle.getTransformedVertices());
        shapeRenderer.end();
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }
}