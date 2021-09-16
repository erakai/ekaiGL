package kt.ekaiGL.display;

import kt.ekaiGL.util.Globals;

/**
 * @author Kai Tinkess on February 25, 2020.
 */
public class EPoint {
    private int scaledX, scaledY;
    private int rawX, rawY;

    public EPoint(int x, int y, boolean scaled) {
        if (scaled) {
            this.scaledX = x;
            this.scaledY = y;
            int[] raw = unscale(x, y);

            this.rawX = raw[0];
            this.rawY = raw[1];
        } else {
            this.rawX = x;
            this.rawY = y;
            int[] scaledData = scale(x, y);

            this.rawX = scaledData[0];
            this.rawY = scaledData[1];
        }
    }

    public EPoint(int x, int y) {
        this(x, y, false);
    }

    public int getScaledX() {
        return scaledX;
    }

    public int getScaledY() {
        return scaledY;
    }

    public int getRawX() {
        return rawX;
    }

    public int getRawY() {
        return rawY;
    }

    public static int[] unscale(int scaledX, int scaledY) {
        return new int[] {(int) (scaledX / Globals.constant("DISPLAY_SCALE")), (int) (scaledY / Globals.constant("DISPLAY_SCALE"))};
    }

    public static int[] unscale(int[] scaled) {
        return unscale(scaled[0], scaled[1]);
    }

    public static int[] scale(int rawX, int rawY) {
        return new int[] {(int) (rawX * Globals.constant("DISPLAY_SCALE")), (int) (rawY * Globals.constant("DISPLAY_SCALE"))};
    }

    public static int[] scale(int[] raw) {
        return scale(raw[0], raw[1]);
    }



}
