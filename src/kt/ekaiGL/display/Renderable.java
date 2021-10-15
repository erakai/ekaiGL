package kt.ekaiGL.display;

import java.awt.*;

/**
 * @author Kai Tinkess on February 25, 2020.
 */
public interface Renderable {
    void render(Graphics g, EPoint point);
    EPoint getEPoint();

    /**
     * Returns the layer the item wil be drawn on. Lower layers will be drawn on top of higher layers. For example,
     * every renderable with layer 90 will be drawn on top of all the renderables with layer 100.
     *
     * @return The layer the item should be drawn on
     */
    default int getLayer() {
        return 100;
    }
}
