package com.company;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static java.lang.System.exit;

public class InputListener extends KeyAdapter {

    Player player;

    public InputListener(Player player){
        this.player = player;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keyPressSwitchBoard(e.getKeyCode(), true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keyPressSwitchBoard(e.getKeyCode(), false);
    }


    public void keyPressSwitchBoard(int keyCode, boolean press){
        switch(keyCode){
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                if(press)
                    player.input().up();
                else
                    player.input().deUp();
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                if(press)
                    player.input().down();
                else
                    player.input().deDown();
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                if(press)
                    player.input().left();
                else
                    player.input().deLeft();
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                if(press)
                    player.input().right();
                else
                    player.input().deRight();
                break;
            case KeyEvent.VK_ESCAPE:
                exit(0);
                break;
            default:
                //Do nothing
                break;
        }
    }

}
