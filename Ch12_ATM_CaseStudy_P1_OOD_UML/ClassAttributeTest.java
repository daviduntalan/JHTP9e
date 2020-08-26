package Ch12_ATM_CaseStudy_P1_OOD_UML;

/**
 * Identifying Class Attributes.
 * Classes have attributes (data) and operations (behaviors).
 * Attributes represent an object's state.
 */
class ClassAttribute {

    /* class attributes are implemented as fields */
    private double height;
    private double weight;

    /* class operations are implemented as methods */
    public double getHeight() { return height; }
    public double getWeight() { return weight; }
    public void setHeight(double height) {
        this.height = height > 0 ? height : 0;
    }
    public void setWeight(double weight) {
        this.weight = weight > 0 ? weight : 0;
    }

    @Override
    public String toString() {
        return String.format("ClassAttribute{ht: %.1fin, wt: %.1fK}\n",
                getHeight(), getWeight());
    }
}

public class ClassAttributeTest {

    public static void main(String[] args) {

        ClassAttribute attributeObj = new ClassAttribute();
        attributeObj.setHeight(12*5+7);
        attributeObj.setWeight(112);
        System.out.println(attributeObj);
    }
}