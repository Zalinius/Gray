package com.zalinius.levels;

import com.zalinius.architecture.IGameObject;
import com.zalinius.gameStuff.Player;
import com.zalinius.geometry.GoalArea;
import com.zalinius.geometry.NeutralArea;
import com.zalinius.gameStuff.Balance;
import com.zalinius.geometry.ebbs.AbstractEbbingShape;

import java.awt.*;

public abstract class Level implements IGameObject {
    private Player player;
    private AbstractEbbingShape[] ebbs;
    private NeutralArea[] neutralAreas;
    private GoalArea goalArea;

    public Level(Player player){
        this.player = player;

        ebbs = setUpEbbs();
        neutralAreas = setAllNeutralAreas();
        goalArea = setUpGoalAreas();
    }

    public void update(double delta){
        for(int i = 0; i != ebbs.length; ++i)
            ebbs[i].update(delta);

        for(int i = 0; i != neutralAreas.length; ++i)
            neutralAreas[i].update(delta);

        goalArea.update(delta);

        player.update(delta);

        player.playerLocation(collisions());
    }

    public void render(Graphics2D g){
        for(int i = 0; i != ebbs.length; ++i) {
            ebbs[i].render(g);
        }

        for(int i = 0; i != neutralAreas.length; ++i) {
            neutralAreas[i].render(g);
        }

        goalArea.render(g);

        player.render(g);
    }

    public Player player() {return player;}


    private Balance collisions(){

        player.outOfGoal();
        if(goalArea.isColliding(player.position())) {
            player.goal();
            return Balance.NEUTRAL;
        }

        for(int i = 0; i != neutralAreas.length; ++i){
            if(neutralAreas[i].isColliding(player.position())) {
                return Balance.NEUTRAL;
            }
        }

        for(int i = 0; i != ebbs.length; ++i){
            if(ebbs[i].isColliding(player.position())) {
                return Balance.LIGHT;
            }
        }

        return Balance.DARK;
    }


    private NeutralArea[] setAllNeutralAreas(){
        NeutralArea[] levelAreas = setUpNeutralAreas();
        NeutralArea defaultArea = defaultNeutralArea();

        NeutralArea[] allAreas = new NeutralArea[levelAreas.length + 1];

        for(int i = 0; i != levelAreas.length; ++i){
            allAreas[i] = levelAreas[i];
        }
        allAreas[allAreas.length-1] = defaultArea;

        return allAreas;
    }

    private NeutralArea defaultNeutralArea(){
        return new NeutralArea(player.position(), 50);
    }

    protected abstract NeutralArea[] setUpNeutralAreas();

    protected abstract AbstractEbbingShape[] setUpEbbs();

    protected abstract GoalArea setUpGoalAreas();


    public abstract Level reset();
}
