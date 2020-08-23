package Ch03_Intro_to_Classes;

import java.util.Random;

/**
 * Target-Heart-Rate Calculator) While exercising, you can use a heart-rate
 * monitor to see that your heart rate stays within a safe range suggested by
 * your trainers and doctors. According to the American Heart Association (AHA)
 * (www.americanheart.org/presenter.jhtml?identifier=4736), thee formula for
 * calculating your maximum heart rate in beats per minute is 220 minus your age
 * in years. Your target heart rate is a range that’s 50–85% of your maximum
 * heart rate. [Note: These formulas are estimates provided by the AHA. Maximum
 * and target heart rates may vary based on the health, fitness and gender of
 * the individual. Always consult a physician or qualified health care
 * professional before beginning or modifying an exercise program.]
 *
 * @author David
 */
public class HeartRates {

    private String firstName;
    private String lastName;
    private Date dateOfBirth;

    public HeartRates() {}
    public HeartRates(String firstName, String lastName, Date dateOfBirth) {
        setFirstName(firstName);
        setLastName(lastName);
        setDateOfBirth(dateOfBirth);
    }

    public int maximumHeartRate(int age) {
        int beatsPerMinute = 220 - age;
        return beatsPerMinute;
    }

    public double targetHeartRate(int age) {

        int maxHeartRate = maximumHeartRate(age);
        /*
        for (int range = 50; range < 85 + 1; ++range) {
            double percentage = range * 0.01;
            System.out.printf("range: %d%%\ttarget heart rate: %.2f\n",
                    range, maxHeartRate * percentage);
        }
        */
        double range = 50.0 + new Random().nextInt(85 - 50 + 1); // 50 + Random(0 to 35)
        double targetHeartRate = maxHeartRate * (range *= 0.01);
        System.out.printf("random range: %.0f%%\n", range * 100);
        return targetHeartRate;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public Date getDateOfBirth() { return dateOfBirth; }

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setDateOfBirth(Date dateOfBirth) { this.dateOfBirth = dateOfBirth; }
}
