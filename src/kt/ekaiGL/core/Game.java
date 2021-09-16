package kt.ekaiGL.core;

import kt.ekaiGL.display.Screen;

/**
 * @author Kai Tinkess on February 24, 2020.
 */
public abstract class Game implements Updatable {
    private final InputHandler input;

    public Game(String title, InputHandler input) {
        Screen.initDisplay(title);
        this.input = input;
    }

    @Override
    public void update(long frameLength) {

    }

    public abstract void initResourceManager(String filepath);
}
