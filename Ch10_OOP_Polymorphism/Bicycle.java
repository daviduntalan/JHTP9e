package Ch10_OOP_Polymorphism;

/**
 *
 * @author David
 */
public class Bicycle implements CarboonFootprint {

    @Override
    public String getCarboonFootprint() {
        return "CarboonFootprint of a Bicycle";
    }

    @Override
    public String toString() {
        return "Bicycle object";
    }            
}
