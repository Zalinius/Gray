package com.zalinius.gameStuff;

import com.zalinius.architecture.GameObject;
import com.zalinius.utilities.PlayerInput;
import com.zalinius.utilities.ZMath;
import com.zalinius.physics.Point2D;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Player implements GameObject {

    private int PLAYER_DIAMETER = 30;
    private PlayerColor pColor;

    public static final double EASY_SHIFT = .25, MEDIUM_SHIFT = .4, HARD_SHIFT = .6;

    private Point2D p;
    private PlayerInput input;
    private boolean alive;
    private boolean isInGoal;

    private double balance; //Always between -1.0 and 1.0, inclusive
    private double balanceShift;
    private Balance balanceState;
    
    public Player(Point2D p, double balanceShift)
    {
        this.p = p;
        this.input = new PlayerInput();
        this.alive = true;

        this.balance = 0.0;
        this.balanceState = Balance.NEUTRAL;
        this.balanceShift = balanceShift;
        
        this.pColor = new PlayerColor();
    }

    public Player(Point2D p, double balanceShift, Color lightColor, Color darkColor){
        this.p = p;
        this.input = new PlayerInput();
        this.alive = true;

        this.balance = 0.0;
        this.balanceState = Balance.NEUTRAL;
        this.balanceShift = balanceShift;
        
        this.pColor = new PlayerColor(lightColor, darkColor);
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
        if(balance < 0) {
        	return pColor.getColour(balance);
        }
        else
        	return pColor.getLightColor();
    }

    private Color getDarkColor(){
        if(balance > 0) {
            return pColor.getColour(balance);
        }
        return pColor.getDarkColor();
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
    
    private class PlayerColor{
    	private Color light, dark;
    	
    	public PlayerColor() {
    		GregorianCalendar cal = new GregorianCalendar();
    		int month = cal.get(Calendar.MONTH);
    		int day = cal.get(Calendar.DAY_OF_MONTH);
    		System.out.println(month + " " + day);
    		
    		if(month == Calendar.DECEMBER && day == 25) {
    			System.out.println("Christmas!");

        		this.light = new Color(220, 0, 0);
        		this.dark = new Color(0, 150, 70);
    		}
    		else if(month == Calendar.OCTOBER && day == 31) {
    			System.out.println("Halloween");
    			this.light = new Color(255, 140, 0);
    			this.dark = new Color(0, 0, 0);
    		}
    		else {
    			this.light = new Color(255, 255, 255);
    			this.dark = new Color(0, 0, 0);
    		}

    	}
    	
    	public PlayerColor(Color light, Color dark) {
    		this.light = light;
    		this.dark = dark;
    	}
    	public Color getLightColor() {
    		return light;
    	}
    	public Color getDarkColor() {
    		return dark;
    	}
    	public Color getMiddle() {
    		int red = (light.getRed() + dark.getRed())/2;
    		int green = (light.getGreen() + dark.getGreen())/2;
    		int blue = (light.getBlue() + dark.getBlue())/2;
    		
    		return new Color(red, green, blue);
    	}
    	
    	public Color getColour(double colourBalance) {
    		double lightMulti, darkMulti;
    		if(colourBalance > 0) {
    			lightMulti = Math.abs(colourBalance);
    			darkMulti = 1 - lightMulti;
    		}else {
    			darkMulti = Math.abs(colourBalance);
    			lightMulti = 1 - darkMulti;
    		}
    		int red = (int) (light.getRed()*lightMulti + dark.getRed()*darkMulti);
    		int green = (int) (light.getGreen()*lightMulti + dark.getGreen()*darkMulti);
    		int blue = (int) (light.getBlue()*lightMulti + dark.getBlue()*darkMulti);
    		
    		return new Color(red, green, blue);
    	}
    }
}


