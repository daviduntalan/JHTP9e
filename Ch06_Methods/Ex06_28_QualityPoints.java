package Ch06_Methods;

/**
 * Write a method qualityPoints. that inputs a student’s average and returns 4 if it’s 90–100,
 * 3 if 80–89, 2 if 70–79, 1 if 60–69 and 0 if lower than 60. Incorporate the method into an application
 * that reads a value from the user and displays the result.
 *
 * @author David
 */
public class Ex06_28_QualityPoints {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        java.util.Random random = new java.util.Random();

        for (int student = 0; student < 60; ++student) {
            final int grades = random.nextInt(100+1);
            final int points = qualityPoints(grades);
            System.out.printf("Quality points of %d is %d\n", grades, points);
        }
    }

    private static int qualityPoints(int grades) {
        switch (grades/10) {
            case 10: 
            case 9: return 4; // 90 - 100
            case 8: return 3; // 80 - 89
            case 7: return 2; // 70 - 79
            case 6: return 1; // 60 - 69           
        }
        return 0; // lower than 60
    }


}
