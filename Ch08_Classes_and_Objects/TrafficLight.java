package Ch08_Classes_and_Objects;

/**
 * Exercise 8.10
 * @author David
 */
public enum TrafficLight {
    
    RED(45), GREEN(30), YELLOW(5);

    // accessor for field duration
    public int getDuration() {
        return seconds;
    }

    // enum constructor
    private TrafficLight(int duration) {
        seconds = duration;
    }

    // instance field
    private final int seconds;
}
