package com.company.utilities;


public class PlayerInput {


    private int x, y;

    public PlayerInput(){
        x = 0;
        y = 0;
    }

    public int x(){
        return x;
    }

    public int y(){
        return y;
    }

    public void up() {
        y = -1;
    }

    public void down() {
        y = 1;
    }

    public void left(){
        x = -1;
    }

    public void right(){
        x = 1;
    }

    public void deUp(){
        if(y == -1)
            y = 0;
    }

    public void deDown(){
        if(y == 1)
            y = 0;
    }

    public void deLeft(){
        if(x == -1)
            x = 0;
    }

    public void deRight(){
        if(x == 1)
            x = 0;
    }

}
