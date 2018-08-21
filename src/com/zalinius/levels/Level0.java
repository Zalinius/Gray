package com.zalinius.levels;

import com.zalinius.gameStuff.Player;
import com.zalinius.architecture.GameContainer;
import com.zalinius.geometry.GoalArea;
import com.zalinius.geometry.NeutralArea;
import com.zalinius.geometry.ebbs.AbstractEbbingShape;
import com.zalinius.utilities.Position;
import java.awt.*;

public class Level0 extends Level{
    public Level0(){
        super(new Player( new Position(100, GameContainer.HEIGHT/2 ), Player.EASY_SHIFT) );

    }

    @Override
    public void update(double delta) {
        super.update(delta);
    }

    @Override
    public void render(Graphics2D g) {
        super.render(g);
        g.drawString("Neutrality is Balance",500, 100);
    }

    @Override
    protected NeutralArea[] setUpNeutralAreas() {
        NeutralArea[] neutrals = new NeutralArea[1];
        neutrals[0] = new NeutralArea(new Position(GameContainer.WIDTH/2, GameContainer.HEIGHT/2), 2000);
        return neutrals;
    }

    @Override
    protected AbstractEbbingShape[] setUpEbbs() {
        return new AbstractEbbingShape[0];
    }

    @Override
    protected GoalArea setUpGoalAreas() {
        Position goalPosition = new Position(1200, GameContainer.HEIGHT/2);
        return GoalArea.goalAreaFactory(goalPosition);
    }

    @Override
    public Level reset() {
        return new Level0();
    }

}
