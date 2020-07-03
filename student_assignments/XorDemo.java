package student_assignments;

/**
 *
 * @author David
 */
public class XorDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String orimsg = "This is a test";
        String encmsg = "";
        String decmsg = "";
        int key = 88;

        System.out.print("Original message: ");
        System.out.println(orimsg);
        
        System.out.printf("encoding...");
        for (int i = 0; i < orimsg.length(); i++) {
            encmsg = encmsg + (char) (orimsg.charAt(i) ^ key);
            System.out.printf("%3d ", (int)orimsg.charAt(i));
        }
        System.out.println();
        
        System.out.printf("decoding...");
        for (int i = 0; i < encmsg.length(); i++) {
            decmsg = decmsg + (char) (encmsg.charAt(i) ^ key);
            System.out.printf("%3d ", (int)encmsg.charAt(i));
        }
        System.out.println();
        
        System.out.print("Encode message:");
        System.out.println(encmsg);
        System.out.print("Decode message:");
        System.out.println(decmsg);
    }

}
