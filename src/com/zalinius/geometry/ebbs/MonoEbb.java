package com.zalinius.geometry.ebbs;

import com.zalinius.physics.Point2D;
import com.zalinius.utilities.EbbMath;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class MonoEbb extends AbstractEbbingShape {

    private Point2D p;
    private int startDiameter, diameter;

    public MonoEbb(Point2D p, int diameter){
        super(Color.white);
        this.p = p;
        this.startDiameter = diameter;
        this.diameter = diameter;
    }

    double time = Math.random();
    public void update(double delta){
        super.update(delta);
        time+= delta;
    }

    public void render(Graphics2D g){
        super.render(g);
        Ellipse2D oval = new Ellipse2D.Double(p.x - diameter/2, p.y - diameter/2, diameter, diameter);
        g.fill(oval);
    }

    private double amp = Math.random()*20 + 90;
    protected void ebb(double delta) {
        diameter = (int)EbbMath.oscillate(amp, diameter, time, 7, startDiameter);
    }

    public boolean isColliding(Point2D point){
        Ellipse2D oval = new Ellipse2D.Double(p.x - diameter/2, p.y - diameter/2, diameter, diameter);
        return oval.contains(point.x, point.y);
    }
}
