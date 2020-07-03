package Ch02_Intro_to_JavaApplication;

/**
 * BMI Calculator. Body Mass Index.
 * @author David
 */
public class Ex02_33_BMI {

    public static void main(String[] args) {
        
        double weightInPounds = 150;        
        double heightInInches = 12 * 5 + 7; // 67 inches
        double BMI = (weightInPounds * 703) / (heightInInches * heightInInches);
        
        System.out.println("BMI VALUES");
        System.out.println("Underweight: less than 18.5");
        System.out.println("Normal:      between 18.5 and 24.9");
        System.out.println("Overweight:  between 25 and 29.9");
        System.out.println("Obese:       30 or greater");
        
        
        
        System.out.printf("\nYour weight in pounds: %f", weightInPounds);
        System.out.printf("\nYour height in inches: %f", heightInInches);
        System.out.printf("\nYour BMI score from pound is: %f\n", BMI);
        
        double weightInKilograms = 68.0388555;
        double heightInMeters = 1.7018;
        BMI = weightInKilograms / (heightInMeters * heightInMeters);
        
        System.out.printf("\nYour weight in kilograms: %f", weightInKilograms);
        System.out.printf("\nYour height in meters: %f", heightInMeters);
        System.out.printf("\nYour BMI score from kilogram is: %f\n", BMI);
        
        String result = "what are you?"; 
        if (BMI < 18.5) result = "Underweight";
        if (BMI >= 18.5 && BMI < 25) result = "Normal";
        if (BMI >= 25 && BMI < 30) result = "Overweight";
        if (BMI >= 30) result = "Obese";
        System.out.printf("\nYour final verdict is %s\n", result);
    }
    
}
