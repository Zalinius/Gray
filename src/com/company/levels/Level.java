package com.company.levels;

import com.company.Player;
import com.company.geometry.ebbs.AbstractEbbingShape;
import com.company.geometry.GoalArea;
import com.company.geometry.NeutralArea;
import com.company.Balance;

import java.awt.*;

public abstract class Level {
    protected Player player;
    protected AbstractEbbingShape[] ebbs;
    protected NeutralArea[] neutralZones;
    protected GoalArea goalArea;

    public Level(Player player, AbstractEbbingShape[] ebbs, NeutralArea[] neutralZones, GoalArea goalArea){
        this.player = player;
        this.ebbs = ebbs;
        this.neutralZones = neutralZones;
        this.goalArea = goalArea;
    }

    public void update(double delta){
        for(int i = 0; i != ebbs.length; ++i)
            ebbs[i].update(delta);

        for(int i = 0; i != neutralZones.length; ++i)
            neutralZones[i].update(delta);

        goalArea.update(delta);

        player.update(delta);

        player.playerLocation(collisions());
    }

    public void render(Graphics2D g){
        for(int i = 0; i != ebbs.length; ++i)
            ebbs[i].render(g);

        for(int i = 0; i != neutralZones.length; ++i)
            neutralZones[i].render(g);

        goalArea.render(g);


        player.render(g);

    }

    public Player player() {return player;}


    protected Balance collisions(){

        player.outOfGoal();
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

        return Balance.DARK;
    }

    protected NeutralArea defaultNeutralArea(){
        return new NeutralArea(player.position(), 50);
    }

    protected void setEbbs(AbstractEbbingShape[] ebbs){
        this.ebbs = ebbs;
    }

    protected void setNeutrals(NeutralArea[] areas) {this.neutralZones = areas;}

    public abstract Level reset();
}