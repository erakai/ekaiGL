package kt.ekaiGL.core;

import kt.ekaiGL.display.Screen;
import kt.ekaiGL.util.Globals;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kai Tinkess on February 24, 2020.
 */
public abstract class Game {
    private final InputHandler input;

    private List<Updatable> updatables = new ArrayList<>();
    private List<Updatable> toRemove = new ArrayList<>();

    private long lastFrame;
    private long lengthOfProperFrame;
    private boolean running = true;

    public Game(String title, InputHandler input) {
        Screen.initDisplay(title, input);
        this.input = input;
        addUpdatable(input);
    }

    public void start() {
        setProperFrameLength();
        lastFrame = System.currentTimeMillis();
        while (running) {
            update(System.currentTimeMillis() - lastFrame);
        }
    }

    public void update(long frameLength) {
        lastFrame = System.currentTimeMillis();

        long sleepTime = frameLength - lengthOfProperFrame;
        if (sleepTime > 0) {
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (Updatable u: updatables) {
            u.update();
        }

        updatables.removeAll(toRemove);
        toRemove.clear();
    }

    public void setProperFrameLength() {
        double fps = Globals.constant("FRAMES_PER_SECOND");
        lengthOfProperFrame = (long) ((60.0 * 1000.0) / fps);
    }

    public void stopGame() {
        running = false;
    }

    public void addUpdatable(Updatable u) {
        updatables.add(u);
    }

    public void removeUpdatable(Updatable u) {
        toRemove.add(u);
    }

    public abstract void initResourceManager(String filepath);
}
