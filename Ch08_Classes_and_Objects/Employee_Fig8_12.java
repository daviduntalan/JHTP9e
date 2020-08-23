package Ch08_Classes_and_Objects;

/**
 * Fig. 8.12: Static variable used to maintain a count of 
 * the number of Employee objects in memory.
 */
public class Employee_Fig8_12 {

    private String firstName;
    private String lastName;
    private Date birthDate;
    private Date hireDate;
    private static int count = 0; // number of Employees created

    // constructor to initialize name, default date to 1/1/1980, 1/1/2020
    public Employee_Fig8_12(String first, String last) {
        // These two statements do not make copies of the original 
        // String arguments. Actually, String objects in Java are
        // immutable--they cannot be modified after they're created.
        // Therefore, it's safe to have many references to one String object.
        // This is not normally the case for objects of most other 
        // classes in Java. If String objects are immutable, you might
        // wonder why we're able to use operators + and += to concatenate
        // String objects. String-concatenation operations actually result
        // in a NEW String object containing the concatenated values.
        // The original String objects are not modified.
        setFirstName(first); // holds only the reference to original object
        setLastName(last); // holds only the reference to original object
        
        setCount();
    }
    
    // constructor to initialize name, birth date and hire date
    public Employee_Fig8_12(String first, String last, Date dateOfBirth, Date dateOfHire) {
        setFirstName(first); 
        setLastName(last);
        setBirthDate(dateOfBirth);
        setHireDate(dateOfHire);                
        setCount();
    }

    // static method to get static count value
    public static int getCount() {
        return count;
    }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public Date getBirthDate() { return birthDate; }
    public Date getHireDate() { return hireDate; }

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setBirthDate(Date birthDate) { this.birthDate = birthDate; }
    public void setHireDate(Date hireDate) { this.hireDate = hireDate; }

    private void setCount() {
        ++count; // increment static count of employees
        System.out.printf("Employee constructor: %s %s; count = %d\n",
                getFirstName(), getLastName(), getCount());
    }

    @Override // convert Employee to String format
    public String toString() {
        return String.format("%s, %s Hired: %s  Birthday: %s",
                getLastName(), getFirstName(), 
                getHireDate(), getBirthDate());
    }

}
