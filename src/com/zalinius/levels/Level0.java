package com.zalinius.levels;

import java.awt.*;

import com.zalinius.architecture.GameStage;
import com.zalinius.gameStuff.Player;
import com.zalinius.geometry.GoalArea;
import com.zalinius.geometry.NeutralArea;
import com.zalinius.geometry.ebbs.AbstractEbbingShape;
import com.zalinius.physics.Point2D;

public class Level0 extends Level{
    public Level0(){
        super(new Player( new Point2D(100, GameStage.GAME_HEIGHT/2 ), Player.EASY_SHIFT) );

    }

    @Override
    public void update(double delta) {
        super.update(delta);
    }

    @Override
    public void render(Graphics2D g) {
        super.render(g);
        g.setColor(Color.BLACK);
        g.drawString("Neutrality is Balance",500, 100);
    }

    @Override
    protected NeutralArea[] setUpNeutralAreas() {
        NeutralArea[] neutrals = new NeutralArea[1];
        neutrals[0] = new NeutralArea(new Point2D(GameStage.GAME_WIDTH/2, GameStage.GAME_HEIGHT/2), 2000);
        return neutrals;
    }

    @Override
    protected AbstractEbbingShape[] setUpEbbs() {
        return new AbstractEbbingShape[0];
    }

    @Override
    protected GoalArea setUpGoalAreas() {
        Point2D goalPoint2D = new Point2D(1200, GameStage.GAME_HEIGHT/2);
        return GoalArea.goalAreaFactory(goalPoint2D);
    }

    @Override
    public Level reset() {
        return new Level0();
    }

}
