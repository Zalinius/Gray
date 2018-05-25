package com.zalinius.utilities;


public class BezierPoint {
    public Position p;
    private Position start;
    public Position cB, cA;

    public BezierPoint(Position p, Position cB, Position cA){
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
        p.x = ampX * Math.sin((Math.PI*2 / period) * t) + start.x;
        p.y = ampY * Math.cos((Math.PI*2 / period) * t) + start.y;

    }


}
