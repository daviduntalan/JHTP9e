package Ch04_Control_Statements_P1;

/**
 * Optional reading project: Research “public key cryptography” in 
 * general and the PGP (Pretty Good Privacy) specific public key scheme. 
 * You may also want to investigate the RSA scheme, which is widely used 
 * in industrial-strength applications.
 * @author David
 */
public class Ex04_38_Cryptography {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int digits = 4321;        
        int digit1 = 0;
        int digit2 = 0;
        int digit3 = 0;
        int digit4 = 0;
        int key = 7;

        // encrypting...
        
        digit1 = digits % 10 + key; digits /= 10;
        digit2 = digits % 10 + key; digits /= 10;
        digit3 = digits % 10 + key; digits /= 10;
        digit4 = digits % 10 + key; digits /= 10;
        
        // swap the first digit with the third
        digits = digit1;
        digit1 = digit3;
        digit3 = digits;
        
        // swap the second digit with the fourth
        digits = digit2;
        digit2 = digit4;
        digit4 = digits;
        
        System.out.printf("encrypted: %d.%d.%d.%d\n", digit1, digit2, digit3, digit4);
        
        // decrypting...
        
        // swap the second digit with the fourth
        digits = digit2;
        digit2 = digit4;
        digit4 = digits;
        
        // swap the first digit with the third
        digits = digit1;
        digit1 = digit3;
        digit3 = digits;
        
        digit1 -= key;
        digit2 -= key;
        digit3 -= key;
        digit4 -= key;
        
        digits = 0;
        digits += digit1 * 1;
        digits += digit2 * 10;
        digits += digit3 * 100;
        digits += digit4 * 1000;
        
        System.out.printf("decrypted: %d.%d.%d.%d\n", digit4, digit3, digit2, digit1);
        System.out.printf("decrypted: %d\n", digits);
    }

}
