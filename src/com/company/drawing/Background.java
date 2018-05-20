package com.company.drawing;

import com.company.architecture.GameContainer;

import java.awt.*;

public class Background {

    public static void drawBackground(Graphics2D g){
        Rectangle screen = new Rectangle(GameContainer.WIDTH, GameContainer.HEIGHT);
        g.setColor(Color.black);
        g.fill(screen);
    }
}
