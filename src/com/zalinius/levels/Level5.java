package com.zalinius.levels;

import com.zalinius.gameStuff.Player;
import com.zalinius.geometry.ebbs.AbstractBezierShape;
import com.zalinius.geometry.ebbs.AbstractEbbingShape;
import com.zalinius.geometry.ebbs.BezierShape;
import com.zalinius.geometry.GoalArea;
import com.zalinius.geometry.NeutralArea;
import com.zalinius.utilities.BezierPoint;
import com.zalinius.utilities.Position;

import java.awt.*;

public class Level5 extends Level {
    private static final double BALANCE_SHIFT = Player.MEDIUM_SHIFT;
    public Level5() {
        super(new Player(new Position(50, 50 ), BALANCE_SHIFT));
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
    protected NeutralArea[] setUpNeutralAreas() {
        return new NeutralArea[0];
    }

    @Override
    protected AbstractEbbingShape[] setUpEbbs() {
        AbstractBezierShape[] ebbs = new AbstractBezierShape[1];

        BezierPoint b0 = new BezierPoint(new Position(50, 50), new Position(100, 40), new Position(0, 60));
        BezierPoint b1 = new BezierPoint(new Position(150, 400), new Position(170, 350), new Position(130, 450));
        BezierPoint b2 = new BezierPoint(new Position(600, 700), new Position(500, 700), new Position(700, 700));
        BezierPoint b3 = new BezierPoint(new Position(750, 100), new Position(700, 120), new Position(800, 10));

        BezierPoint[] b = new BezierPoint[4];
        b[0] = b0;
        b[1] = b1;
        b[2] = b2;
        b[3] = b3;

        ebbs[0] = new BezierShape(b, Color.white);
        return ebbs;
    }

    @Override
    protected GoalArea setUpGoalAreas() {
        return GoalArea.goalAreaFactory(new Position(1200, 700));
    }

    @Override
    public Level reset() {
        return new Level5();
    }
}
