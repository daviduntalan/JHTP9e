package Ch03_Intro_to_Classes;

/**
 * Computerization of Health Records. A health care issue that has been in the
 * news lately is the computerization of health records. This possibility is
 * being approached cautiously because of sensitive privacy and security
 * concerns, among others. [We address such concerns in later exercises.]
 * Computerizing health records could make it easier for patients to share their
 * health profiles and histories among their various health care professionals.
 * This could improve the quality of health care, help avoid drug conflicts and
 * erroneous drug prescriptions, reduce costs and, in emergencies, could save
 * lives.
 *
 * @author David
 */
@lombok.NoArgsConstructor
@lombok.Setter
@lombok.Getter
public class HealthProfile extends HeartRates {

    /* found from base class
    private String firstName;
    private String lastName;
    private Date dateOfBirth; */
    private String gender;
    private int height; // in inches
    private int weight; // in pounds

    public HealthProfile(String firstName, String lastName, String gender, Date dateOfBirth, int height, int weight) {
        setFirstName(firstName);
        setLastName(lastName);
        setGender(gender);
        setDateOfBirth(dateOfBirth);
        setHeight(height);
        setWeight(weight);
    }

    public int getAge() {
        return 2020 - getDateOfBirth().getYear();
    }

    public int getMaximumHeartRate() {
        return super.maximumHeartRate(getAge());
    }

    public double getTargetHeartRate() {
        return super.targetHeartRate(getAge());
    }
    
    public double getBMI() {
        double BMI = (getWeight() * 703)  / (getHeight() * getHeight());
        
        String result = "what are you?"; 
        if (BMI < 18.5) result = "Underweight";
        if (BMI >= 18.5 && BMI < 25) result = "Normal";
        if (BMI >= 25 && BMI < 30) result = "Overweight";
        if (BMI >= 30) result = "Obese";
        System.out.printf("\nYour final verdict is %s\n", result);
        
        return BMI;
    }
            

    @Override
    public String toString() {
        String result = String.format(""
                + "F Name: %s\n"
                + "L Name: %s\n"
                + "Age: %s\n"
                + "DOB: %d/%d/%d\n"
                + "Gender: %s\n"
                + "Height: %d\n"
                + "Weight: %d\n"
                + "Max Heart Rate: %d\n"
                + "Target Heart Rate: %.0f",
                getFirstName(), getLastName(), getAge(), 
                getDateOfBirth().getMonth(),
                getDateOfBirth().getDay(),
                getDateOfBirth().getYear(),
                getGender(), getHeight(),  getWeight(),
                getMaximumHeartRate(),
                getTargetHeartRate()                
        );
        return result;
    }

}
