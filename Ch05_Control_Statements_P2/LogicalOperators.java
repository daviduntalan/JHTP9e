package Ch05_Control_Statements_P2;

/**
 * Logical operators.
 * Fig. 5.18
 * @author David
 */
public class LogicalOperators {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create truth table for && (conditional AND) opeartor
        System.out.printf("%s\n%s: %b\n%s: %b\n%s: %b\n%s: %b\n\n",
                "Conditional AND (&&)", 
                "false && false", (false && false),
                "false && true", (false && true),
                "true && false", (true && false),
                "true && true", (true && true) );
        // create truth table for || (conditional OR) opeartor
        System.out.printf("%s\n%s: %b\n%s: %b\n%s: %b\n%s: %b\n\n",
                "Conditional OR (||)", 
                "false || false", (false || false),
                "false || true", (false || true),
                "true || false", (true || false),
                "true || true", (true || true) );
        // create truth table for & (boolean logical AND) opeartor
        System.out.printf("%s\n%s: %b\n%s: %b\n%s: %b\n%s: %b\n\n",
                "Boolean logical AND (&)", 
                "false & false", (false & false),
                "false & true", (false & true),
                "true & false", (true & false),
                "true & true", (true & true) );
        // create truth table for | (boolean logical OR) opeartor
        System.out.printf("%s\n%s: %b\n%s: %b\n%s: %b\n%s: %b\n\n",
                "Boolean logical OR (|)", 
                "false | false", (false | false),
                "false | true", (false | true),
                "true | false", (true | false),
                "true | true", (true | true) );
        // create truth table for ^ (boolean logical exclusive OR) opeartor
        System.out.printf("%s\n%s: %b\n%s: %b\n%s: %b\n%s: %b\n\n",
                "Boolean logical exclusive OR (^)", 
                "false ^ false", (false ^ false),
                "false ^ true", (false ^ true),
                "true ^ false", (true ^ false),
                "true ^ true", (true ^ true) );
        // create truth table for ! (logical negation) operator
        System.out.printf("%s\n%s: %b\n%s: %b\n", 
                "Logical NOT (!)", 
                "!false", (!false),
                "!true", (!true));
    }
    
}
