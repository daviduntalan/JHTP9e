package student_assignments;

class Person {

    /* these are instance variables or
    you may also called them fields */
    String name;
    int age;

    /* this is getter method */
    public String getName() {
        return name;
    }   

    /* this is getter method */
    public int getAge() {
        return age;
    }
    
    /* this is setter method */
    public void setName(String nombre) {
        name = nombre;
    }

    /* this is setter method */
    public void setAge(int edad) {
        if (edad < 0) {
            throw new IllegalArgumentException("age must not be < 0");
        }
        age = edad;
    }        
    
    /*
    there's much more to setter than just setting its value to our 
    instance variable, usually setter are like gate keeper, 
    we guard our instance variable for invalid arguments like negative 
    value for an age of a person. for example:
    we do some validation here before we actually set the passed 
    argument into our parameter edad before we set our instance 
    variable if it's valid otherwise, we throw an IllegalArgument-
    Exception("that an age must not less than zero.");
    
    public void setAge(int edad) {
        if (edad < 0) {
            throw new IllegalArgumentException("age must not be < 0");
        }
        age = edad;
    }        
    */
}

public class GetterSetterDemo {

    public static void main(String[] args) {

        Person object = new Person();
        
        /* using setter methods */
        object.setName("Tom");
        object.setAge(5);
        
        /* using getter methods */
        System.out.printf("Person's name: %s\n", object.getName());
        System.out.printf("Person's age: %d\n", object.getAge());
    }

}

/* Sample OUTPUT

Person's name: Tom
Person's age: 5
BUILD SUCCESSFUL (total time: 0 seconds)

*/