package Ch03_Intro_to_Classes;

/**
 *
 * @author David
 */
public class Ex03_14_RaiseEmployees {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Employee emp1 = new Employee("David, Jr.", "Untalan", 75000.00);
        Employee emp2 = new Employee("Salamona", "Utara", 50000.00);
        System.out.println(emp1);
        System.out.println(emp2);
        emp1.setRaise();
        emp2.setRaise();
        System.out.println("\nAfter 10% raise");
        System.out.println(emp1);
        System.out.println(emp2);
    }
    
}
