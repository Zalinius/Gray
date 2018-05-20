package com.company.architecture;

import com.company.Player;
import com.company.drawing.Background;
import com.company.Level;
import com.company.levels.TestLevel;

import java.awt.*;

/**
 * Holds and loads levels as they are played.
 * May also reset a level.
 * ??Handles Input??
 */
public class LevelManager {

    private GameContainer gc;

    private Level[] levels;
    private int activeLevel;


    public LevelManager(GameContainer gc){
        levels = new Level[1];
        levels[0] = new TestLevel();

        this.gc = gc;

        loadLevel(0);
    }

    public void update(double delta){
        levels[activeLevel].update(delta);
        if(!levels[activeLevel].player().isAlive())
            resetLevel();
    }

    public void render(Graphics2D g){
        Background.drawBackground(g);

        levels[activeLevel].render(g);
    }

    public Player player(){
        return levels[activeLevel].player();
    }

    private void loadLevel(int index){
        activeLevel = index;
        gc.addKeys(levels[activeLevel].player());
    }

    public void resetLevel(){
        levels[activeLevel] = levels[activeLevel].reset();
        gc.addKeys(levels[activeLevel].player());
    }

}
