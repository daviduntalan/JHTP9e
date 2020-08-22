package student_assignments;

import java.io.Serializable;

/**
 * The notion of "tagging interfaces" --empty interfaces that have NO
 * methods or constant values. They're used to add is-a relationships
 * to classes. For example, in Chapter 17 we'll discuss a mechanism
 * called object serialization, which can convert objects to byte
 * representations and can convert those byte representations back to
 * objects. To enable this mechanism to work with your objects,
 * you simply have to mark them as Serializable by adding implements
 * Serializable to the end of your class declaration's first line.
 * Then, all the objects of your class have the is-a relationship with
 * Serializable. @author David
 */
public class TaggingInterface implements Serializable {
    // turns object to byte and byte to object:
    // 1. object -> byte
    // 2. byte -> object
}
