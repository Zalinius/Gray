package com.zalinius.geometry;

import com.zalinius.utilities.Position;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class NeutralArea {
    private Position p;
    private double diameter;

    public NeutralArea(Position p, double diameter){
        this.p = new Position(p.x, p.y);
        this.diameter = diameter;

    }

    public void update(double delta){

    }

    public void render(Graphics2D g){
        g.setColor(Color.gray);
        g.fill(new Ellipse2D.Double(p.x - diameter/2, p.y - diameter/2, diameter, diameter));
    }

    public boolean isColliding(Position point){
        Ellipse2D area = new Ellipse2D.Double(p.x - diameter/2, p.y - diameter/2, diameter, diameter);
        return area.contains(point.x, point.y);
    }
}
