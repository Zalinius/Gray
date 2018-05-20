package com.company;

import com.company.geometry.AbstractEbbingShape;

import java.awt.*;

public abstract class Level {
    private Player player;
    private AbstractEbbingShape[] ebbs;

    public Level(){}

    public abstract void update(double delta);

    public abstract void render(Graphics2D g);

    public Player player() {return player;}


    enum Balance {DARK, NEUTRAL, LIGHT};


    private Balance collisions(){
        for(int i = 0; i != ebbs.length; ++i){
            if(ebbs[i].isColliding(player.position()))
                return Balance.LIGHT;
        }

        return Balance.DARK;
    }
}
