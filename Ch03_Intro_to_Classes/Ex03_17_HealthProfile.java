package Ch03_Intro_to_Classes;

/**
 * Write a Java application that prompts for the person’s information, instantiates an
 * object of class HealthProfile for that person and prints the information from that object—including
 * the person’s first name, last name, gender, date of birth, height and weight—then calculates and
 * prints the person’s age in years, BMI, maximum heart rate and target-heart-rate range. It should also
 * display the BMI values chart from Exercise 2.33.
 * 
 * @author David
 */
public class Ex03_17_HealthProfile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Date dateOfBirth = new Date(11, 26, 1980);
        
        HealthProfile healthProfile = new HealthProfile();
        
        healthProfile.setFirstName("David, Jr.");
        healthProfile.setLastName("Untalan");
        healthProfile.setDateOfBirth(dateOfBirth);
        healthProfile.setGender("Male");
        healthProfile.setHeight(12*5+7); // inches
        healthProfile.setWeight(150); // pounds
                
        System.out.println(healthProfile);
        System.out.println("BMI: " + healthProfile.getBMI());
    }
    
}
