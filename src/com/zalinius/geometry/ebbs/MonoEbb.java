package com.zalinius.geometry.ebbs;

import com.zalinius.utilities.Position;
import com.zalinius.utilities.ZMath;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class MonoEbb extends AbstractEbbingShape {

    private Position p;
    private int startDiameter, diameter;

    public MonoEbb(Position p, int diameter){
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
        diameter = (int)ZMath.oscillate(amp, diameter, time, 7, startDiameter);
    }

    public boolean isColliding(Position point){
        Ellipse2D oval = new Ellipse2D.Double(p.x - diameter/2, p.y - diameter/2, diameter, diameter);
        return oval.contains(point.x, point.y);
    }
}
