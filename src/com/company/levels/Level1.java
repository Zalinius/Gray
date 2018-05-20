package com.company.levels;

import com.company.Balance;
import com.company.Player;
import com.company.architecture.GameContainer;
import com.company.geometry.GoalArea;
import com.company.geometry.NeutralArea;
import com.company.geometry.ebbs.AbstractEbbingShape;
import com.company.geometry.ebbs.MonoEbb;
import com.company.utilities.Position;

import java.awt.*;


public class Level1 extends Level{

    private MonoEbb m1, m2;

    public Level1(){
        super(new Player( new Position(100, GameContainer.HEIGHT/2 ), Player.EASY_SHIFT), null, null, GoalArea.goalAreaFactory(new Position(1200, GameContainer.HEIGHT/2)) );
        m1 = new MonoEbb(new Position(400, GameContainer.HEIGHT/2), 200);
        m2 = new MonoEbb(new Position(850, GameContainer.HEIGHT/2), 200);

        setEbbs(ebbs());
        setNeutrals(neutrals());
    }


    @Override
    public void update(double delta) {
        super.update(delta);
        m1.update(delta);
        m2.update(delta);

    }

    @Override
    public void render(Graphics2D g) {
        m1.render(g);
        m2.render(g);
        super.render(g);

    }

    @Override
    public Level reset() {
        return new Level1();
    }

    private AbstractEbbingShape[] ebbs() {
        AbstractEbbingShape[] ebbs = new AbstractEbbingShape[0];

        return ebbs;
    }

    private NeutralArea[] neutrals(){
        NeutralArea[] neutrals = new NeutralArea[2];
        neutrals[0] = defaultNeutralArea();
        neutrals[1] = new NeutralArea(new Position(625, GameContainer.HEIGHT/2), 50);
        return neutrals;
    }

    protected Balance collisions(){
        player().outOfGoal();
        if(goalArea.isColliding(player.position())) {
            player.goal();
            return Balance.NEUTRAL;
        }

        for(int i = 0; i != neutralZones.length; ++i){
            if(neutralZones[i].isColliding(player.position()))
                return Balance.NEUTRAL;
        }

        for(int i = 0; i != ebbs.length; ++i){
            if(ebbs[i].isColliding(player.position()))
                return Balance.LIGHT;
        }

        if(m1.isColliding(player.position()))
            return  Balance.LIGHT;

        if(m2.isColliding(player.position()))
            return  Balance.LIGHT;


        return Balance.DARK;
    }


}
