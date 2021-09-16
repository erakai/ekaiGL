package kt.ekaiGL.objects;

import kt.ekaiGL.display.EPoint;
import kt.ekaiGL.display.Renderable;
import kt.ekaiGL.util.Location;

import java.awt.*;

public abstract class Entity implements Renderable {
    private String name;
    private Location loc;
    private AnimationPlayer anim;
    private boolean visible;

    public Entity(String name, Location loc) {
        this.loc = loc;

        anim = new AnimationPlayer();
    }

    public Entity(String name) {
        this(name, new Location(0,0));
    }

    @Override
    public void render(Graphics g, EPoint point) {
        if (visible) g.drawImage(anim.nextFrame(), point.getScaledX(), point.getScaledY(), null);
    }

    @Override
    public EPoint getEPoint() {
        return loc.convert();
    }

    public String getName() {
        return name;
    }

    public Location getLoc() {
        return loc;
    }

    public void setLoc(Location loc) {
        this.loc = loc;
    }

    public abstract void addAnimations();
}
