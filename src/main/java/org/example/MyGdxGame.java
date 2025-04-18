package org.example;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import org.example.gameObjects.primitive.GameObject;
import org.example.gameObjects.Player;

import java.util.LinkedList;
import java.util.function.Function;

public class MyGdxGame extends ApplicationAdapter {
    private OrthographicCamera camera;

    LinkedList<GameObject> objects = new LinkedList<>();
    LinkedList<Function<Void, Void>> tick_handlers = new LinkedList<>();

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

        tick_handlers.add(unused -> {
            if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
                System.out.println("Trip signal was received.");
                Gdx.app.exit();
            }

            return null;
        });
    }

    @Override
    public void render() {
        // Очистка экрана
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        for (Function<Void, Void> v : tick_handlers) {
            v.apply(null);
        }

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

    public void addTickHandler(Function<Void, Void> new_handler) {
        tick_handlers.add(new_handler);
    }
}