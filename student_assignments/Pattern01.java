package student_assignments;

public class Pattern01 {

    public static void main(String[] args) {

        int memory_size = 10;
        int partition1 = 3;
        int partition2 = 4;
        int partition3 = 3;

        int job1 = 2;
        int job2 = 3;

        for (int i = 0; i < partition1; ++i) {
            if (partition1 % 2 != 0) System.out.println("&&&&&");
            else System.out.println("#####");
        }
        System.out.println("-----");
        for (int i = 0; i < partition2; ++i) {
            if (partition2 % 2 != 0) System.out.println("&&&&&");
            else System.out.println("#####");
        }
    }
}
