package com.company.geometry.ebbs;

import com.company.utilities.Position;
import com.company.utilities.ZMath;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class MonoEbb{

    private Position p;
    private int startDiameter, diameter;

    public MonoEbb(Position p, int diameter){
        this.p = p;
        this.startDiameter = diameter;
        this.diameter = diameter;
    }

    double time = Math.random();
    public void update(double delta){
        ebb();
        time+= delta;
    }

    public void render(Graphics2D g){
        g.setColor(Color.white);
        Ellipse2D oval = new Ellipse2D.Double(p.x - diameter/2, p.y - diameter/2, diameter, diameter);
        g.fill(oval);
    }

    private double amp = Math.random()*20 + 90;
    protected void ebb() {
        diameter = (int)ZMath.oscillate(amp, diameter, time, 7, startDiameter);
    }

    public boolean isColliding(Position point){
        Ellipse2D oval = new Ellipse2D.Double(p.x - diameter/2, p.y - diameter/2, diameter, diameter);
        return oval.contains(point.x, point.y);
    }
}
