package com.zalinius.gameStuff;

import com.zalinius.architecture.GameObject;
import com.zalinius.utilities.PlayerInput;
import com.zalinius.utilities.ZMath;
import com.zalinius.physics.Point2D;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Player implements GameObject {

    private int PLAYER_DIAMETER = 30;

    public static final double EASY_SHIFT = .25, MEDIUM_SHIFT = .4, HARD_SHIFT = .6;

    private Point2D p;
    private PlayerInput input;
    private boolean alive;
    private boolean isInGoal;

    private double balance; //Always between -1.0 and 1.0, inclusive
    private double balanceShift;
    private Balance balanceState;

    public Player(Point2D p, double balanceShift){
        this.p = p;
        this.input = new PlayerInput();
        this.alive = true;

        this.balance = 0.0;
        this.balanceState = Balance.NEUTRAL;
        this.balanceShift = balanceShift;
    }

    public void update(double delta){
        processMovement(delta);


        shiftBalance(delta);
        if(balance == -1.0 || balance == 1.0)
            playerDeath();


    }

    public void render(Graphics2D g){

        for(int width = PLAYER_DIAMETER; width > 0; width -= 2){
            int colorInt = (width / 4) % 2;
            if(colorInt == 0)
                g.setColor(getDarkColor());
            else
                g.setColor(getLightColor());

            g.fill(new Ellipse2D.Double(p.x - width/2.0, p.y - width/2.0, width, width));
        }


    }

    public PlayerInput input(){
        return input;
    }

    private void shiftBalance(double delta){


        switch (balanceState){
            case DARK:
                balance -= balanceShift*delta;
                break;
            case NEUTRAL: //Head towards a neutral state
                if(balance < 0.0) { //Become lighter
                    balance += balanceShift*delta;
                    balance = ZMath.clamp(balance, -1.0, 0.0);
                }
                else if(balance > 0.0) { //Become darker
                    balance -= balanceShift*delta;
                    balance = ZMath.clamp(balance, 0.0, 1.0);
                }
                break;
            case LIGHT:
                balance += balanceShift*delta;
                break;
            default:
                break;

        }
        balance = ZMath.clamp(balance, -1.0, 1.0);

    }

    public Point2D position(){
        return p;
    }

    private void processMovement(double delta){
        double speed = 150;

        if(input.x() != 0 && input.y() != 0)
            speed /= Math.sqrt(2);

        double x = p.x + speed * input.x() * delta;
        double y = p.y + speed * input.y() * delta;
        p = new Point2D(x, y);
    }

    private Color getLightColor(){
        int lightness;
        if(balance < 0)
            lightness = 255 - (int)( balance * -1 * 255);
        else
            lightness = 255;


        return new Color(lightness, lightness, lightness);
    }

    private Color getDarkColor(){
        int darkness;
        if(balance > 0)
            darkness = (int)( balance * 255);
        else
            darkness = 0;


        return new Color(darkness, darkness, darkness);
    }

    public void playerLocation(Balance location){
        this.balanceState = location;
    }

    private void playerDeath(){
        alive = false;
    }

    public boolean isAlive() {
        return alive;
    }

    public boolean isNeutral() {return balance == 0.0;}

    public void goal() {isInGoal = true;}

    public void outOfGoal(){isInGoal = false;}

    public boolean isInGoal(){
        return isInGoal;
    }
}


