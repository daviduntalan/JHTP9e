package Ch10_OOP_Polymorphism;

/**
 *
 * @author David
 */
public class Sphere1 extends ThreeDimensionalShape1 {

    @Override
    public int getArea() {
        return 300;
    }

    @Override
    public int getVolume() {
        return getArea() * 3;
    }
    
}
