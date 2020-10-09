package student_assignments;

/**
 * because that's the required entry point signature defined in JVM to start your Java program ...
 * and it's assumed that when you wrote a program in JAVA you will less likely to commit a mistake.
 * Thus, with that mind in set ... no need to return a value just like any other programming language/s
 * that requires you to do so. Well this is just my opinion but it seems very true. ^_^
 */
public class TestExit {

    public static void main(String[] args) {

        sayHelloTo("World!");
        System.exit(1); // been tested with test.bat
        System.out.println("Done!");
    }

    private static void sayHelloTo(String... name) {

        if (name.length == 0) {
            System.err.println("Please provide argument for name parameter.");
            return;
        }

        System.out.printf("Hello %s\n", name[0]);
    }
}
