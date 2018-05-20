package com.company.geometry;

import com.company.utilities.BezierPoint;
import com.company.utilities.Position;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;

public abstract class AbstractEbbingShape {

    private BezierPoint[] p;
    private Color color;

    public AbstractEbbingShape(BezierPoint[] p, Color color){
        this.p = p;

        this.color = color;
    }

    public void update(double delta){

        ebb(delta);
/*        for(int i = 0; i != p.length; ++i){
            p[i].update(delta);
        }*/
    }

    public void render(Graphics2D g){

        GeneralPath path = new GeneralPath(GeneralPath.WIND_EVEN_ODD);
        path.moveTo(p[0].x(), p[0].y());

        for(int i = 0; i != p.length; ++i){
            path.curveTo(p[i].cA.x, p[i].cA.y, p[(i+1)%p.length].cB.x, p[(i+1)%p.length].cB.y, p[(i+1)%p.length].x(), p[(i+1)%p.length].y());
        }
        path.closePath();

        g.setColor(color);
        g.fill(path);
    }

    /**
     * You must ebbb!
     * Called every update
     * @param delta The time increment
     */
    protected abstract void ebb(double delta);

    public boolean isColliding(Position point){

        GeneralPath path = new GeneralPath(GeneralPath.WIND_EVEN_ODD);
        path.moveTo(p[0].x(), p[0].y());

        for(int i = 0; i != p.length; ++i){
            path.curveTo(p[i].cA.x, p[i].cA.y, p[(i+1)%p.length].cB.x, p[(i+1)%p.length].cB.y, p[(i+1)%p.length].x(), p[(i+1)%p.length].y());
        }
        path.closePath();

        if(path.contains(new Point2D.Double(point.x, point.y)))
            return true;
        else
            return false;

    }
}
