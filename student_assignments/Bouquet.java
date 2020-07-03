package student_assignments;

public class Bouquet {

    public static void main(String[] args) {
        
        int[] myArray = {7, 24, 352, 2, 37};
        System.out.println(Bouquet.toString(myArray));
    }

    private static String toString(int[] myArray) {
        
        for (int index = 0; index < myArray.length; index++) {
            int element = myArray[index];
            System.out.printf("element at index: %d is %d\n", 
                    index, element);
        }
        return ".";
    }

}
