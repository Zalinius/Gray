package com.zalinius.levels;

import com.zalinius.gameStuff.Player;
import com.zalinius.architecture.GameStage;
import com.zalinius.geometry.GoalArea;
import com.zalinius.geometry.NeutralArea;
import com.zalinius.geometry.ebbs.AbstractEbbingShape;
import com.zalinius.geometry.ebbs.MonoEbb;
import com.zalinius.physics.Point2D;

import java.awt.*;


public class Level3 extends Level{

    public Level3(){
        super(new Player( new Point2D(100, GameStage.GAME_HEIGHT/2 ), Player.MEDIUM_SHIFT));

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
        NeutralArea[] neutrals = new NeutralArea[1];
        neutrals[0] = new NeutralArea(new Point2D(625, GameStage.GAME_HEIGHT/2), 50);
        return neutrals;
    }

    @Override
    protected AbstractEbbingShape[] setUpEbbs() {
        AbstractEbbingShape[] ebbs = new AbstractEbbingShape[2];

        ebbs[0] = new MonoEbb(new Point2D(400, GameStage.GAME_HEIGHT/2), 200);
        ebbs[1] = new MonoEbb(new Point2D(850, GameStage.GAME_HEIGHT/2), 200);

        return ebbs;
    }

    @Override
    protected GoalArea setUpGoalAreas() {
        return GoalArea.goalAreaFactory(new Point2D(1200, GameStage.GAME_HEIGHT/2));
    }

    @Override
    public Level reset() {
        return new Level3();
    }

}
