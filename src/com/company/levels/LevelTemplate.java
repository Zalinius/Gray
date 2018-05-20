package com.company.levels;

import com.company.Player;
import com.company.architecture.GameContainer;
import com.company.geometry.ebbs.AbstractEbbingShape;
import com.company.geometry.GoalArea;
import com.company.geometry.NeutralArea;
import com.company.utilities.Position;

import java.awt.*;

public class LevelTemplate extends Level{
    private static final double BALANCE_SHIFT = .5;
    public LevelTemplate(){
        super(new Player( new Position(100, GameContainer.HEIGHT/2 ), BALANCE_SHIFT), null, null, GoalArea.goalAreaFactory(new Position(1200, GameContainer.HEIGHT/2)) );

        setEbbs(ebbs());
        setNeutrals(neutrals());
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
        return new LevelTemplate();
    }

    private AbstractEbbingShape[] ebbs() {
        AbstractEbbingShape[] ebbs = new AbstractEbbingShape[0];

        return ebbs;
    }

    private NeutralArea[] neutrals(){
        NeutralArea[] neutrals = new NeutralArea[1];
        neutrals[0] = defaultNeutralArea();
        return neutrals;
    }
}
