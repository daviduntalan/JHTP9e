package Ch08_Classes_and_Objects;
import static Ch08_Classes_and_Objects.Employee_Fig8_12.*;
/**
 *
 * @author David
 */
public class EmployeeTest_Fig8_12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // show that count is 0 before creating Employees
        System.out.printf("Employee before instantiation: %d\n",
                Employee_Fig8_12.getCount());
        
        // create two Employees; count should be 2
        Employee_Fig8_12 e1 = new Employee_Fig8_12("Susan", "Baker");
        Employee_Fig8_12 e2 = new Employee_Fig8_12("Bob", "Blue");
        
        // show that cunt is 2 after creating two Employees
        System.out.println("\nEmployees after instantiation: ");
        System.out.printf("via e1.getCount(): %d\n", e1.getCount()); // not recommended,
        System.out.printf("via e2.getCount(): %d\n", e2.getCount()); // it should be 
        System.out.printf("via Employee.getCount(): %d\n", Employee_Fig8_12.getCount()); // class reference 
        
        // get names of Employees
        System.out.printf("\nEmployee 1: %s %s\nEmployee 2: %s %s\n",
                e1.getFirstName(), e1.getLastName(),
                e2.getFirstName(), e2.getLastName()
        );
        
        // in this exmaple, there is only one reference to each Employee,
        // so the following two statements indicate that these objects
        // are eligible for garbage collection
        e1 = null; // mark to be collected
        e2 = null; // eligible for garbage collection        
        // Eventually, the garbage collector might reclaim the memory for these objects (or the
        // operating system will reclaim the memory when the program terminates). The JVM does
        // not guarantee when, or even whether, the garbage collector will execute. When it does, it’s
        // possible that no objects or only a subset of the eligible objects will be collected.
    }
    
}
