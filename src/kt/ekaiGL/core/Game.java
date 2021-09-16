package kt.ekaiGL.core;

import kt.ekaiGL.display.Screen;

/**
 * @author Kai Tinkess on February 24, 2020.
 */
public class Game implements Updatable {

    public Game(String title) {
        Screen.initDisplay(title);
    }

    @Override
    public void update(long frameLength) {

    }

}
