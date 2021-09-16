package kt.ekaiGL.util;

import kt.ekaiGL.display.EPoint;

public class Location {
    private int tileX, tileY;

    public Location(int tileX, int tileY) {
        this.tileX = tileX;
        this.tileY = tileY;
    }

    public EPoint convert() {
        return new EPoint((int) (tileX * Globals.constant("TILE_SIZE")), (int)  (tileY * Globals.constant("TILE_SIZE")));
    }

    public int getTileX() {
        return tileX;
    }

    public void setTileX(int tileX) {
        this.tileX = tileX;
    }

    public int getTileY() {
        return tileY;
    }

    public void setTileY(int tileY) {
        this.tileY = tileY;
    }
}
