package com.deitel.jhtp.ch08;
/* The package declaration in Fig. 8.15 indicates that class Time1 
should be placed in the directory com/deitel/jhtp/ch08/
The names in the package declaration specify the exact location of
the package's classes. When compiling a class in a package, the javac
command-line option -d causes the javac compiler to create 
appropriate directories based on the class's package declaration.
The option also specifies where the directories should be stored. 
For example, in a command window, we used the compilation command

javac -d . Time1.java

to specify that the first directory in our package name should be 
placed in the current directory. The period (.) after -d in the 
preceding command represents the current directory on the Windows, 
UNIX, Linux and Mac OS X operating systems (and several others as 
well). After execution of the compilation command, the current 
directory contains a directory called com, com contains called 
deitel, deitel contains a directory called jhtp and jhtp contains
a directory called ch08. In the ch08 directory, you can find the 
file Time1.class. [Note: IF YOU DO NOT USE the -d option, then 
YOU MUST COPY or move the class file to the appropriate package 
directory after compiling it.] 

The package name is part of the fully qualified class name, so the
name of class Time1 is actually com.deitel.jhtp.ch08.Time1. You can
use this fully qualified name in your programs, or you can import
the class and use its simple name (the class name by itself--Time1)
in the program. If another package also contains a Time1 class, the 
fully qualified class names can be used to distinguish between the 
classes in the program and prevent a name conflict (also called a 
name collision). */

/**
 * A Java source-code file must have the following order:
 * 1. a package declaration (if any),
 * 2. import declarations (if any) then
 * 3. class declarations.
 * 
 * Only one of the class declarations in a particular file can be public.
 * Other classes in the file are placed in the package and can be used 
 * only by the other classes in the package. Non-public classes are
 * in a package to support the reusable classes in the package.
 * 
 * Fig. 8.15: Time1 class declaration maintains the time in 24-hour format.
 * @author David
 */
public class Time1 {
    
    private int hour; // 0 - 23
    private int minute; // 0 - 59
    private int second; // 0 - 59
    
    // in this example, class Time1 doesn't declare a constructor,
    // so the class has a default constructor that's supplied by the
    // compiler. each instance variable implicitly receives a default 
    // value of 0 for an int. instance varibles also can be initialized
    // when they're declared in the class body, using the same 
    // initialization syntax as with a local variable.
    
    // set a new time value using universal time; throw an
    // exception if the hour, minute or second is invalid
    public void setTime(int h, int m, int s) {
        // validate hour, minute and second
        if ((h >= 0 && h < 24) && 
            (m >= 0 && m < 60) && 
            (s >= 0 && s < 60)) {
            hour = h;
            minute = m;
            second = s;
        } else {
            throw new IllegalArgumentException(
                    "hour, minute and/or second was out of range");
        }
    }
    
    // convert to String in universal-time format (HH:MM:SS)
    public String toUniversalString() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
    
    // convert to String in standard-time format (H:MM:SS AM or PM)
    @Override
    public String toString() {
        return String.format("%d:%02d:%02d %s",
            ((hour == 0 || hour == 12) ? 12 : hour % 12),
            minute, second, ((hour < 12) ? "AM" : "PM"));
    }
}