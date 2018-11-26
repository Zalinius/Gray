package com.zalinius.levels;

import com.zalinius.architecture.GameStage;
import com.zalinius.gameStuff.Player;
import com.zalinius.geometry.GoalArea;
import com.zalinius.geometry.NeutralArea;
import com.zalinius.geometry.ebbs.AbstractEbbingShape;
import com.zalinius.physics.Point2D;

import java.awt.*;

public class Level2 extends Level {
    private static final double BALANCE_SHIFT = Player.EASY_SHIFT;

    public Level2() {
        super(new Player(new Point2D(100, GameStage.GAME_HEIGHT / 2), BALANCE_SHIFT));

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
        return new AbstractEbbingShape[0];
    }

    @Override
    protected GoalArea setUpGoalAreas() {
        return GoalArea.goalAreaFactory(new Point2D(1200, GameStage.GAME_HEIGHT / 2));
    }

    @Override
    public Level reset() {
        return new Level2();
    }


}
