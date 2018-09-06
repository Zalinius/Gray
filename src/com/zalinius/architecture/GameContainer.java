package com.zalinius.architecture;

import com.zalinius.gameStuff.Player;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameContainer extends DoubleBufferedFrame{

	private static final long serialVersionUID = 1L;

	public static final int GAME_WIDTH = 1366, GAME_HEIGHT = 768;

    private GameLoop gameLoop;
    private LevelManager levelManager;

    @SuppressWarnings("unused")
	public static void main(String[] args) {
        new GameContainer();
    }

    private GameContainer() {
        this("Game!", GAME_WIDTH, GAME_HEIGHT, Color.black);
    }

    private GameContainer(String windowText, int width, int height, Color backgroundColor) {
    	super(windowText);
        setResizable(false);
        setSize(width, height);
        setVisible(true);
        setBackground(backgroundColor);

        levelManager = new LevelManager(this);
        gameLoop = new GameLoop(this, levelManager);
        gameLoop.gameLoop(); //Starts main game loop


        addWindowListener(new WindowAdapter() {
                              public void windowClosing(WindowEvent e) {
                                  dispose();
                                  System.exit(0);
                              }
                          }
        );

        addKeyListener(new InputListener(levelManager.player()));
    }
    
    public void paintBuffer(Graphics2D g){
        levelManager.render(g);

    }

    void addKeys(Player player){
        addKeyListener(new InputListener(player));
        addWindowListener(new WindowAdapter() {
                              public void windowClosing(WindowEvent e) {
                                  dispose();
                                  System.exit(0);
                              }
                          }
        );
    }
}
