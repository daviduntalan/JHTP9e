package Ch04_Control_Statements_P1;

/**
 * Gas Mileage. Drivers are concerned with the mileage their automobiles get.
 * One driver has kept tract of several trips by recording the miles driven and
 * gallons used for each tankful. Develop a Java app that will input
 * the miles driven and gallons used (both as int) for each trip.
 * the program should calculate and display the miles per gallon obtained
 * for each trip and print the combined miles per gallon obtained for all trips
 * up to this point.
 * @author David
 */
public class Ex04_17_GasMileage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        java.util.Scanner input = new java.util.Scanner(System.in);
        int milesDriven = 0;
        int gallonsUsed = 0;
        double total = 0;
        int count = 0;
        
        System.out.printf("Input miles driven (0 to stop): ");
        milesDriven = input.nextInt();
        
        System.out.printf("Input gallons used (0 to stop): ");
        gallonsUsed = input.nextInt();                
                
        while (milesDriven != 0 && gallonsUsed != 0) {
            
            total += (double) milesDriven / gallonsUsed;
            ++count;
        
            System.out.printf("Input miles driven (0 to stop): ");
            milesDriven = input.nextInt();

            System.out.printf("Input gallons used (0 to stop): ");
            gallonsUsed = input.nextInt();

        }
        
        double average = (double) total / count;
        System.out.printf("Average miles per gallons: %.2f\n", average);
    }

}
