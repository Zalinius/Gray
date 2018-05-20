package com.company;

import com.company.utilities.PlayerInput;
import com.company.utilities.Position;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Player {
    private Position p;
    private PlayerInput input;

    public Player(Position p){
        this.p = p;
        input = new PlayerInput();
    }

    public void update(double delta){
        processMovement(delta);
    }

    public void render(Graphics2D g){
        g.setColor(Color.gray);
        g.fill(new Ellipse2D.Double(p.x, p.y, 25, 25));
    }

    public PlayerInput input(){
        return input;
    }

    public Position position(){return  position();}

    private void processMovement(double delta){
        double speed = 100;
        //TODO Clamp diagonal speed
        p.x += speed * input.x() * delta;
        p.y += speed * input.y() * delta;
    }

}
