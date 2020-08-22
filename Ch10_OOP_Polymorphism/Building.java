package Ch10_OOP_Polymorphism;

/**
 *
 * @author David
 */
public class Building implements CarboonFootprint {

    @Override
    public String getCarboonFootprint() {
        return "CarboonFootprint of a Building";
    }

    @Override
    public String toString() {
        return "Building object";
    }        
}
