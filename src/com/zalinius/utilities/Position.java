package com.zalinius.utilities;

import com.zalinius.architecture.GameContainer;

public class Position {
    public double x, y;

    public Position(double x, double y){
        this.x = x;
        this.y = y;
    }

    public void move(double x, double y){
        this.x = x;
        this.y = y;
    }

    public static Position center(){
        return new Position(GameContainer.WIDTH/2, GameContainer.HEIGHT/2);
    }

    public static Position center(double width, double height){
        return new Position((GameContainer.WIDTH - width)/2, (GameContainer.HEIGHT-height)/2);
    }

}
