package Ch08_Classes_and_Objects;

/**
 * Write an enum type TrafficLight, whose constants (RED, GREEN, YELLOW) take
 * one parameter--the duration of the light. Write a program to test the
 * TrafficLight enum so that it displays the enum constants and their durations.
 *
 * @author David
 */
public class Ex08_10_TrafficLight {

    public static void main(String[] args) {

        for (TrafficLight light : TrafficLight.values()) {
            System.out.printf("%s: Duration: %ds\n",
                    light, light.getDuration());
            for (int s = light.getDuration(); s > 0; --s) {
                try {
                    System.out.printf("%d ", s);
                    Thread.sleep(1000); // 1s
                } catch (InterruptedException ex) {
                    System.err.println(ex.getMessage());
                }
            }
            System.out.println();
        }
    }

}
