package Ch08_Classes_and_Objects;

/**
 * Fig. 8.8: Employee class with references to other objects.
 *
 * @author David
 */
public class Employee {

    private String firstName;
    private String lastName;
    private Date birthDate;
    private Date hireDate;

    // constructor to initialize name, birth date and hire date
    public Employee(String first, String last, Date dateOfBirth, Date dateOfHire) {
        firstName = first;
        lastName = last;
        birthDate = dateOfBirth;
        hireDate = dateOfHire;
    }

    @Override // convert Employee to String format
    public String toString() {
        return String.format("%s, %s Hired: %s  Birthday: %s",
                lastName, firstName, hireDate, birthDate);
    }
}
