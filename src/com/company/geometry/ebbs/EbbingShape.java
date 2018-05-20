package com.company.geometry.ebbs;

import com.company.geometry.ebbs.AbstractEbbingShape;
import com.company.utilities.BezierPoint;
import java.awt.*;

public class EbbingShape extends AbstractEbbingShape {

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
