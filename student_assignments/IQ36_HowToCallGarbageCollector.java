package student_assignments;
/*
What is the GC?
- automated form of memory management
- reclaims garbage
- garbage: memory occupied by objects that are no longer in use
- JVM takes care of memory management for you
- JVM performs garbage collection when more memory is needed to continue execution of a program

Why call GC if JVM already handles that?
- there's no guarantee that the JVM will reclaim memory
- explicitly calling GC will suggest to the JVM that garbage needs to be reclaimed
- making the suggestion may result in desired memory being reclaimed

How do you call the GC?
- this consist of 2 simple steps
    1. create a java runtime object
    2. invoke the gc() method

    Runtime rt = Runtime.getRuntime();
    rt.gc();

    Note: Runtime object allows you to interface with the environment
    in which your application is running.
*/
public class IQ36_HowToCallGarbageCollector {

    public static void main(String[] args) {

        Runtime rt = Runtime.getRuntime();
        rt.gc();
    }
}
