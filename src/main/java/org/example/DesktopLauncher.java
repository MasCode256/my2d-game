package org.example;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
    public static void main (String[] arg) {
        System.out.println("My 2D Game alpha0.25.3");

        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "My 2D Game";
        config.width = 1920;
        config.height = 1080;
        config.fullscreen = true;

        new LwjglApplication(new MyGdxGame(), config);
    }
}