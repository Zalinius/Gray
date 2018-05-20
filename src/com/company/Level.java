package com.company;

import com.company.geometry.AbstractEbbingShape;
import com.company.geometry.NeutralArea;

import java.awt.*;

public abstract class Level {
    private Player player;
    private AbstractEbbingShape[] ebbs;
    private NeutralArea[] neutralZones;

    public Level(Player player, AbstractEbbingShape[] ebbs, NeutralArea[] neutralZones){
        this.player = player;
        this.ebbs = ebbs;
        this.neutralZones = neutralZones;
    }

    public void update(double delta){
        for(int i = 0; i != ebbs.length; ++i)
            ebbs[i].update(delta);

        for(int i = 0; i != neutralZones.length; ++i)
            neutralZones[i].update(delta);

        player.update(delta);

        player.playerLocation(collisions());
    }

    public void render(Graphics2D g){
        for(int i = 0; i != ebbs.length; ++i)
            ebbs[i].render(g);

        for(int i = 0; i != neutralZones.length; ++i)
            neutralZones[i].render(g);

        player.render(g);

    }

    public Player player() {return player;}


    enum Balance {DARK, NEUTRAL, LIGHT};


    private Balance collisions(){
        for(int i = 0; i != ebbs.length; ++i){
            if(ebbs[i].isColliding(player.position()))
                return Balance.LIGHT;
        }

        return Balance.DARK;
    }

    protected void setEbbs(AbstractEbbingShape[] ebbs){
        this.ebbs = ebbs;
    }

}
