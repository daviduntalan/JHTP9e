package Ch10_OOP_Polymorphism;

import java.util.ArrayList;

/**
 * Carbon Footprint Interface: Polymorphism. Using interfaces, as you
 * learned in this chapter, you can specify similar behaviors for possibly
 * disparate classes. Governments and companies worldwide are becoming
 * increasingly concerned with carbon footprints (annual releases of 
 * carbon dioxide into the atmosphere) from buildings burning various
 * types of fuels for heat, vehicles burning fuels for power, and the 
 * like. Many scientists blame these greenhouse gases for the phenomenon
 * called global warming. Create three small classes unrelated by 
 * inheritance-classes Building, Car and Bicycle. Give each class some
 * unique appropriate attributes and behaviors that it does not have in 
 * common with other class. Write an interface CarboonFootprint with
 * a getCarboonFootprint method. Have each of your classes implement 
 * that interface, so that its getCarboonFootprint method calculates
 * an appropriate carbon footprint for that class (check out a few
 * websites that explain how to calculate carbon footprints). Write
 * an application that creates objects of each of the three classes,
 * places references to those objects in ArrayList<CarboonFootprint>, 
 * then iterates through the ArrayList, polymorphically invoking each
 * object's getCarboonFootprint method. For each object, print some
 * identifying information and the object's carbon footprint.
 * 
 * @author David
 */
public class Ex10_13_CarbonFootprint {

    public static void main(String[] args) {
        
        ArrayList<CarboonFootprint> carbonFootprints = new ArrayList<>();
        carbonFootprints.add(new Building());
        carbonFootprints.add(new Car());
        carbonFootprints.add(new Bicycle());
        
        carbonFootprints.forEach((carbonFootprint) -> {
            System.out.printf("%s:\n%s\n\n", carbonFootprint, // invoke toString
                    carbonFootprint.getCarboonFootprint());
        });
    }
    
}
