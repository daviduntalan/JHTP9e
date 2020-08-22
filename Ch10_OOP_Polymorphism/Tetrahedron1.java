package Ch10_OOP_Polymorphism;

/**
 *
 * @author David
 */
public class Tetrahedron1 extends ThreeDimensionalShape1 {

    @Override
    public int getArea() {
        return 900;
    }

    @Override
    public int getVolume() {
        return getArea() * 3;
    }
    
}
