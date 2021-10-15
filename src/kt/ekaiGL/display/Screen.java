package kt.ekaiGL.display;

import kt.ekaiGL.core.InputHandler;
import kt.ekaiGL.util.Globals;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Kai Tinkess on February 25, 2020.
 */
public class Screen extends JPanel {
    private static JFrame frame;
    private static Screen instance;

    //TODO: Add scenes
    private final static List<Renderable> renderables = new ArrayList<>();
    private final static List<Renderable> toRemove = new ArrayList<>();

    public static Screen instance() {
        return instance;
    }

    public static void initDisplay(String title, InputHandler input) {
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        instance = new Screen();
        instance.init(input);
        frame.add(instance);
        frame.pack();
        frame.setVisible(true);
    }

    private void init(InputHandler input) {
        setFocusable(true);
        setLayout(null);
        setPreferredSize(new Dimension((int) Globals.constant("TILE_WIDTH"), (int) Globals.constant("TILE_HEIGHT")));
        setBackground(Color.BLACK);

        addMouseListener(input);
        addKeyListener(input);
        addMouseListener(input);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Map<Integer, Renderable> layeredRender = new TreeMap<>();
        for (Renderable r: renderables) layeredRender.put(r.getLayer(), r);
        for (Integer i: layeredRender.keySet()) layeredRender.get(i).render(g, layeredRender.get(i).getEPoint());

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
