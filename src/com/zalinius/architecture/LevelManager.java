package com.zalinius.architecture;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collection;

import com.zalinius.architecture.input.Inputtable;
import com.zalinius.drawing.BlackBackground;
import com.zalinius.gameStuff.Player;
import com.zalinius.levels.*;

/**
 * Holds and loads levels as they are played.
 * May also reset a level.
 * ??Handles Input??
 */
public class LevelManager implements GameObject {

    private GameContainer gc;

    private Level[] levels;
    private int activeLevel;


    public LevelManager(GameContainer gc){
        levels = new Level[4];
        levels[0] = new Level0();
        levels[1] = new Level1();
        levels[2] = new Level3();
        levels[3] = new Level5();

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
        BlackBackground.drawBackground(g);

        levels[activeLevel].render(g);
    }

    public Player player(){
        return levels[activeLevel].player();
    }

    private void loadLevel(int index){
        activeLevel = index;
        gc.addControls(controls(levels[activeLevel].player()), null);
    }

    public void resetLevel(){
        levels[activeLevel] = levels[activeLevel].reset();
        gc.addControls(controls(levels[activeLevel].player()), null);
    }


    private void nextLevel() {
        loadLevel(activeLevel + 1);
    }
    
    private Collection<Inputtable> controls(Player player){
    	Collection<Inputtable> inputs = new ArrayList<>();
    	inputs.add(new Inputtable() {
			@Override
			public void released() {
                player.input().deUp();
			}
			@Override
			public void pressed() {
                player.input().up();				
			}
			@Override
			public int keyCode() {
				return KeyEvent.VK_UP;
			}
		});
    	inputs.add(new Inputtable() {
			@Override
			public void released() {
                player.input().deDown();
			}
			@Override
			public void pressed() {
                player.input().down();				
			}
			@Override
			public int keyCode() {
				return KeyEvent.VK_DOWN;
			}
		});
    	inputs.add(new Inputtable() {
			@Override
			public void released() {
                player.input().deLeft();
			}
			@Override
			public void pressed() {
                player.input().left();				
			}
			@Override
			public int keyCode() {
				return KeyEvent.VK_LEFT;
			}
		});
    	inputs.add(new Inputtable() {
			@Override
			public void released() {
                player.input().deRight();
			}
			@Override
			public void pressed() {
                player.input().right();				
			}
			@Override
			public int keyCode() {
				return KeyEvent.VK_RIGHT;
			}
		});
    	
    	
    	return inputs;
    }

}
