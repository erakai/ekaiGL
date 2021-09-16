package kt.ekaiGL.display;

import java.awt.*;

/**
 * @author Kai Tinkess on February 25, 2020.
 */
public interface Renderable {
    void render(Graphics g, EPoint point);
    EPoint getEPoint();
}
