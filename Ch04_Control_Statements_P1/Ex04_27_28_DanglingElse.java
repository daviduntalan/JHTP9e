package Ch04_Control_Statements_P1;

/**
 * Dangling-else Problem. Determine the output for each of the given sets of
 * code when x is 9 and y is 11 and when x is 11 and y is 9. The compiler
 * ignores the indentation in java program. also, the java compiler always
 * associates an else with the immediately preceding if unless told to do
 * otherwise by the placement of braces {}. On first glance, you may not be sure
 * which if a particular else matches--this situation is referred to as the
 * "dangling-else problem." We've eliminated the indentation from the following
 * code to make the problem more challenging. [hint: apply the indentation
 * conventions you've learned.]
 *
 * @author David
 */
public class Ex04_27_28_DanglingElse {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("///// Dangling-else Problem //////");
        int x = 9;
        int y = 11;

        System.out.println("Exercise a)");
        if (x < 10) {
            if (y > 10) {
                System.out.println("*****");
            } else {
                System.out.println("#####");
            }
        }
        System.out.println("$$$$$");

        x = 11;
        y = 9;
        System.out.println("Exercise b)");
        if (x < 10) {
            if (y > 10) {
                System.out.println("*****");
            }
        } else {
            System.out.println("#####");
            System.out.println("$$$$$");
        }
        
        System.out.println("///// Another Dangling-else Problem //////");
        System.out.println("Exercise a)");
        x = 5; y = 8; 
        if (y == 8) {
            if (x == 5) {
                System.out.println("@@@@@");
            } else {
                System.out.println("#####");
            }
            System.out.println("$$$$$");
            System.out.println("&&&&&");
        }
        
        System.out.println("Exercise b)");
        x = 5; y = 8; 
        if (y == 8) {
            if (x == 5) {
                System.out.println("@@@@@");
            }                             
        } else {
            System.out.println("#####");
            System.out.println("$$$$$");
            System.out.println("&&&&&");
        } // else part of outer if
        
        System.out.println("Exercise c)");
        x = 5; y = 8; 
        if (y == 8) {
            if (x == 5) {
                System.out.println("@@@@@");
            } else {
                System.out.println("#####");
                System.out.println("$$$$$");
                System.out.println("&&&&&");
            } // else part of inner if
        }
        
        System.out.println("Exercise d)");
        x = 5; y = 7; 
        if (y == 8) {
            if (x == 5) {
                System.out.println("@@@@@");
            } 
        } else {
            System.out.println("#####");
            System.out.println("$$$$$");
            System.out.println("&&&&&");
        }// else art of outer if
    }

}
