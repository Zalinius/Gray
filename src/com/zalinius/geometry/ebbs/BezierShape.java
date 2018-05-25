package com.zalinius.geometry.ebbs;

import com.zalinius.utilities.BezierPoint;
import java.awt.*;

public class BezierShape extends AbstractBezierShape {

    public BezierShape(BezierPoint[] p, Color color){
        super(p, color);

    }


    @Override
    protected void ebb(double delta) {
        for(int i = 0; i != getPoints().length; ++i){
            getPoints()[i].update(delta);
        }
    }


}
