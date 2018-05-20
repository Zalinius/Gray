package com.company.architecture;

public class GameLoop {
    final int TARGET_FPS = 60;

    GameContainer gameContainer;
    LevelManager levelManager;

    public GameLoop(GameContainer gameContainer, LevelManager levelManager){
        this.gameContainer = gameContainer;
        this.levelManager = levelManager;
    }


    public void gameLoop()
    {
        long lastLoopTime = System.nanoTime();
        final long OPTIMAL_TIME = 1000000000 / TARGET_FPS; //1 Second / 60 fps

        // keep looping round til the gameContainer ends
        boolean gameRunning = true;
        while (gameRunning)
        {
            // work out how long its been since the last update, this
            // will be used to calculate how far the entities should
            // move this loop
            long now = System.nanoTime();
            long updateLength = now - lastLoopTime;
            lastLoopTime = now;
            double delta = updateLength / 1E9;

            //System.out.print((lastLoopTime-System.nanoTime() + OPTIMAL_TIME)/1000000 + "\n");

            //System.out.print("FPS: " + 1/delta + "\n");

            // update the gameContainer logic
            levelManager.update(delta);

            // draw everyting
            render();

            // we want each frame to take 10 milliseconds, to do this
            // we've recorded when we started the frame. We add 10 milliseconds
            // to this and then factor in the current time to give
            // us our final value to wait for
            // remember this is in ms, whereas our lastLoopTime etc. vars are in ns.
            try{
                Thread.sleep( (lastLoopTime-System.nanoTime() + OPTIMAL_TIME)/1000000 );
            }
            catch (IllegalArgumentException e){
                e.printStackTrace();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * Updates the gameContainer logic
     * @param delta The ratio of the last frame time, with respect to a perfect 60 FPS
     */
    public void update(double delta) {

    }

    public void render() {
        gameContainer.repaint();
    }
}
