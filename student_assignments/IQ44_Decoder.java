package student_assignments;

public class IQ44_Decoder {

    public static void main(String[] args) {

        /**
         * decoding a character set into a message
         */
        final String charLine1 = "1'JKJ'pz'{ol'{yhklthyr'vm'{ol'Jvu{yvs'Kh{h'Jvywvyh{pvu5";
        final String charLine2 = "1'PIT'pz'h'{yhklthyr'vm'{ol'Pu{lyuh{pvuhs'I|zpulzz'Thjopul'Jvywvyh{pvu5";
        final String charLine3 = "1'KLJ'pz'{ol'{yhklthyr'vm'{ol'Kpnp{hs'Lx|pwtlu{'Jvywvyh{pvu5";

        String decoded1;
        String decoded2;
        String decoded3;

        System.out.println("\nDecode the message:");
        System.out.println(decoded1 = decodeCharSet(charLine1));
        System.out.println(decoded2 = decodeCharSet(charLine2));
        System.out.println(decoded3 = decodeCharSet(charLine3));

        System.out.println("\nEncode the message back:");
        System.out.println(encodeCharSet(decoded1));
        System.out.println(encodeCharSet(decoded2));
        System.out.println(encodeCharSet(decoded3));
    }

    public static String decodeCharSet(String charLine) {

        // byte array that stores converted char decimal values (bytes)
        byte[] charBytes = charLine.getBytes();

        // create an array that will contain bytes length
        byte[] decoded = new byte[ charBytes.length ];

        for (int i = 0; i < charBytes.length; ++i) {
            decoded[i] = decodeChar(charBytes[i]);
        }

        return new String(decoded);
    }

    private static byte decodeChar(byte charByte) {

        return (byte) (charByte - 7); // decoded numeric value passed in
    }

    public static String encodeCharSet(String charLine) {

        // byte array that stores converted char decimal values (bytes)
        byte[] charBytes = charLine.getBytes();

        // create an array that will contain bytes length
        byte[] decoded = new byte[ charBytes.length ];

        for (int i = 0; i < charBytes.length; ++i) {
            decoded[i] = encodeChar(charBytes[i]);
        }

        return new String(decoded);
    }

    private static byte encodeChar(byte charByte) {

        return (byte) (charByte + 7); // encoded numeric value passed in
    }
}
