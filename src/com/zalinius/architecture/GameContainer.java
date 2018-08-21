package com.zalinius.architecture;

import com.zalinius.gameStuff.Player;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameContainer extends DoubleBufferedFrame{

	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 1366, HEIGHT = 768;

    private GameLoop gameLoop;
    private LevelManager levelManager;

    public static void main(String[] args) {
        new GameContainer();
    }

    private GameContainer() {
        super("It's a Game!");
        setResizable(false);
        setSize(WIDTH, HEIGHT);
        setVisible(true);
        setBackground(Color.black);

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
