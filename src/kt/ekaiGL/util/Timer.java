package kt.ekaiGL.util;

import java.util.HashMap;

/**
 * @author Kai Tinkess on February 21, 2020.
 */
public class Timer {

    private long startTime;
    private HashMap<String, Long> markedTimes;

    public Timer() {
        startTime = System.nanoTime();
        markedTimes = new HashMap<>();
        markedTimes.put("start", startTime);
    }

    public int getSecondsSinceStart() {
        return (int)((System.nanoTime() - startTime)/1000000000.0);
    }

    public int getSecondsSinceMarkedTime(String key) {
        return (int)((System.nanoTime() - markedTimes.get(key))/1000000000.0);
    }

    public void markTime(String identifier) {
        markedTimes.put(identifier, System.nanoTime());
    }
}
