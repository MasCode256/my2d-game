package org.example;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import org.example.gameObjects.primitive.GameObject;
import org.example.gameObjects.Player;
import org.example.gameObjects.tickHandlers.HandleEscapePress;

import java.util.LinkedList;

public class MyGdxGame extends ApplicationAdapter {
    private OrthographicCamera camera;

    LinkedList<GameObject> objects = new LinkedList<>();

    public OrthographicCamera camera() {
        return camera;
    }

    public LinkedList<GameObject> getObjects() {
        return objects;
    }

    @Override
    public void create() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 600);

        objects.add(new Player(this, 100, 100));
        objects.add(new HandleEscapePress(this));
    }

    @Override
    public void render() {
        // Очистка экрана
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        for (GameObject object : objects) {
            object.update();
        }
    }

    @Override
    public void dispose() {
        for (GameObject object : objects) {
            object.dispose();
        }
    }
}