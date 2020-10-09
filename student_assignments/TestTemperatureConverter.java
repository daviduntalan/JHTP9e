package student_assignments;

/* Test class TemperatureConverter */
public class TestTemperatureConverter {

    public static void main(String[] args) throws InterruptedException {

        if (TemperatureConverter.isFromFToC("32 f"))
            System.out.println(TemperatureConverter.convertFromFToC("32 F"));

        if (TemperatureConverter.isFromCToF("100 C"))
            System.out.println(TemperatureConverter.convertFromCToF("100 c"));

    }
}
