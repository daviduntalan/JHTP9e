package student_assignments;

/**
 *
 * YT: https://www.youtube.com/watch?v=sAiwLeUjKnU&t=325s
 *
 * @author David
 */
public class IQ20_Count2s_In_Array {

    public static void main(String[] args) {

        int ints[] = {2, 1, 4, 5, 332, 22, 96, 322, 222, 52, 2};
        int count2s = 0;
        char[] chars;
        for (int number : ints) {
            chars = String.valueOf(number).toCharArray();
            for (char ch : chars) {
                if (ch == '2') {
                    ++count2s;
                }
            }
        }
        
        System.out.printf("count of 2s: %d\n", count2s);
    }

}
