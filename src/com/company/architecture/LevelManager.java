package com.company.architecture;

import com.company.Player;
import com.company.drawing.Background;
import com.company.geometry.EbbingShape;
import com.company.utilities.BezierPoint;
import com.company.utilities.Position;

import java.awt.*;

/**
 * Holds and loads levels as they are played.
 * May also reset a level.
 * ??Handles Input??
 */
public class LevelManager {

    //private Level[] levels;
    //private int activeLevel;

    private EbbingShape ebb;
    private Player player;

    public LevelManager(){
        BezierPoint b0 = new BezierPoint(new Position(50, 50), new Position(100, 40), new Position(0, 60));
        BezierPoint b1 = new BezierPoint(new Position(150, 400), new Position(170, 350), new Position(130, 450));
        BezierPoint b2 = new BezierPoint(new Position(600, 700), new Position(500, 700), new Position(700, 700));
        BezierPoint b3 = new BezierPoint(new Position(750, 100), new Position(700, 120), new Position(800, 10));

        BezierPoint[] b = new BezierPoint[4];
        b[0] = b0;
        b[1] = b1;
        b[2] = b2;
        b[3] = b3;

        ebb = new EbbingShape(b, Color.white);

        player = new Player(new Position(50, 50 ));
    }

    public void update(double delta){
        ebb.update(delta);

        player.update(delta);

        //levels[activeLevel].update(delta);
    }

    public void render(Graphics2D g){
        Background.drawBackground(g);
        ebb.render(g);

        player.render(g);

        //levels[activeLevel].render(g);
    }

    public Player player(){
        return player;
    }
}
