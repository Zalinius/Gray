package com.zalinius.geometry;

import java.awt.*;
import java.awt.geom.Ellipse2D;

import com.zalinius.physics.Point2D;

public class NeutralArea {
    private Point2D p;
    private double diameter;

    public NeutralArea(Point2D p, double diameter){
        this.p = new Point2D(p.x, p.y);
        this.diameter = diameter;

    }

    public void update(double delta){

    }

    public void render(Graphics2D g){
        g.setColor(Color.gray);
        g.fill(new Ellipse2D.Double(p.x - diameter/2, p.y - diameter/2, diameter, diameter));
    }

    public boolean isColliding(Point2D point){
        Ellipse2D area = new Ellipse2D.Double(p.x - diameter/2, p.y - diameter/2, diameter, diameter);
        return area.contains(point.x, point.y);
    }
}
