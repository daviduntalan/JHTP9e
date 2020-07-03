package Ch02_Intro_to_JavaApplication;

/**
 * World Population Growth Calculator.
 *
 * @author David
 */
public class Ex02_34_World_Population {

    public static void main(String[] args) {

        double worldPopulation = 7787229089.0; // currentWorldPopulation
        double growthRate = 1.05; // annualWorldPopulationGrowthRate
        int currentYear = 2020;

        System.out.printf("\nProjected World Population by Years to come at growth rate of %.2f%% per Annum:", growthRate);
        System.out.printf("\n%d is %,.0f Billion", ++currentYear, worldPopulation *= growthRate);
        System.out.printf("\n%d is %,.0f Billion", ++currentYear, worldPopulation *= growthRate);
        System.out.printf("\n%d is %,.0f Billion", ++currentYear, worldPopulation *= growthRate);
        System.out.printf("\n%d is %,.0f Billion", ++currentYear, worldPopulation *= growthRate);
        System.out.printf("\n%d is %,.0f Billion", ++currentYear, worldPopulation *= growthRate);
        System.out.println();

    }

}
