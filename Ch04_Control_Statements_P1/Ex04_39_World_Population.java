package Ch04_Control_Statements_P1;

/**
 * World Population Growth Calculator.
 *
 * @author David
 */
public class Ex04_39_World_Population {

    public static void main(String[] args) {

        double worldPopulation = 7787229089.0; // currentWorldPopulation
        double growthRate = 1.05; // annualWorldPopulationGrowthRate
        double growth = 0.0;
        double increased = 0.0;
        double doublesWorldPop = worldPopulation * 2;
        boolean printOnce = true;
        int currentYear = 2020;

        System.out.printf("\nProjected World Population by years to come "
                + "if growth rate will stay constant at %.2f%% per annum:", growthRate);

        for (int year = 0; year < 75; ++year) {
                       
            System.out.printf("\n%d: %,.1fB %+,.1f",
                    currentYear + year, worldPopulation, increased);
            
            if (worldPopulation > doublesWorldPop) {
                if (printOnce) {
                    System.out.print(" -- this year doubles the population from what it is today.");
                    printOnce = false;
                }
            }

            growth = worldPopulation * growthRate;
            increased = growth - worldPopulation;
            worldPopulation += increased;
            
        }
        System.out.println();

    }

}
