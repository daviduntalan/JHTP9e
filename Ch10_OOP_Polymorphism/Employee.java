package Ch10_OOP_Polymorphism;

import Ch08_Classes_and_Objects.Date;

/**
 * Fig. 10.4: Employee abstract superclass.
 * @author David
 */
@lombok.Getter
@lombok.Setter
public abstract class Employee {
    private String firstName;
    private String lastName;
    private String socialSecurityNumber;
    private Date birthDate;

    public Employee(String firstName, String lastName, String socialSecurityNumber) {
        setFirstName(firstName);
        setLastName(lastName);
        setSocialSecurityNumber(socialSecurityNumber);        
    }    

    /* constructor for exercise 10.8 Payroll System Modification */
    public Employee(String firstName, String lastName, String socialSecurityNumber, Date birthDate) {
        setFirstName(firstName);
        setLastName(lastName);
        setSocialSecurityNumber(socialSecurityNumber);        
        setBirthDate(birthDate);
    }

    @Override
    public String toString() {
        return String.format("%s %s\nsocial security number: %s",
                getFirstName(), getLastName(), getSocialSecurityNumber());
    }        
    
    // abstract method overriden by concrete subclasses
    public abstract double earnings();
}
