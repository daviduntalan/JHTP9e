package student_assignments;

public class TurnLetterAToZero {

    public static void main(String[] args) {
        
        System.out.printf("letter 'A' is %d\n", getDecimalValueOf('A'));
        System.out.printf("letter 'z' is %d\n", getDecimalValueOf('z'));
        
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "abcdefghijklmnopqrstuvwxyz";
        
        System.out.println("Decimal value of each letter in "
                + "Alphabet are the following:");        
        for (int i = 0; i < alphabet.length(); i++) {
            Character letter = alphabet.charAt(i);
            Integer decimalValue = getDecimalValueOf(letter);
            System.out.printf("%c = %d\n", letter, decimalValue);
        }
    }

    private static Integer getDecimalValueOf(Character letter) {
        // if letter is in UPPERCASE
        if (letter > 64 && letter < 65+26) {
            return letter - 65;
        } 
        // if letter is in lowercase
        else if (letter > 96 && letter < 97+26) {
            return letter - 97;
        }
        // if none of the above selection
        throw new IllegalArgumentException();
    }
    
}