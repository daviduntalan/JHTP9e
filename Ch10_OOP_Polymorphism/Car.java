package Ch10_OOP_Polymorphism;

/**
 *
 * @author David
 */
public class Car implements CarboonFootprint {

    @Override
    public String getCarboonFootprint() {
        return "CarboonFootprint of a Car";
    }
    
    @Override
    public String toString() {
        return "Car object";
    }        
}
