package com.zalinius.geometry.ebbs;

import com.zalinius.physics.Point2D;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class OvalEbbless extends AbstractEbbingShape{

    private Point2D p;
    private double width, height;

    public OvalEbbless(Point2D p, double width, double height){
        super(Color.white);
        this.p = p;
        this.width = width;
        this.height = height;
    }

    public void render(Graphics2D g){
        super.render(g);
        Ellipse2D oval = new Ellipse2D.Double(p.x, p.y, width, height);
        g.fill(oval);
    }

    @Override
    protected void ebb(double delta) {

    }

    @Override
    public boolean isColliding(Point2D point) {
        Ellipse2D oval = new Ellipse2D.Double(p.x, p.y, width, height);
        return oval.contains(point.x, point.y);
    }
}
