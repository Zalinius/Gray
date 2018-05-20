package com.company.geometry;

import com.company.utilities.BezierPoint;
import java.awt.*;
import java.awt.geom.GeneralPath;

public class EbbingShape {

    private BezierPoint[] p;
    private Color color;

    public EbbingShape(BezierPoint[] p, Color color){
        this.p = p;

        this.color = color;
    }

    public void update(double delta){
        for(int i = 0; i != p.length; ++i){
            p[i].update(delta);
        }
        //p[0].p.move(p[0].x()+delta*50, p[0].y()+delta*50);
        //p[1].p.move(p[1].x()+delta*50, p[1].y()-delta*50);
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
}
