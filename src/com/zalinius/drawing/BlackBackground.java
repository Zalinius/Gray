package com.zalinius.drawing;

import com.zalinius.architecture.GameStage;

import java.awt.*;

public class BlackBackground {

    public static void drawBackground(Graphics2D g){
        Rectangle screen = new Rectangle(GameStage.GAME_WIDTH, GameStage.GAME_HEIGHT);
        g.setColor(Color.black);
        g.fill(screen);
    }
}
