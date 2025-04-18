package org.example.gameObjects.primitive;

import org.example.MyGdxGame;

public class Damageable extends ObjectWithCoordinates {
    protected float hp = 1;

    public Damageable(MyGdxGame game) {
        super(game);
    }

    public Damageable(MyGdxGame game, float hp) {
        super(game);
        this.hp = hp;
    }

    public Damageable(MyGdxGame game, float x, float y) {
        super(game, x, y);
    }

    public Damageable(MyGdxGame game, float hp, float x, float y) {
        super(game, x, y);
        this.hp = hp;
    }

    public Damageable(MyGdxGame game, float hp, float x, float y, float angle) {
        super(game, x, y, angle);
        this.hp = hp;
    }


    public void damage(float damage_points) {
        this.hp -= damage_points;

        if (hp <= 0f) {
            delete();
        }
    }
}
