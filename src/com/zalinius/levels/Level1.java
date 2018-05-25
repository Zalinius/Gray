package com.zalinius.levels;

import com.zalinius.gameStuff.Player;
import com.zalinius.architecture.GameContainer;
import com.zalinius.geometry.GoalArea;
import com.zalinius.geometry.NeutralArea;
import com.zalinius.geometry.ebbs.AbstractEbbingShape;
import com.zalinius.geometry.ebbs.OvalEbbless;
import com.zalinius.utilities.Position;

import java.awt.*;

public class Level1 extends Level {
    private static final double BALANCE_SHIFT = Player.EASY_SHIFT;

    public Level1() {
        super(new Player(new Position(100, GameContainer.HEIGHT / 2), BALANCE_SHIFT));

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
        NeutralArea[] areas = new NeutralArea[0];

        return areas;
    }

    @Override
    protected AbstractEbbingShape[] setUpEbbs() {
        AbstractEbbingShape[] ebbs = new AbstractEbbingShape[1];
        double width = 300, height = 200;
        ebbs[0] = new OvalEbbless(Position.center(width,height), width, height);

        return ebbs;
    }

    @Override
    protected GoalArea setUpGoalAreas() {
        return GoalArea.goalAreaFactory(new Position(1200, GameContainer.HEIGHT / 2));
    }

    @Override
    public Level reset() {
        return new Level1();
    }

}
