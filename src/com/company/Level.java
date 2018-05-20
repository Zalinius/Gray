package com.company;

import java.awt.*;

public abstract class Level {
    private Player player;

    public Level(){}

    public abstract void update(double delta);

    public abstract void render(Graphics2D g);

    public Player player() {return player;}
}
