package Ch07_Arrays_and_ArrayLists;

import java.util.Arrays;

/**
 * Turtle Graphics. The Logo language made the concept of turtle graphics famous. Imagine
 * a mechanical turtle that walks around the room under the control of a Java application. The turtle
 * holds a pen in one of two positions, up or down. While the pen is down, the turtle traces out shapes
 * as it moves, and while the pen is up, the turtle moves about freely without writing anything. In this
 * problem, you’ll simulate the operation of the turtle and create a computerized sketchpad.
 *
 * Use a 20-by-20 array floor that’s initialized to zeros. Read commands from an array that contains
 * them. Keep track of the current position of the turtle at all times and whether the pen is currently
 * up or down. Assume that the turtle always starts at position (0, 0) of the floor with its pen
 * up. The set of turtle commands your application must process are shown in Fig. 7.29.
 *
 * Command  Meaning
 * 1        Pen up
 * 2        Pen down
 * 3        Turn right
 * 4        Turn left
 * 5, 10    Move forward 10 spaces (replace 10 for a different number of spaces)
 * 6        Display the 20-by-20 array
 * 7        Turn up
 * 8        Turn down
 * 9        End of data (sentinel)
 *
 * Suppose that the turtle is somewhere near the center of the floor. The following “program”
 * would draw and display a 12-by-12 square, leaving the pen in the up position:
 *
 * PEN_UP,
 * DOWN,
 * MOVE, 5,
 * RIGHT,
 * MOVE, 4,
 * PEN_DOWN,
 * RIGHT,
 * MOVE, 12,
 * DOWN,
 * MOVE, 12,
 * LEFT,
 * MOVE, 12,
 * UP,
 * MOVE, 12,
 * PEN_UP,
 * DISPLAY,
 * END
 *
 * As the turtle moves with the pen down, set the appropriate elements of array floor to 1s.When the
 * 6 command (display the array) is given, wherever there’s a 1 in the array, display an asterisk or any
 * character you choose. Wherever there’s a 0, display a blank.
 * Write an application to implement the turtle graphics capabilities discussed here.Write several
 * turtle graphics programs to draw interesting shapes. Add other commands to increase the power of
 * your turtle graphics language.
 */

public class Ex07_21_TurtleGraphics {

    static class Turtle {
        public static int footprint;
        public static int turns;
    }

    static int[][] floor = new int[20][20];

    final static int SPACE = 0;
    final static int STAR = 1;
    final static int PEN_UP = SPACE;
    final static int PEN_DOWN = STAR;
    final static int RIGHT = 3;
    final static int LEFT = 4;
    final static int MOVE = 5; /* ex: 5,10 - move forward 10 spaces */
    final static int DISPLAY = 6; /* display the 20x20 array */
    final static int UP = 7;
    final static int DOWN = 8;
    final static int END = 9; /* end of data (sentinel) */

    public static void main(String[] args) {

        for (int y = 0; y < floor.length; ++y) {
            Arrays.fill(floor[y], SPACE); /* initialize to zeros */
        }

        System.out.println("Starting at coordinate position (row: 0 col: 0):");
        int[] commands = new int[] {
                PEN_UP,
                DOWN, MOVE, 5,
                RIGHT, MOVE, 4,
                PEN_DOWN,   // pen down
                RIGHT,      // direction: turn right
                MOVE, 12,   // move 12 spaces
                DOWN,       // direction: turn down
                MOVE, 12,   // move 12 spaces
                LEFT,       // direction: turn left
                MOVE, 12,   // move 12 spaces
                UP,         // direction: turn up
                MOVE, 12,   // move 12 spaces
                PEN_UP,     // pen up
                DISPLAY,    // display floor
                END         // end command reading
        };

        int row = 0;
        int col = 0;

        /* Read commands from an array that contains them. */
        for (int index = 0; index < commands.length; ++index) {

            switch ( commands[index] ) {

                case PEN_UP: Turtle.footprint = SPACE; break;
                case PEN_DOWN: Turtle.footprint = STAR;  break;

                case UP   : Turtle.turns = UP; break;
                case DOWN : Turtle.turns = DOWN; break;
                case LEFT : Turtle.turns = LEFT; break;
                case RIGHT: Turtle.turns = RIGHT; break;

                case MOVE:
                    int numberOfMoves = commands[ ++index ];
                    for (int moves = 0; moves < numberOfMoves; ++moves) {

                        switch (Turtle.turns) {
                            case UP   : --row; break;
                            case DOWN : ++row; break;
                            case LEFT : --col; break;
                            case RIGHT: ++col; break;
                        }
                        /* validate moves before executing commands */
                        if (row < 0) { ++row; System.err.println("negative row is out of bound"); break; }
                        if (col < 0) { ++col; System.err.println("negative col is out of bound"); break; }
                        if (row == floor.length) { --row; System.err.println("overshoot row is out of bound"); break; }
                        if (col == floor[0].length) { --col; System.err.println("overshoot col is out of bound"); break; }

                        floor[row][col] = Turtle.footprint;
                    }
                    break;

                case DISPLAY: displayTurtleFootprints(); break;
                case END: index = commands.length; break;
            } // end of switch

        } // end of for loop
    }

    private static void displayTurtleFootprints() {
        for (int y = 0; y < floor.length; ++y) {
            for (int x = 0; x < floor[y].length; ++x)
                System.out.printf("[%c]", floor[y][x] == STAR ? '*' : ' ');
            System.out.println();
        }
    }

} // end of class Ex07_21_TurtleGraphics
