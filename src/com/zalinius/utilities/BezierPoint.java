package com.zalinius.utilities;

import com.zalinius.physics.Point2D;

public class BezierPoint {
    private Point2D p;
    public final Point2D start;
    public final Point2D cB;
	public final Point2D cA;

    public BezierPoint(Point2D p, Point2D cB, Point2D cA){
        this.p = p;
        this.start = p;
        this.cB = cB;
        this.cA = cA;

    }

    public double x(){
        return p.x;
    }

    public double y(){
        return p.y;
    }


    public void update(double delta){
        ebb();
        t += delta;
    }

    private final double ampX = 4*Math.random(), ampY = 4*Math.random();
    private double t = Math.random(), period = 5 * Math.random() + 5; // in seconds
    public void ebb(){
        double x = ampX * Math.sin((Math.PI*2 / period) * t) + start.x;
        double y = ampY * Math.cos((Math.PI*2 / period) * t) + start.y;
        p = new Point2D(x, y);
    }


}
