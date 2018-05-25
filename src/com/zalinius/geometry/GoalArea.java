package com.zalinius.geometry;

import com.zalinius.utilities.Position;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class GoalArea {
    private Position p;
    private int width;

    public GoalArea(Position p, int width) {
        this.p = p;
        this.width = width;
    }

    public void update(double delta) {

    }


    public void render(Graphics2D g) {
        int sections = 5;
        double sectionWidth = width/ (double)sections;

        for(int x = 0; x != sections; ++x){
            for(int y = 0; y != sections; ++y){
                if((x+y) % 2 == 0)
                    g.setColor(Color.black);
                else
                    g.setColor(Color.white);

                Rectangle2D rect = new Rectangle2D.Double(p.x - width/2 + x*sectionWidth, p.y - width/2 + y*sectionWidth, sectionWidth, sectionWidth);
                g.fill(rect);
            }
        }

    }

    public boolean isColliding(Position point) {
        return getShape().contains(point.x, point.y);
    }

    private Rectangle2D.Double getShape(){
        return new Rectangle2D.Double(p.x - width/2, p.y - width/2, width, width);
    }

    public static GoalArea goalAreaFactory(Position p){
        return new GoalArea(new Position(p.x, p.y), 75);
    }
}
