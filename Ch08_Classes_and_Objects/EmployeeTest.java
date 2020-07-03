package Ch08_Classes_and_Objects;

/**
 * Fig. 8.9: Composition demonstration.
 * @author David
 */
public class EmployeeTest {

    public static void main(String[] args) {
        
        Date birth = new Date(11, 26, 1980);
        Date hire = new Date(11, 28, 2001);
        Employee employee = new Employee("David, Jr.", "Untalan", birth, hire);
        System.out.println(employee);
    }
    
}
