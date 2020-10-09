package student_assignments;

public class FactorialDemo {

    static int factorial(int n) {

        System.out.print("value of n: " + n);
        if (n != 1) {
            System.out.println(" <> 1");
            int retfact = factorial(n - 1);
            int fresult = n * retfact;
            System.out.printf("value of n: %d x (%d! = %d) => %d\n",
                    n, n - 1, retfact, fresult);
            return fresult;
        }
        System.out.println(" => 1");
        return 1; // proceed back to [int retfact = factorial(n - 1);]
    }

    public static void main(String[] args) {

        System.out.println("final result: " + factorial(5));
    }
}
