package Ch10_OOP_Polymorphism;

import Ch08_Classes_and_Objects.Date;

/**
 * Fig. 10.4: Employee abstract superclass.
 * @author David
 */
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

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() { return lastName; }
    public String getSocialSecurityNumber() { return socialSecurityNumber; }
    public Date getBirthDate() { return birthDate; }

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setSocialSecurityNumber(String socialSecurityNumber) { this.socialSecurityNumber = socialSecurityNumber; }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return String.format("%s %s\nsocial security number: %s",
                getFirstName(), getLastName(), getSocialSecurityNumber());
    }

    // abstract method overridden by concrete subclasses
    public abstract double earnings();
}
