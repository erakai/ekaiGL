package kt.ekaiGL.display;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Kai Tinkess on February 25, 2020.
 */
public class Screen extends JPanel {
    private static JFrame frame;
    private static Screen instance;

    private final static List<Renderable> renderables = new ArrayList<>();
    private final static List<Renderable> toRemove = new ArrayList<>();

    public static Screen instance() {
        return instance;
    }

    public static void initDisplay(String title) {
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        instance = new Screen();
        frame.add(instance);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Renderable r: renderables) r.render(g, r.getEPoint());

        renderables.removeAll(toRemove);
        toRemove.clear();
    }

    public static void addRenderable(Renderable r) {
        renderables.add(r);
    }

    public static void removeRenderable(Renderable r) {
        toRemove.add(r);
    }

    public void addComponent(JComponent comp) {
        add(comp);
    }


}
