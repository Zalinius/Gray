package com.company.architecture;

import com.company.InputListener;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameContainer extends DoubleBufferedFrame{
    private LevelManager levelManager;
    public static final int WIDTH = 1366, HEIGHT = 768;

    public static void main(String[] args) {
        LevelManager levelManager = new LevelManager();
        new GameLoop(levelManager).gameLoop();

    }

    public GameContainer(LevelManager levelManager) {
        super("It's a Game!");
        setResizable(false);
        setSize(WIDTH, HEIGHT);
        setVisible(true);
        setBackground(Color.black);

        this.levelManager = levelManager;

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
}
