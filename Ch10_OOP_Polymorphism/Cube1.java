package Ch10_OOP_Polymorphism;

/**
 *
 * @author David
 */
public class Cube1 extends ThreeDimensionalShape1 {

    @Override
    public int getArea() {
        return 600;
    }

    @Override
    public int getVolume() {
        return getArea() * 3;
    }
    
}
