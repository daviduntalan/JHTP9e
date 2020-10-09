package student_assignments;

public class TestAnimal {

    public static void main(String[] args) {

        Pig pig = new Pig();
        pig.name = "pig name";
        pig.owner = "pig owner";

        Cat cat = new Cat();
        cat.name = "cat name";
        cat.owner = "cat owner";

        Animal animalCat = new Cat();

        ((Cat)animalCat).meow();

    }
}
