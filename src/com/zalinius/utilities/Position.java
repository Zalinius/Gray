package com.zalinius.utilities;

import com.zalinius.architecture.GameContainer;

public class Position {
    public double x, y;

    public Position(double x, double y){
        this.x = x;
        this.y = y;
    }

    public void move(double newX, double newY){
        this.x = newX;
        this.y = newY;
    }

    public static Position center(){
        return new Position(GameContainer.GAME_WIDTH/2, GameContainer.GAME_HEIGHT/2);
    }

    public static Position center(double width, double height){
        return new Position((GameContainer.GAME_WIDTH - width)/2, (GameContainer.GAME_HEIGHT-height)/2);
    }

}
