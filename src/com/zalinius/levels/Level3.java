package com.zalinius.levels;

import com.zalinius.gameStuff.Player;
import com.zalinius.architecture.GameContainer;
import com.zalinius.geometry.GoalArea;
import com.zalinius.geometry.NeutralArea;
import com.zalinius.geometry.ebbs.AbstractEbbingShape;
import com.zalinius.geometry.ebbs.MonoEbb;
import com.zalinius.utilities.Position;

import java.awt.*;


public class Level3 extends Level{

    public Level3(){
        super(new Player( new Position(100, GameContainer.HEIGHT/2 ), Player.MEDIUM_SHIFT));

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
        neutrals[0] = new NeutralArea(new Position(625, GameContainer.HEIGHT/2), 50);
        return neutrals;
    }

    @Override
    protected AbstractEbbingShape[] setUpEbbs() {
        AbstractEbbingShape[] ebbs = new AbstractEbbingShape[2];

        ebbs[0] = new MonoEbb(new Position(400, GameContainer.HEIGHT/2), 200);
        ebbs[1] = new MonoEbb(new Position(850, GameContainer.HEIGHT/2), 200);

        return ebbs;
    }

    @Override
    protected GoalArea setUpGoalAreas() {
        return GoalArea.goalAreaFactory(new Position(1200, GameContainer.HEIGHT/2));
    }

    @Override
    public Level reset() {
        return new Level3();
    }

}
