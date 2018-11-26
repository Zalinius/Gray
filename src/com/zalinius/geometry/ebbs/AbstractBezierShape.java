package com.zalinius.geometry.ebbs;

import com.zalinius.utilities.BezierPoint;
import com.zalinius.physics.Point2D;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;

public abstract class AbstractBezierShape extends AbstractEbbingShape{

    private BezierPoint[] p;

    AbstractBezierShape(BezierPoint[] p, Color color){
        super(color);
        this.p = p;

    }

    public void update(double delta){
        super.update(delta);
    }

    public void render(Graphics2D g){
        super.render(g);

        //A close planar shape
        GeneralPath path = new GeneralPath(Path2D.WIND_EVEN_ODD);
        path.moveTo(p[0].x(), p[0].y());

        for(int i = 0; i != p.length; ++i){
            path.curveTo(p[i].cA.x, p[i].cA.y, p[(i+1)%p.length].cB.x, p[(i+1)%p.length].cB.y, p[(i+1)%p.length].x(), p[(i+1)%p.length].y());
        }
        path.closePath();
        g.fill(path);
    }


    protected BezierPoint[] getPoints(){
        return  p;
    }

    public boolean isColliding(Point2D point){

        GeneralPath path = new GeneralPath(Path2D.WIND_EVEN_ODD);
        path.moveTo(p[0].x(), p[0].y());

        for(int i = 0; i != p.length; ++i){
            path.curveTo(p[i].cA.x, p[i].cA.y, p[(i+1)%p.length].cB.x, p[(i+1)%p.length].cB.y, p[(i+1)%p.length].x(), p[(i+1)%p.length].y());
        }
        path.closePath();

        return path.contains(new java.awt.geom.Point2D.Double(point.x, point.y));

    }
}
