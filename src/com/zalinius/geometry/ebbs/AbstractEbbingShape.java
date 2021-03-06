package com.zalinius.geometry.ebbs;

import com.zalinius.architecture.GameObject;
import com.zalinius.physics.Point2D;

import java.awt.*;

/**
 * A shape which ebbs and flows.
 * In theory, it changes shape every frame.
 * It's collider should as well.
 */
public abstract class AbstractEbbingShape implements GameObject {
    private Color color;

    public AbstractEbbingShape(Color color){
        this.color = color;
    }


    public void update(double delta){
        ebb(delta);
    }

    public void render(Graphics2D g){
        g.setColor(color);
    }

    /**
     * You must ebbb!
     * Called every update
     * @param delta The time increment
     */
    protected abstract void ebb(double delta);

    public abstract boolean isColliding(Point2D point);
}
