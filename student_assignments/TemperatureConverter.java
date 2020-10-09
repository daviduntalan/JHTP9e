package student_assignments;

public class TemperatureConverter {

    public static boolean isValidTem(String temp){
        return temp.matches("\\d+\\s+[cCfF]");
    }

    public static boolean isFromFToC(String temp){
        if(isValidTem(temp))
            return !isFromCToF(temp);
        return false;
    }

    public static boolean isFromCToF(String temp) {
        if(isValidTem(temp))
            return temp.replaceAll("[^cC]","").matches("(c|C)");
        return false;
    }

    private static double getDigitsFromTemp(String temp){
        return Double.parseDouble(temp.replaceAll("[^\\d+]",""));
    }

    public static double convertFromCToF(String temp){
        if(isFromCToF(temp))
            return 9 * (getDigitsFromTemp(temp)/5) + 32;
        System.out.println("ERROR NOT C TO F");
        return 0;
    }

    public static double convertFromFToC(String temp){
        if(isFromFToC(temp))
            return 5 * (getDigitsFromTemp(temp) - 32)/9;
        System.out.println("ERROR NOT F TO C");
        return 0;
    }
}