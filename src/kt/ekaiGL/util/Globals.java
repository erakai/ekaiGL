package kt.ekaiGL.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kai Tinkess on February 21, 2020.
 */
public class Globals {
    private Globals() {}

    private final static Map<String, Double> constants;

    static {
        constants = new HashMap<>();

        createConstant("DISPLAY_SCALE", 1.0);
        createConstant("FRAMES_PER_SECOND", 30);
        createConstant("TILE_SIZE", 32);
        createConstant("TILE_WIDTH", 40);
        createConstant("TILE_HEIGHT", 40);
    }

    public static void createConstant(String name, double value) {
        constants.put(name, value);
    }

    public static double constant(String name) {
        return constants.get(name);
    }
}
