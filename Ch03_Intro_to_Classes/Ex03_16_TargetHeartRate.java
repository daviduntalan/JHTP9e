package Ch03_Intro_to_Classes;

/**
 * Target-Heart-Rate Calculator.
 * 
 * @author David
 */
public class Ex03_16_TargetHeartRate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Date dateOfBirth = new Date(11, 26, 1980);
        HeartRates hr = new HeartRates();
        hr.setFirstName("David, Jr.");
        hr.setLastName("Untalan");
        hr.setDateOfBirth(dateOfBirth);
        int age = 2020 - dateOfBirth.getYear();
        int maxHeartRate = hr.maximumHeartRate(age);
        double targetHeartRate = hr.targetHeartRate(age);        
        System.out.printf("Max Heart Rate: %d\n", maxHeartRate);
        System.out.printf("Target Heart Rate: %.2f\n", targetHeartRate);
    }
    
}
