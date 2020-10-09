package student_assignments;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TestNextLine {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.printf("input: ");
        String inputNumbers = scanner.nextLine();

        String[] numbers = inputNumbers.split(" ");
        int count, length = numbers.length;
        System.out.printf("output: %d\n", length);

        HashMap<Integer, Integer> hashMapValues = new HashMap<>();
        Set<Integer> setOfValues = new HashSet<>();
        int[] values = new int[length];
        for(int i = 0; i < length; ++i) {
            int keyValue = values[i] = Integer.parseInt(numbers[i]);
            setOfValues.add(keyValue);
            if (hashMapValues.get(keyValue) == null) {
                hashMapValues.put(keyValue, count = 1);
            } else {
                count = hashMapValues.get(keyValue) + 1;
                hashMapValues.put(keyValue, count);
            }
        }

        System.out.println("\nFrequency of each Value:");
        hashMapValues.entrySet().forEach(kv -> {
            System.out.printf("value: %d - %dX\n", kv.getKey(), kv.getValue());
        });

        System.out.println("\nSet of Integer Values: No Duplicate");
        setOfValues.forEach(value -> {
            System.out.printf("value: %d\n", value);
        });

        // 1 2 3 4 5 6 7 8 9 10 1 2 3 4 5 5 10 10 10
    }
}
