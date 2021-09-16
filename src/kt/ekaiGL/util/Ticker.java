package kt.ekaiGL.util;

/**
 * A class that ticks and can call an event when a set threshold is reached.
 *
 * tick() must be called manually be the client class.
 */
public class Ticker {

    private TickerEvent event;

    private int threshold;
    private int tick = 0;

    public Ticker(int threshold) {
        this(threshold, null);
    }

    public Ticker(int threshold, TickerEvent event) {
        this.threshold = (threshold / 10) * 60;
        setEvent(event);
    }

    public Ticker() {}

    public void setEvent(TickerEvent event) {
        this.event = event;
    }

    public void tick() {
        tick++;
        if (tick > threshold) {
            reset();
            runEvent();
        }
    }

    public void reset() {
        tick = 0;
    }

    public void runEvent() {
        event.act();
    }

    public int getThreshold() {
        return threshold;
    }

    public int getTick() {
        return tick;
    }

    public interface TickerEvent {
        void act();
    }

}
