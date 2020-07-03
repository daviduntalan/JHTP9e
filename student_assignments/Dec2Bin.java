package student_assignments;

public class Dec2Bin {

    public static void main(String[] args) {

        // could handle upto 19 bin digits only
        long binaryd = 101_10101111_10101111L; 
        long decimal = 0;
        
        for (int pos = 0; binaryd > 0; ++pos) {
            decimal |= binaryd % 10 << pos;
            binaryd /= 10;
        }
        
        System.out.println(decimal); // ouput: 372655
    }
}