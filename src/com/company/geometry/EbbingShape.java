package com.company.geometry;

import com.company.utilities.BezierPoint;
import java.awt.*;
import java.awt.geom.GeneralPath;

public class EbbingShape extends AbstractEbbingShape{

    public EbbingShape(BezierPoint[] p, Color color){
        super(p, color);

    }


    @Override
    protected void ebb(double delta) {
        for(int i = 0; i != p.length; ++i){
            p[i].update(delta);
        }
    }


}
