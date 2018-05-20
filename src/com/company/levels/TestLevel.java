package com.company.levels;

import com.company.Player;
import com.company.geometry.ebbs.AbstractEbbingShape;
import com.company.geometry.ebbs.EbbingShape;
import com.company.geometry.GoalArea;
import com.company.geometry.NeutralArea;
import com.company.utilities.BezierPoint;
import com.company.utilities.Position;

import java.awt.*;

public class TestLevel extends Level {

    public TestLevel() {
        super(new Player(new Position(50, 50 ), .5), null, new NeutralArea[1], GoalArea.goalAreaFactory(new Position(1200, 700)));
        setEbbs(ebbs());
        NeutralArea[] areas = new NeutralArea[1];
        areas[0] = defaultNeutralArea();
        setNeutrals(areas);

    }

    private AbstractEbbingShape[] ebbs(){
        AbstractEbbingShape[] ebbs = new AbstractEbbingShape[1];

        BezierPoint b0 = new BezierPoint(new Position(50, 50), new Position(100, 40), new Position(0, 60));
        BezierPoint b1 = new BezierPoint(new Position(150, 400), new Position(170, 350), new Position(130, 450));
        BezierPoint b2 = new BezierPoint(new Position(600, 700), new Position(500, 700), new Position(700, 700));
        BezierPoint b3 = new BezierPoint(new Position(750, 100), new Position(700, 120), new Position(800, 10));

        BezierPoint[] b = new BezierPoint[4];
        b[0] = b0;
        b[1] = b1;
        b[2] = b2;
        b[3] = b3;

        ebbs[0] = new EbbingShape(b, Color.white);
        return ebbs;
    }



    @Override
    public void update(double delta) {
        super.update(delta);
    }

    @Override
    public void render(Graphics2D g) {
        super.render(g);
    }

    @Override
    public Level reset() {
        return new TestLevel();
    }
}
