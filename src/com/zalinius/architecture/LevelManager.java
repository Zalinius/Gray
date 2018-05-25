package com.zalinius.architecture;

import com.zalinius.gameStuff.Player;
import com.zalinius.drawing.Background;
import com.zalinius.levels.*;

import java.awt.*;

/**
 * Holds and loads levels as they are played.
 * May also reset a level.
 * ??Handles Input??
 */
public class LevelManager implements IGameObject {

    private GameContainer gc;

    private Level[] levels;
    private int activeLevel;


    public LevelManager(GameContainer gc){
        levels = new Level[5];
        levels[0] = new Level0();
        levels[1] = new Level1();
        levels[2] = new Level2();
        levels[3] = new Level3();
        levels[4] = new Level5();

        this.gc = gc;

        loadLevel(0);
    }

    public void update(double delta){
        levels[activeLevel].update(delta);
        if(!levels[activeLevel].player().isAlive())
            resetLevel();
        if(levels[activeLevel].player().isInGoal() && levels[activeLevel].player().isNeutral())
            nextLevel();
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


    private void nextLevel() {
        loadLevel(activeLevel + 1);
    }

}
