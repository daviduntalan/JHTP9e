package student_assignments;

class Outer {

    public Outer whenClicked(int newValue) {
        new Inner().setInnerVar(newValue).print();        
        return this;
    }

    class Inner {

        int innerValue = 11;

        public Inner setInnerVar(int newInnerValue) {
            innerValue = newInnerValue;
            return this;
        }

        public void print() {
            System.out.println("innerValue: " + innerValue);
        }
    }
}

/**
 *
 * @author David
 */
public class OuterInnerClassDemo {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        new Outer().whenClicked(88);                
        new Outer().new Inner().print();
        new Outer().new Inner().setInnerVar(77).print();
        
    }

}
