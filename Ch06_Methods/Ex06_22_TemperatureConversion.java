package Ch06_Methods;

/**
 * Temperature Conversions. Implement the following integer methods: a) Method
 * celsius returns the Celsius equivalent of a Fahrenheit temperature, using the
 * calculation
 *
 * celsius = 5.0 / 9.0 * ( fahrenheit - 32 );
 *
 * b) Method fahrenheit returns the Fahrenheit equivalent of a Celsius
 * temperature, using the calculation
 *
 * fahrenheit = 9.0 / 5.0 * celsius + 32;
 *
 * c) Use the methods from parts (a) and (b) to write an application that
 * enables the user either to enter a Fahrenheit temperature and display the
 * Celsius equivalent or to enter a Celsius temperature and display the
 * Fahrenheit equivalent.
 *
 * @author David
 */
public class Ex06_22_TemperatureConversion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.println("Temperatur Conversion");
        System.out.println("1. Fahrenheit to Celsius");
        System.out.println("2. Celsius to Fahrenheit");
        System.out.print("Select your option: ");
        int option = input.nextInt();
        double fahrenheit, celsius;
        switch (option) {
            case 1:
                System.out.printf("enter a Fahrenheit temperature: ");
                fahrenheit = input.nextDouble();
                System.out.printf("Celsius equivalent: %f\n", celsius(fahrenheit));
                break;
            case 2:
                System.out.printf("enter a Celsius temperature: ");
                celsius = input.nextDouble();
                System.out.printf("Fahrenheit equivalent: %f\n", fahrenheit(celsius));
                break;
            default:
                System.err.println("Invalid option.");
        }
        
        System.out.println("Thank you.");
    }

    private static double celsius(double fahrenheit) {
        return 5.0 / 9.0 * (fahrenheit - 32);
    }

    private static double fahrenheit(double celsius) {
        return 9.0 / 5.0 * celsius + 32;
    }
}
