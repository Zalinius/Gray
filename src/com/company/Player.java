package com.company;

import com.company.levels.Level;
import com.company.utilities.PlayerInput;
import com.company.utilities.Position;
import com.company.utilities.ZMath;
import com.company.levels.Level;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Player {

    private int PLAYER_DIAMETER = 30;

    public static final double EASY_SHIFT = .25, MEDIUM_SHIFT = .4, HARD_SHIFT = .6;

    private Position p;
    private PlayerInput input;
    private boolean alive;
    private boolean isInGoal;

    private double balance; //Always between -1.0 and 1.0, inclusive
    private double balanceShift;
    private Balance balanceState;

    public Player(Position p, double balanceShift){
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

    public Position position(){
        return p;
    }

    private void processMovement(double delta){
        double speed = 150;

        if(input.x() != 0 && input.y() != 0)
            speed /= Math.sqrt(2);

        p.x += speed * input.x() * delta;
        p.y += speed * input.y() * delta;
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


