package student_assignments;

public class SpecialEleven {

    public static void main(String[] args) {

        for (int n = 10; n < 120; ++n) {
            if (isSpecialEleven(n) == true) {                
                System.out.printf("%d is SPECIAL\n", n);                                                
                if ((n - 1) % 11 == 0) System.out.println();
            } else {
                // System.out.printf("%d is NOT special", n);
            }
            // System.out.println();
        }
    }

    private static boolean isSpecialEleven(int n) {
        return (n % 11 == 0 || (n - 1) % 11 == 0);
    }

}
