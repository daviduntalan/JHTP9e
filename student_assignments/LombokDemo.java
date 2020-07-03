package student_assignments;

import java.util.ArrayList;

@lombok.Data
class PhoneBook {

    private String name;
    private String contact;

    public PhoneBook(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }
    
    public PhoneBook getMethod1() {
        System.out.println("method chain 1...");
        return this;
    }
    
    public PhoneBook getMethod2() {
        System.out.println("method chain 2...");
        return this;
    }

}

/**
 * To Enable Lombok.
 * 1. https://projectlombok.org/setup/netbeans 
 * 2. https://netbeans.org/kb/73/java/annotations-lombok.html
 *
 * @author David
 */
public class LombokDemo {

    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<PhoneBook> phoneBook = new ArrayList<>();
        PhoneBook pb = new PhoneBook("David, Jr.", "09274141835");
        pb.setName("Lady Lou Recla");
        System.out.printf("Name: %s\nContact: %s\n", 
                pb.getName(), pb.getContact());
        pb.getMethod1().getMethod2().getMethod2().getMethod1();
    }

}
