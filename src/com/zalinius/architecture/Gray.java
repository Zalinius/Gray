package com.zalinius.architecture;

import java.awt.Graphics2D;

public class Gray implements Graphical, Logical{
	
    private LevelManager levelManager;
	
	public Gray() {
		GameContainer gc = new GameContainer(this, this);
		levelManager = new LevelManager(gc);
		gc.startGame();
	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Gray game = new Gray();
	}

	@Override
	public void update(double delta) {
		levelManager.update(delta);
	}

	@Override
	public void render(Graphics2D g) {
		levelManager.render(g);
	}

}
